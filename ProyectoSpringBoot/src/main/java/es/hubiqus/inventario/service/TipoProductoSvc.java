package es.hubiqus.inventario.service;

import es.hubiqus.inventario.model.TipoProducto;

public interface TipoProductoSvc {
	
	/**
	 * Listar todos los elementos
	 * @return lista completa de elementos
	 * @throws SvcException
	 */
	public Iterable<TipoProducto> listar() throws SvcException;

}
