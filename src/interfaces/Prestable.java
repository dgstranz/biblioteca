package interfaces;

import model.RecursoBiblioteca;
import model.Usuario;

public interface Prestable {
	boolean prestar(Usuario usuario, String idRecurso);
	boolean devolver(Usuario usuario, String idRecurso);
}
