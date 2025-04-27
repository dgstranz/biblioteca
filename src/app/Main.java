package app;

import java.util.Map;

import enums.*;
import exceptions.*;
import model.*;
import services.*;

public class Main {
	private static Map<String, Usuario> usuarios;
	
	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca();
		GestorBibliotecas gb = new GestorBibliotecas();
		
		biblioteca.registrarRecurso(new Libro("Cien años de soledad", Fondo.GENERAL, "Gabriel García Márquez"));
		biblioteca.registrarRecurso(new Libro("Don Quijote de la Mancha", Fondo.GENERAL, "Miguel de Cervantes Saavedra"));
		biblioteca.registrarRecurso(new Libro("El pirata Garrapata", Fondo.INFANTIL, "Juan Muñoz Martín"));
		biblioteca.registrarRecurso(new Libro("La historia interminable", Fondo.INFANTIL, "Michael Ende"));
		biblioteca.registrarRecurso(new Libro("Calculus", Fondo.ESPECIAL, "Michael Spivak"));
		biblioteca.registrarRecurso(new Libro("The Art of Computer Programming", Fondo.ESPECIAL, "Donald Knuth"));
		
		gb.registrarUsuario(new Usuario("María", "Requena Sánchez", TipoUsuario.ADULTO));
		gb.registrarUsuario(new Usuario("Diego", "Aguirre García", TipoUsuario.INFANTIL));
		gb.registrarUsuario(new Usuario("Ana Isabel", "De Tomás Puente", TipoUsuario.INVESTIGADOR));
		
		try {
			System.out.println(gb.getDescripcionUsuario(5));
			System.out.println(biblioteca.getDescripcionRecurso("LIB-00003"));
		} catch(RecursoNoEncontradoException e) {
			System.err.println("Error: " + e.getMessage());
		} catch(UsuarioNoEncontradoException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
