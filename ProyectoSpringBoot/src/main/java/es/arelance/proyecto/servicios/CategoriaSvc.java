package es.arelance.proyecto.servicios;

import es.arelance.proyecto.modelo.Categoria;

/**
 * Interfaz de la capa de servicio para gestionar {@link Categoria}
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface CategoriaSvc {
	/**
	 * Obtiene todas las instancias de {@link Categoria}
	 * 
	 * @return lista de categorias
	 * @throws ServiceException
	 */
	Iterable<Categoria> listar() throws ServiceException;
}
