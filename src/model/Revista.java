package model;

import enums.Fondo;

public class Revista extends RecursoBiblioteca {
	/**
	 * El número de objetos registrados de este recurso.
	 */
	private static long contador = 0;

	/**
	 * Prefijo de clase para la generación de un ID.
	 * @see services.Biblioteca
	 */
	private static final String PREFIJO_ID = "REV";
	
	/**
	 * Número de edición de la revista.
	 */
	protected int numero;
	
	/**
	 * Constructor de la clase.
	 */
	public Revista(String titulo, Fondo fondo, int numero) {
		super(titulo, fondo);
		this.numero = numero;
	}
	
	// Getters y setters
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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
		return this.titulo + " n.º " + this.numero + " [FONDO " + this.fondo + "] [ESTADO " + this.estado + "]";
	}
}