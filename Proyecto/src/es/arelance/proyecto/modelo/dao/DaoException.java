package es.arelance.proyecto.modelo.dao;

/**
 * Clase para excepciones DAO
 * 
 * @author Francisco Molina Sanchez
 *
 */
public class DaoException extends Exception {

	private static final long serialVersionUID = 5833025897758340128L;

	public DaoException() {

	}

	public DaoException(String msg) {
		super(msg);
	}

	public DaoException(Exception ex) {
		super(ex);
	}
}
