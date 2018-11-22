package es.arelance.proyecto.modelo.dao;

import java.util.List;

import es.arelance.proyecto.modelo.Categoria;

/**
 * Interfaz DAO para la entidad {@link Categoria}
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface CategoriaDao {
	/**
	 * Obtiene todas las instancias de {@link Categoria} disponibles
	 * 
	 * @return lista de categorias
	 * @throws DaoException
	 *             error relativo a la base de datos
	 */
	List<Categoria> getAll() throws DaoException;
}
