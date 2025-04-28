package model;

import enums.Fondo;
import enums.FormatoDisco;

public abstract class Disco extends RecursoBiblioteca {
	/**
	 * Duración del disco.
	 */

	protected int duracion;

	/**
	 * Formato del disco (CD, DVD, Blu-Ray).
	 * @see enum.FormatoDisco
	 */
	protected FormatoDisco formato;

	/**
	 * Autor del disco. Puede ser el artista o grupo de un disco musical o el director de una película.
	 */
	protected String autor;

	/**
	 * Constructor heredado.
	 * @param {@code autor}, el autor del disco.
	 * @param autor
	 */
	public Disco(String titulo, Fondo fondo, int duracion, FormatoDisco formato, String autor) {
		super(titulo, fondo);
		this.duracion = duracion;
		this.formato = formato;
		this.autor = autor;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public FormatoDisco getFormato() {
		return formato;
	}

	public void setFormato(FormatoDisco formato) {
		this.formato = formato;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return this.titulo + " (" + this.autor + ") " + this.duracion + " min, [" + this.formato + "] [FONDO " + this.fondo + "] [ESTADO " + this.estado + "]";
	}
}
