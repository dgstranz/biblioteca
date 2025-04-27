package services;

import java.util.HashMap;
import java.util.Map;

import exceptions.RecursoNoEncontradoException;
import exceptions.UsuarioNoEncontradoException;
import model.RecursoBiblioteca;
import model.Usuario;

public class GestorBibliotecas {
	/**
	 * Lista de usuarios, consultable por su identificador ({@code id}), que es de tipo numérico.
	 */
	private static Map<Long, Usuario> usuarios;
	
	/**
	 * Constructor del gestor de bibliotecas.
	 */
	public GestorBibliotecas() {
		this.usuarios = new HashMap<>();
	}

	/**
	 * Registra un usuario en el sistema de bibliotecas. Como parte del registro, le asigna un identificador.
	 * @param recurso
	 */
	public void registrarUsuario(Usuario usuario) {
		long id = usuario.incrementarContador();
		this.usuarios.put(id, usuario);
	}

	/**
	 * Obtiene un usuario a partir de su identificador.
	 * @param id
	 * @return el usuario con ese identificador
	 * @throws UsuarioNoEncontradoException
	 */
	public Usuario getUsuario(long id) throws UsuarioNoEncontradoException {
		Usuario usuario = usuarios.getOrDefault(id, null);
		if(usuario == null) {
			throw new UsuarioNoEncontradoException("No existe el usuario con ID " + id + ".");
		} else {
			return usuario;
		}
	}

	/**
	 * Devuelve una descripción de un usuario a partir de su identificador.
	 * @param id
	 * @return el identificador y el método {@code toString()} del usuario buscado
	 * @throws UsuarioNoEncontradoException
	 */
	public String getDescripcionUsuario(long id) throws UsuarioNoEncontradoException {
		Usuario usuario = getUsuario(id);
		return "ID " + id + ": " + usuario.toString();
	}
}
