package es.arelance.proyecto.servicios;

import es.arelance.proyecto.modelo.Analisis;

/**
 * Interfaz de la capa de servicio para gestionar los {@link Analisis}
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface AnalisisSvc {
	/**
	 * Agrega un analisis nuevo al sistema
	 * 
	 * @param analisis
	 *            {@link Analisis} a agregar
	 * @throws ServiceException
	 */
	void guardar(Analisis analisis) throws ServiceException;

	/**
	 * Elimina un {@link Analisis} del sistema
	 * 
	 * @param analisis
	 *            Identificador del {@link Analisis}
	 * @throws ServiceException
	 */
	void eliminar(Analisis analisis) throws ServiceException;

}
