package es.arelance.proyecto.servicios;

import java.util.List;

import es.arelance.proyecto.modelo.Categoria;

/**
 * Interfaz de la capa de servicio para gestionar {@link Categoria}
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface CategoriaSvc {
	/**
	 * Obtiene todas las categorias disponibles
	 * 
	 * @return lista de categorias
	 * @throws ServiceException
	 */
	List<Categoria> listar() throws ServiceException;
}
