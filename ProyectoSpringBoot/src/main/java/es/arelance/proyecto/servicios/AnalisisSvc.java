package es.arelance.proyecto.servicios;

import es.arelance.proyecto.modelo.Analisis;
import es.arelance.proyecto.modelo.Juego;
import es.arelance.proyecto.modelo.Usuario;

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
	 *             Error relativo a la capa DAO
	 */
	void guardar(Analisis analisis) throws ServiceException;

	/**
	 * Elimina un {@link Analisis} del sistema
	 * 
	 * @param analisis
	 *            Identificador del {@link Analisis}
	 * @throws ServiceException
	 *             Error relativo a la capa DAO
	 */
	void eliminar(Analisis analisis) throws ServiceException;

	/**
	 * Calcula la media de los {@link Analisis} de un {@link Juego}
	 * 
	 * @param idJuego
	 *            Identificador del {@link Juego}
	 * @return Media de los {@link Analisis} de un {@link Juego}
	 * @throws ServiceException
	 *             Error relativo a la capa DAO
	 */
	Integer notaMedia(int idJuego) throws ServiceException;

	/**
	 * Comprueba si ya existe un {@link Analisis} de un {@link Juego} y
	 * {@link Usuario} para no crear duplicidad
	 * 
	 * @param analisis
	 *            {@link Analisis}
	 * @return {@code true} si existe; {@code false} en otro caso
	 * @throws ServiceException
	 *             Error relativo a la capa DAO
	 */
	boolean existe(Analisis analisis) throws ServiceException;
}
