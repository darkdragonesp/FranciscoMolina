package es.arelance.proyecto.modelo.dao;

import java.util.List;

import es.arelance.proyecto.modelo.Plataforma;

/**
 * Dao para la entidad plataforma
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface PlataformaDao {
	/**
	 * Obtiene todas las plataformas disponibles
	 * 
	 * @return lista de plataformas
	 */
	List<Plataforma> getAll() throws DaoException;
}
