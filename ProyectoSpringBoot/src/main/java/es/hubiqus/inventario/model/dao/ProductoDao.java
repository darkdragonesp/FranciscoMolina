package es.hubiqus.inventario.model.dao;

import java.util.List;
import java.util.Optional;

import es.hubiqus.inventario.model.Producto;

public interface ProductoDao {

	/**
	 * Guardar un registro
	 * @param producto elemento a guardar
	 * @throws DaoException error de bdd
	 */
	public void save(Producto producto) throws DaoException;
	
	/**
	 * Actualizar un registro
	 * @param producto elemento a actualizar
	 * @throws DaoException error de bdd
	 */
	public void update(Producto producto) throws DaoException;
	
	/**
	 * Eliminar un registro
	 * @param producto elemento a eliminar
	 * @throws DaoException error de bdd
	 */
	public void delete(Producto producto) throws DaoException;
	
	/**
	 * Filtrar por nombre
	 * @param nombre criterio de filtrado
	 * @return lista de prodcutos
	 * @throws DaoException error de bdd
	 */
	public List<Producto> findByNombre(String nombre) throws DaoException;
	
	/**
	 * Filtrar por id
	 * @param id clave a buscar
	 * @return producto encontrado, null si no lo encuentra
	 * @throws DaoException error de bdd
	 */
	public Optional<Producto> findById(int id) throws DaoException;
	
}
