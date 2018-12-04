package es.arelance.proyecto.modelo.dao;

import java.util.List;

import es.arelance.proyecto.modelo.Plataforma;

/**
 * Interfaz DAO para la entidad {@link Plataforma}
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface PlataformaDao {
	/**
	 * Obtiene todas las instancias de {@link Plataforma} disponibles
	 * 
	 * @return Lista de plataformas
	 * @throws DaoException
	 *             Error relativo a la base de datos
	 */
	List<Plataforma> findAll() throws DaoException;

	/**
	 * Obtiene la {@link Plataforma} dado su identificador
	 * 
	 * @param idPlataforma
	 *            Identificador de la {@link Plataforma}
	 * @return {@link Plataforma}
	 * @throws DaoException
	 *             Error relativo a la base de datos
	 */
	Plataforma findById(int idPlataforma) throws DaoException;
}
