package es.arelance.proyecto.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.arelance.proyecto.modelo.Analisis;
import es.arelance.proyecto.modelo.dao.AnalisisDao;
import es.arelance.proyecto.servicios.AnalisisSvc;
import es.arelance.proyecto.servicios.DuplicateException;
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
	private AnalisisDao dao;

	@Override
	public void guardar(Analisis analisis) throws ServiceException {
		try {
			if (!dao.existsByUsuarioAndJuego(analisis.getUsuario(), analisis.getJuego())) {
				dao.save(analisis);
			} else {
				throw new DuplicateException();
			}
		} catch (Exception e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void eliminar(Analisis analisis) throws ServiceException {
		try {
			dao.delete(analisis);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Integer notaMedia(int idJuego) throws ServiceException {
		Integer res = null;
		try {
			res = dao.avg(idJuego);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return res;
	}

	@Override
	public boolean existe(Analisis analisis) throws ServiceException {
		try {
			return dao.existsByUsuarioAndJuego(analisis.getUsuario(), analisis.getJuego());
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}
}
