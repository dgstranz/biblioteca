package enums;

/**
 * Tipo de usuario del sistema de bibliotecas. Según el tipo de usuario, podrá tomar prestados más o menos libros de uno o varios fondos.
 * @see Fondo
 */
public enum TipoUsuario {
	INFANTIL(3),
	ADULTO(3),
	INVESTIGADOR(5);
	
	/**
	 * Número de recursos que cada tipo de usuario puede tomar prestados.
	 */
	private final int limitePrestamos;

	/**
	 * Constructor del tipo de usuario.
	 * @param limitePrestamos
	 */
	private TipoUsuario(int limitePrestamos) {
		this.limitePrestamos = limitePrestamos;
	}
	
	/**
	 * Getter para el límite de préstamos.
	 * @return limitePrestamos
	 */
	public int getLimitePrestamos() {
		return limitePrestamos;
	}
}
