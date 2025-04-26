package app;

import java.util.Map;

import enums.*;
import model.*;
import services.Biblioteca;

public class Main {
	private static Map<String, RecursoBiblioteca> recursos;
	private static Map<String, Usuario> usuarios;
	
	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca();
		
		Libro l1 = new Libro("Cien años de soledad", Fondo.GENERAL, "Gabriel García Márquez");
		Libro l2 = new Libro("Don Quijote de la Mancha", Fondo.GENERAL, "Miguel de Cervantes Saavedra");
		Libro l3 = new Libro("El pirata Garrapata", Fondo.INFANTIL, "Juan Muñoz Martín");
		Libro l4 = new Libro("La historia interminable", Fondo.INFANTIL, "Michael Ende");
		Libro l5 = new Libro("Calculus", Fondo.ESPECIAL, "Michael Spivak");
		Libro l6 = new Libro("The Art of Computer Programming", Fondo.ESPECIAL, "Donald Knuth");
		System.out.println(l6.toString());
		
		recursos.put("LIB-00001", l6);
	}
}
