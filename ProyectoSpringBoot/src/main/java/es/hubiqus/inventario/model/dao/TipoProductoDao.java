package es.hubiqus.inventario.model.dao;

import es.hubiqus.inventario.model.TipoProducto;

public interface TipoProductoDao {

	/**
	 * Listado completo
	 * @return lista de tipos
	 * @throws DaoException error al buscar
	 */
	public Iterable<TipoProducto> findAll() throws DaoException;
	
}
