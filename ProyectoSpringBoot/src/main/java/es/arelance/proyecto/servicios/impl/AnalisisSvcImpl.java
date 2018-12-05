package es.arelance.proyecto.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.arelance.proyecto.modelo.Analisis;
import es.arelance.proyecto.modelo.Juego;
import es.arelance.proyecto.modelo.Usuario;
import es.arelance.proyecto.modelo.dao.DaoException;
import es.arelance.proyecto.servicios.AnalisisSvc;
import es.arelance.proyecto.servicios.ServiceException;

/**
 * Implementacion de la interfaz del servicio {@link AnalisisSvc}
 * 
 * @author Francisco Molina Sanchez
 *
 */
@Service
@Transactional
public class AnalisisSvcImpl implements AnalisisSvc {

	@Autowired
	private Analisis dao;

	@Override
	public void guardar(Analisis analisis) throws ServiceException {
		try {
			if (!dao.exist(analisis)) {
				dao.save(analisis);
			}
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public Iterable<Analisis> filtrar(Juego juego, Usuario usuario)
			throws ServiceException {
		try {
			return dao.filter(juego, usuario);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

}