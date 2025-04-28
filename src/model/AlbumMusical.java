package model;

import enums.Fondo;
import enums.FormatoDisco;

public class AlbumMusical extends Disco {
	/**
	 * El número de objetos registrados de este recurso.
	 */
	private static long contador = 0;

	/**
	 * Prefijo de clase para la generación de un ID.
	 * @see services.Biblioteca
	 */
	private static final String PREFIJO_ID = "MUS";

	/**
	 * El nombre del artista o grupo del álbum musical.
	 */
	private String autor;
	
	/**
	 * Constructor de la clase.
	 */
	public AlbumMusical(String titulo, Fondo fondo, int duracion, FormatoDisco formato, String autor) {
		super(titulo, fondo, duracion, formato, autor);
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
		return this.titulo + " (" + this.autor + ") " + this.duracion + " min, [" + this.formato + "] [FONDO " + this.fondo + "] [ESTADO " + this.estado + "]";
	}
}
