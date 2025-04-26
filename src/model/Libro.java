package model;

import enums.Fondo;

public class Libro extends RecursoBiblioteca {
	private String autor;
	private static int contador = 0;
	
	/**
	 * Constructor heredado.
	 * @param autor
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
	
	/**
	 * Genera un identificador de tipo LIB-01234.
	 * El número puede tener más de 5 cifras, pero si tiene menos se rellenarán con ceros
	 */
	@Override
	public String generarId() {
		return "LIB-" + String.format("%05d", ++contador);
	}

	@Override
	public String toString() {
		return id + ": " + titulo + " (" + autor + ") [FONDO " + fondo + "] [ESTADO " + estado + "]";
	}
	
	
}
