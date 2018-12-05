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
	 */
	void guardar(Analisis analisis) throws ServiceException;

	/**
	 * Filtra los {@link Analisis} por {@link Juego} y/o {@link Usuario}
	 * 
	 * @param juego
	 *            {@link Juego}
	 * @param usuario
	 *            {@link Usuario}
	 * @return Lista de {@link Analisis} que cumplen el filtro
	 * @throws ServiceException
	 */
	Iterable<Analisis> filtrar(Juego juego, Usuario usuario)
			throws ServiceException;

}
