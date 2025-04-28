package services;

import java.util.HashMap;
import java.util.Map;

import enums.EstadoRecurso;
import enums.Fondo;
import enums.TipoUsuario;
import exceptions.AccesoFondoNoPermitidoException;
import exceptions.IdentificadorNoValidoException;
import exceptions.LimitePrestamosAlcanzadosException;
import exceptions.RecursoNoDisponibleException;
import exceptions.RecursoNoEncontradoException;
import interfaces.Prestable;
import model.RecursoBiblioteca;
import model.Usuario;

public class Biblioteca implements Prestable {
	private Map<String, RecursoBiblioteca> recursos;
	// TODO crear un Map de reservas de un recurso (identificado por su ID) a un usuario
	
	/**
	 * Constructor de biblioteca
	 */
	public Biblioteca() {
		this.recursos = new HashMap<>();
	}

	// Getter
	public Map<String, RecursoBiblioteca> getRecursos() {
		return this.recursos;
	}
	
	/**
	 * Registra un recurso en la biblioteca. Como parte del registro, le asigna un identificador.
	 * @param recurso
	 */
	public <T extends RecursoBiblioteca> void registrarRecurso(T recurso) {
		String id = recurso.getPrefijoId() + "-" + String.format("%05d", recurso.incrementarContador());
		System.out.println(id);
		this.recursos.put(id, recurso);
	}
	
	/**
	 * Obtiene un recurso a partir de su identificador.
	 * @param id
	 * @return el recurso con ese identificador
	 * @throws IdentificadorNoValidoException
	 * @throws RecursoNoEncontradoException
	 */
	public RecursoBiblioteca getRecurso(String id) throws IdentificadorNoValidoException, RecursoNoEncontradoException {
		if(!id.matches("^[A-Z]{3}-[0-9]{5,}$")) {
			throw new IdentificadorNoValidoException("ID mal formado.");
		} else if(!this.recursos.containsKey(id)) {
			throw new RecursoNoEncontradoException("No existe el recurso con ID " + id + " en esta biblioteca.");
		}
		
		RecursoBiblioteca recurso = this.recursos.get(id);
		return recurso;
	}

	/**
	 * Devuelve una descripción de un recurso a partir de su identificador.
	 * @param id
	 * @return el identificador y el método {@code toString()} del recurso buscado
	 * @throws IdentificadorNoValidoException
	 * @throws RecursoNoEncontradoException
	 */
	public String getDescripcionRecurso(String id) throws IdentificadorNoValidoException, RecursoNoEncontradoException {
		RecursoBiblioteca recurso = getRecurso(id);
		return id + ": " + recurso.toString();
	}

	/**
	 * Realiza un préstamo a un determinado usuario de un determinado recurso, identificado por su {@code id}.
	 * @param usuario
	 * @param idRecurso
	 * @throws AccesoFondoNoPermitidoException
	 * @throws LimitePrestamosAlcanzadosException
	 * @throws RecursoNoDisponibleException
	 */
	@Override
	public void prestar(Usuario usuario, String idRecurso) {
		try {
			RecursoBiblioteca recurso = getRecurso(idRecurso);

			if(recurso.getEstado() != EstadoRecurso.DISPONIBLE) {
				throw new RecursoNoDisponibleException("El recurso con ID " + idRecurso + " no está disponible para préstamo.");
			}

			if(usuario.getRecursosEnPrestamo().size() >= usuario.getTipo().getLimitePrestamos()) {
				throw new LimitePrestamosAlcanzadosException("El usuario " + usuario.getNombre() + " " + usuario.getApellidos() + " ha alcanzado el número máximo de préstamos.");
			}

			switch(recurso.getFondo()) {
				case Fondo.GENERAL:
					if((usuario.getTipo() != TipoUsuario.ADULTO) && (usuario.getTipo() != TipoUsuario.INVESTIGADOR)) {
						throw new AccesoFondoNoPermitidoException("Solo un usuario adulto o investigador puede acceder al fondo general, y " + usuario.getNombre() + " " + usuario.getApellidos() + " no lo es.");
					}
					break;
				case Fondo.INFANTIL:
					if((usuario.getTipo() != TipoUsuario.INFANTIL)) {
						throw new AccesoFondoNoPermitidoException("Solo un usuario infantil puede acceder al fondo infantil, y " + usuario.getNombre() + " " + usuario.getApellidos() + " no lo es.");
					}
					break;
				case Fondo.ESPECIAL:
					if((usuario.getTipo() != TipoUsuario.INVESTIGADOR)) {
						throw new AccesoFondoNoPermitidoException("Solo un usuario investigador puede acceder al fondo especial, y " + usuario.getNombre() + " " + usuario.getApellidos() + " no lo es.");
					}
					break;
				default:
					throw new AccesoFondoNoPermitidoException("Fondo no contemplado en el sistema.");
			}
			
			recurso.setEstado(EstadoRecurso.PRESTADO);
			usuario.getRecursosEnPrestamo().put(idRecurso, recurso);
			System.out.println("Se ha realizado el préstamo de " + recurso.getTitulo() + " a " + usuario.getNombre() + " " + usuario.getApellidos() + ".");
		} catch(Exception e) {
			System.err.println("Error: " + e.getMessage());
			System.out.println("No se pudo realizar el préstamo del recurso solicitado.");
		}
	}

	/**
	 * Realiza la devolución de un determinado recurso, identificado por su {@code id}, a la biblioteca.
	 * @param usuario
	 * @param idRecurso
	 * @throws RecursoNoEncontradoException
	 */
	@Override
	public void devolver(Usuario usuario, String idRecurso) {
		try {
			RecursoBiblioteca recurso = getRecurso(idRecurso);
			
			if(!usuario.getRecursosEnPrestamo().containsKey(idRecurso)) {
				throw new RecursoNoEncontradoException("El usuario no tiene el recurso con ID " + idRecurso + ".");
			}
			
			recurso.setEstado(EstadoRecurso.DISPONIBLE);
			usuario.getRecursosEnPrestamo().remove(idRecurso, recurso);
			System.out.println("Se ha realizado la devolución de " + recurso.getTitulo() + ".");
		} catch(Exception e) {
			System.err.println("Error: " + e.getMessage());
			System.out.println("No se pudo realizar la devolución del recurso solicitado.");
		}
	}
}
