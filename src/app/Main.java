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
		biblioteca.registrarRecurso(new AlbumMusical("Master of Puppets", Fondo.GENERAL, 54, FormatoDisco.CD, "Metallica"));
		biblioteca.registrarRecurso(new AlbumMusical("Sinfonía del nuevo mundo", Fondo.GENERAL, 40, FormatoDisco.CD, "Antonín Dvořák"));
		biblioteca.registrarRecurso(new AlbumMusical("Cantajuego", Fondo.INFANTIL, 40, FormatoDisco.CD, "Grupo Encanto"));
		biblioteca.registrarRecurso(new Pelicula("Interstellar", Fondo.GENERAL, 169, FormatoDisco.BLU_RAY, "Christopher Nolan"));
		biblioteca.registrarRecurso(new Pelicula("Jurassic Park", Fondo.GENERAL, 127, FormatoDisco.DVD, "Steven Spielberg"));
		biblioteca.registrarRecurso(new Pelicula("Doraemon, el gladiador", Fondo.INFANTIL, 96, FormatoDisco.DVD, "Tsutomu Shibayama"));
		biblioteca.registrarRecurso(new Revista("Muy Interesante", Fondo.GENERAL, 528));
		biblioteca.registrarRecurso(new Revista("Leo Leo", Fondo.INFANTIL, 415));
		biblioteca.registrarRecurso(new RevistaAcademica("Proceedings", 117, 1));
		
		gb.registrarUsuario(new Usuario("María", "Requena Sánchez", TipoUsuario.ADULTO));
		gb.registrarUsuario(new Usuario("Diego", "Aguirre García", TipoUsuario.INFANTIL));
		gb.registrarUsuario(new Usuario("Ana Isabel", "De Tomás Puente", TipoUsuario.INVESTIGADOR));
		
		try {
			System.out.println(gb.getDescripcionUsuario(2));
			System.out.println(biblioteca.getDescripcionRecurso("LIB-00003"));
			biblioteca.prestar(gb.getUsuario(1), "LIB-00001");
			biblioteca.prestar(gb.getUsuario(2), "PEL-00003");
			biblioteca.prestar(gb.getUsuario(2), "MUS-00003");
			biblioteca.prestar(gb.getUsuario(2), "LIB-00003");
			biblioteca.prestar(gb.getUsuario(2), "LIB-00004");
			biblioteca.prestar(gb.getUsuario(1), "ACA-00001");
			biblioteca.devolver(gb.getUsuario(1), "LIB-00001");
			biblioteca.devolver(gb.getUsuario(1), "LIB-00001");
		} catch(Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
