package es.arelance.proyecto.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Service
@Transactional
public class PlataformaSvcImpl implements PlataformaSvc {
	
	@Autowired
	private PlataformaDao dao;

	@Override
	public List<Plataforma> listar() throws ServiceException {
		try {
			return dao.findAll();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

}
