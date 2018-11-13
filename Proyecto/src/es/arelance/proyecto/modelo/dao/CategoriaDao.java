package es.arelance.proyecto.modelo.dao;

import java.util.List;

import es.arelance.proyecto.modelo.Categoria;

/**
 * Interfaz para la entidad categoria
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface CategoriaDao {
	/**
	 * Obtiene todas las categorias disponibles
	 * 
	 * @return lista de categorias
	 */
	List<Categoria> getAll() throws DaoException;
}
