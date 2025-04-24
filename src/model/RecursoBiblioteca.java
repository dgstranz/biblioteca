package model;

import enums.EstadoRecurso;
import enums.Fondo;

public abstract class RecursoBiblioteca {
	protected String id;
	protected String titulo;
	protected Fondo fondo;
	protected EstadoRecurso estado;
	
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

	protected abstract String generarId();
}
