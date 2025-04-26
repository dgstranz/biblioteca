package interfaces;

import model.RecursoBiblioteca;
import model.Usuario;

public interface Prestable {
	boolean prestar(Usuario usuario, RecursoBiblioteca recurso);
	boolean devolver(Usuario usuario, RecursoBiblioteca recurso);
}
