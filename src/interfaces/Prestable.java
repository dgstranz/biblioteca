package interfaces;

import model.Usuario;

public interface Prestable {
	void prestar(Usuario usuario, String idRecurso);
	void devolver(Usuario usuario, String idRecurso);
}
