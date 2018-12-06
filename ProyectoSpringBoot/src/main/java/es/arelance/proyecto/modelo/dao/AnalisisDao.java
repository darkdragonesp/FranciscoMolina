package es.arelance.proyecto.modelo.dao;

import es.arelance.proyecto.modelo.Analisis;
import es.arelance.proyecto.modelo.Juego;
import es.arelance.proyecto.modelo.Usuario;

/**
 * Interfaz DAO para la entidad {@link Analisis}
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface AnalisisDao {
	/**
	 * Guarda un {@link Analisis} de un {@link Juego} y {@link Usuario}
	 * 
	 * @param analisis
	 *            {@link Analisis}
	 * @throws DaoException
	 *             Error relativo a la base de datos
	 */
	void save(Analisis analisis) throws DaoException;

	/**
	 * Comprueba si ya existe un {@link Analisis} de un {@link Juego} y
	 * {@link Usuario} para no crear duplicidad
	 * 
	 * @param analisis
	 *            {@link Analisis}
	 * @return {@code true} si existe; {@code false} en otro caso
	 * @throws DaoException
	 *             Error relativo a la base de datos
	 */
	boolean exist(Analisis analisis) throws DaoException;

}
