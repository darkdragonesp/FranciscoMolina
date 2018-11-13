package es.arelance.proyecto.servicios;

import java.util.List;

import es.arelance.proyecto.modelo.Categoria;

/**
 * Servicio para categoria dao
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface CategoriaSvc {
	/**
	 * Obtiene todas las categorias disponibles
	 * 
	 * @return lista de categorias
	 */
	List<Categoria> listar() throws ServiceException;
}
