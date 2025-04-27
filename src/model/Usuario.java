package model;

import java.util.HashMap;
import java.util.Map;

import enums.TipoUsuario;

public class Usuario {
	/**
	 * Contador de usuarios. Es un número que se incrementa cada vez que se registra un usuario.
	 */
	private static long contador = 0;

	/**
	 * Nombre del usuario.
	 */
	private String nombre;

	/**
	 * Apellido o apellidos del usuario.
	 */
	private String apellidos;

	/**
	 * Tipo de usuario.
	 * @see enums.TipoUsuario
	 */
	private TipoUsuario tipo;

	/**
	 * Recursos que el usuario tiene en préstamo.
	 */
	private Map<String, RecursoBiblioteca> recursosEnPrestamo;
	
	/**
	 * Constructor de usuario.
	 * @param nombre
	 * @param apellidos
	 * @param tipo
	 */
	public Usuario(String nombre, String apellidos, TipoUsuario tipo) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.tipo = tipo;
		this.recursosEnPrestamo = new HashMap<>();
	}

	// Getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public Map<String, RecursoBiblioteca> getRecursosEnPrestamo() {
		return recursosEnPrestamo;
	}

	/**
	 * Suma 1 al contador de usuarios y lo devuelve.
	 * @return {@code contador}, una vez incrementado en una unidad
	 */
	public long incrementarContador() {
		return ++contador;
	}
	
	public String toString() {
		return this.nombre + " " + this.apellidos + " [USUARIO " + this.tipo.toString() + "] " +
				"\nRecursos en préstamo: " + this.recursosEnPrestamo.size() + " (máx. " + this.tipo.getLimitePrestamos() + ")";
	}
}
