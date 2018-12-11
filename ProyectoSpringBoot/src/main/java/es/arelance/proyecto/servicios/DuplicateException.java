package es.arelance.proyecto.servicios;

/**
 * Excepcion personalizada para excepciones de la capa de servicios. Se lanza
 * cuando se intenta guardar un objeto que no debería guardarse por duplicidad
 * pero que la base de datos guarda sin problema
 * 
 * @author Francisco Molina Sanchez
 *
 */
public class DuplicateException extends ServiceException {

	private static final long serialVersionUID = -6145126718552137265L;

	public DuplicateException() {

	}

	public DuplicateException(String msg) {
		super(msg);
	}

	public DuplicateException(Exception ex) {
		super(ex);
	}
}
