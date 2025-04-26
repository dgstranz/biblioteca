package model;

import enums.EstadoRecurso;
import enums.Fondo;

public abstract class RecursoBiblioteca {
	/**
	 * Identificador del recurso. Es una cadena de texto formada por un código para el tipo de recurso y una parte numérica.
	 */
	protected String id;
	/**
	 * Título del recurso
	 */
	protected String titulo;
	/**
	 * Fondo de la biblioteca al que pertenece el recurso.
	 * @see enums.Fondo
	 */
	protected Fondo fondo;
	/**
	 * Estado del recurso.
	 * @see enums.EstadoRecurso
	 */
	protected EstadoRecurso estado;
	
	/**
	 * Constructor por defecto.
	 * El atributo 'estado' se inicializa a {@code EstadoRecurso.DISPONIBLE}.
	 * @param titulo representa el título del recurso.
	 * @param fondo representa el fondo de la biblioteca al que pertenece el recurso.
	 */
	public RecursoBiblioteca(String titulo, Fondo fondo) {
		this.titulo = titulo;
		this.fondo = fondo;
		this.estado = EstadoRecurso.DISPONIBLE;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Fondo getFondo() {
		return fondo;
	}

	public void setFondo(Fondo fondo) {
		this.fondo = fondo;
	}

	public EstadoRecurso getEstado() {
		return estado;
	}

	public void setEstado(EstadoRecurso estado) {
		this.estado = estado;
	}

	/**
	 * Método abstracto para generar un identificador.
	 */
	public abstract String generarId();
}
