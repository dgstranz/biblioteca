package services;

import java.util.HashMap;
import java.util.Map;

import exceptions.RecursoNoEncontradoException;
import exceptions.UsuarioNoEncontradoException;
import interfaces.Prestable;
import model.RecursoBiblioteca;
import model.Usuario;

public class Biblioteca implements Prestable {
	private Map<String, RecursoBiblioteca> recursos;
	
	public Biblioteca() {
		this.recursos = new HashMap<>();
	}

	@Override
	public boolean prestar(Usuario usuario, RecursoBiblioteca recurso) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean devolver(Usuario usuario, RecursoBiblioteca recurso) {
		// TODO Auto-generated method stub
		return false;
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
	 * @throws RecursoNoEncontradoException
	 */
	public RecursoBiblioteca getRecurso(String id) throws RecursoNoEncontradoException {
		RecursoBiblioteca recurso = this.recursos.getOrDefault(id, null);
		if(recurso == null) {
			throw new RecursoNoEncontradoException("No existe el recurso con ID " + id + ".");
		} else {
			return recurso;
		}
	}

	/**
	 * Devuelve una descripción de un recurso a partir de su identificador.
	 * @param id
	 * @return el identificador y el método {@code toString()} del recurso buscado
	 * @throws RecursoNoEncontradoException
	 */
	public String getDescripcionRecurso(String id) throws RecursoNoEncontradoException {
		RecursoBiblioteca recurso = getRecurso(id);
		return id + ": " + recurso.toString();
	}
}
