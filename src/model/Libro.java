package model;

import enums.Fondo;

public class Libro extends RecursoBiblioteca {
	private String isbn;
	private static int contador = 0;
	
	public Libro(String titulo, Fondo fondo, String isbn) {
		super(titulo, fondo);
		this.isbn = isbn;
		this.id = generarId();
	}
	
	@Override
	protected String generarId() {
		return "LIB" + (++contador);
	}
}
