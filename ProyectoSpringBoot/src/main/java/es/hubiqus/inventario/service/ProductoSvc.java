package es.hubiqus.inventario.service;

import es.hubiqus.inventario.model.Producto;

public interface ProductoSvc {

	/**
	 * Guardar un elemento
	 * @param producto elemento a guardar
	 * @throws SvcException
	 */
	public void guardar(Producto producto) throws SvcException;
	
	/**
	 * Actualizar un elemento
	 * @param producto elemento a actualizar
	 * @throws SvcException
	 */
	public void modificar(Producto producto) throws SvcException;
	
	/**
	 * Eliminar un elemento
	 * @param producto elemento a eliminar
	 * @throws SvcException
	 */
	public void eliminar(Producto producto) throws SvcException;
	
	/**
	 * Listar todos los elementos
	 * @return lista completa de elementos
	 * @throws SvcException
	 */
	public Iterable<Producto> listar() throws SvcException;
	
	/**
	 * Filtrar por id
	 * @param id clave a buscar
	 * @return producto encontrado, null si no lo encuentra
	 * @throws SvcException
	 */
	public Producto buscar(int id) throws SvcException;
}
