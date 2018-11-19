package es.arelance.proyecto.servicios.impl;

import java.util.List;

import es.arelance.proyecto.modelo.Categoria;
import es.arelance.proyecto.modelo.dao.CategoriaDao;
import es.arelance.proyecto.modelo.dao.DaoException;
import es.arelance.proyecto.servicios.CategoriaSvc;
import es.arelance.proyecto.servicios.ServiceException;
/**
 * Implementacion de la interfaz del servicio {@link CategoriaSvc}
 * 
 * @author Francisco Molina Sanchez
 *
 */
public class CategoriaSvcImpl implements CategoriaSvc {
	private CategoriaDao dao;
	
	@Override
	public List<Categoria> listar() throws ServiceException {
		try {
			return dao.getAll();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

}
