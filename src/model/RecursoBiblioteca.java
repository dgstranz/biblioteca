package model;

import enums.EstadoRecurso;
import enums.Fondo;

public abstract class RecursoBiblioteca {
	/**
	 * Prefijo de clase para la generación de un ID.
	 * @see services.Biblioteca
	 */
	protected static final String PREFIJO_ID = "XXX";
	private static long contador = 0;
	
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

	// Getters y setters
	public long getContador() {
		return contador;
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

	// Funciones abstractas
	public abstract String getPrefijoId();
	public abstract long incrementarContador();
}
