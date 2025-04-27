package model;

import enums.Fondo;

public class Libro extends RecursoBiblioteca {
	/**
	 * El número de objetos registrados de este recurso.
	 */
	private static long contador = 0;

	/**
	 * Prefijo de clase para la generación de un ID.
	 * @see services.Biblioteca
	 */
	private static final String PREFIJO_ID = "LIB";

	/**
	 * El nombre completo del autor del libro.
	 */
	private String autor;
	
	/**
	 * Constructor heredado.
	 * @param {@code autor}, el autor del libro.
	 * @param autor a
	 */
	public Libro(String titulo, Fondo fondo, String autor) {
		super(titulo, fondo);
		this.autor = autor;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public long getContador() {
		return contador;
	}

	@Override
	public String getPrefijoId() {
		return PREFIJO_ID;
	}
	
	/**
	 * Suma 1 al contador y lo devuelve.
	 * @return {@code contador}, una vez incrementado en una unidad
	 */
	@Override
	public long incrementarContador() {
		return ++contador;
	}

	@Override
	public String toString() {
		return titulo + " (" + autor + ") [FONDO " + fondo + "] [ESTADO " + estado + "]";
	}
}
