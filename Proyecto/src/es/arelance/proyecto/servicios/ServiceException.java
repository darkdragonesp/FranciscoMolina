package es.arelance.proyecto.servicios;

/**
 * Clase para excepciones de la capa de servicios
 * 
 * @author Francisco Molina Sanchez
 *
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = -1810418656422508108L;

	public ServiceException() {

	}
	public ServiceException(String msg) {
		super(msg);
	}

	public ServiceException(Exception ex) {
		super(ex);
	}
}
