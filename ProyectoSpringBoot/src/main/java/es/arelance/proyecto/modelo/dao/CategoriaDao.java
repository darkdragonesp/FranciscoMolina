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
	List<Categoria> findAll() throws DaoException;

	/**
	 * Busca la {@link Categoria} dado su identificador
	 * 
	 * @param idCategoria
	 *            identificador de {@link Categoria}
	 * @return {@link Categoria}
	 * @throws DaoException
	 *             error relativo a la base de datos
	 */
	Categoria findById(int idCategoria) throws DaoException;
}
