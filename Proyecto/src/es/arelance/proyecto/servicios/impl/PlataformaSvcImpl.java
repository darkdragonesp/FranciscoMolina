package es.arelance.proyecto.servicios.impl;

import java.util.List;

import es.arelance.proyecto.modelo.Plataforma;
import es.arelance.proyecto.modelo.dao.DaoException;
import es.arelance.proyecto.modelo.dao.PlataformaDao;
import es.arelance.proyecto.servicios.PlataformaSvc;
import es.arelance.proyecto.servicios.ServiceException;

/**
 * Implementacion de la interfaz del servicio {@link PlataformaSvc}
 * 
 * @author Francisco Molina Sanchez
 *
 */
public class PlataformaSvcImpl implements PlataformaSvc {
	private PlataformaDao dao;

	@Override
	public List<Plataforma> listar() throws ServiceException {
		try {
			return dao.getAll();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

}
