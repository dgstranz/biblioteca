package model;

import enums.Fondo;

public class RevistaAcademica extends Revista {
	/**
	 * El número de objetos registrados de este recurso.
	 */
	private static long contador = 0;

	/**
	 * Prefijo de clase para la generación de un ID.
	 * @see services.Biblioteca
	 */
	private static final String PREFIJO_ID = "ACA";
	
	/**
	 * Volumen (conjunto de números publicados en un mismo año) de la revista.
	 */
	private int volumen;
	
	/**
	 * Constructor de la clase. Todas las revistas académicas pertenecen al fondo especial de investigación.
	 */
	public RevistaAcademica(String titulo, int volumen, int numero) {
		super(titulo, Fondo.ESPECIAL, numero);
		this.volumen = volumen;
	}
	
	// Getters y setters
	public int getVolumen() {
		return volumen;
	}

	public void setVolumen(int volumen) {
		this.volumen = volumen;
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
		return this.titulo + " " + this.volumen + " (" + this.numero + ") [FONDO " + this.fondo + "] [ESTADO " + this.estado + "]";
	}
}