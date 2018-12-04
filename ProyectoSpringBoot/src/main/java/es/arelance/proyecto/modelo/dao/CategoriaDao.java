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
	 * @return Lista de categorias
	 * @throws DaoException
	 *             Error relativo a la base de datos
	 */
	List<Categoria> findAll() throws DaoException;

	/**
	 * Busca la {@link Categoria} dado su identificador
	 * 
	 * @param idCategoria
	 *            Identificador de {@link Categoria}
	 * @return {@link Categoria}
	 * @throws DaoException
	 *             Error relativo a la base de datos
	 */
	Categoria findById(int idCategoria) throws DaoException;
}
