package es.arelance.proyecto.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.arelance.proyecto.modelo.Juego;
import es.arelance.proyecto.modelo.dao.DaoException;
import es.arelance.proyecto.modelo.dao.JuegoDao;
import es.arelance.proyecto.servicios.JuegoSvc;
import es.arelance.proyecto.servicios.ServiceException;

/**
 * Implementacion de la interfaz del servicio {@link JuegoSvc}
 * 
 * @author Francisco Molina Sanchez
 *
 */
@Service
@Transactional
public class JuegoSvcImpl implements JuegoSvc {
	
	@Autowired
	private JuegoDao dao;
	

	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void agregar(Juego juego) throws ServiceException {
		try {
			dao.save(juego);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Iterable<Juego> listar() throws ServiceException {
		try {
			return dao.findAll();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Juego> filtrar(String titulo, String categoria, String plataforma)
			throws ServiceException {
		try {
			return dao.filter(titulo, categoria, plataforma);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void eliminar(Juego juego) throws ServiceException {
		try {
			dao.delete(juego);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void modificar(Juego juego) throws ServiceException {
		try {
			dao.update(juego);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

}
