package services;

import java.util.HashMap;
import java.util.Map;

import interfaces.Prestable;
import model.RecursoBiblioteca;
import model.Usuario;

public class Biblioteca implements Prestable {
	private Map<String, RecursoBiblioteca> recursos;
	
	public Biblioteca() {
		this.recursos = new HashMap<>();
	}

	@Override
	public boolean prestar(Usuario usuario, RecursoBiblioteca recurso) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean devolver(Usuario usuario, RecursoBiblioteca recurso) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public <T extends RecursoBiblioteca> void registrarRecurso(T recurso) {
		this.recursos.put(recurso.generarId(), recurso);
	}
}
