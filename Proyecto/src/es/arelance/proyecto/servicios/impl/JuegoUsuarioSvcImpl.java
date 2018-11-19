package es.arelance.proyecto.servicios.impl;

import java.util.List;

import es.arelance.proyecto.modelo.JuegoUsuario;
import es.arelance.proyecto.modelo.dao.DaoException;
import es.arelance.proyecto.modelo.dao.JuegoUsuarioDao;
import es.arelance.proyecto.servicios.JuegoUsuarioSvc;
import es.arelance.proyecto.servicios.ServiceException;

/**
 * Implementacion de la interfaz del servicio {@link JuegoUsuarioSvc}
 * 
 * @author Francisco Molina Sanchez
 *
 */
public class JuegoUsuarioSvcImpl implements JuegoUsuarioSvc {
	private JuegoUsuarioDao dao;

	@Override
	public void anadir(JuegoUsuario juegoUsuario) throws ServiceException {
		try {
			if (!dao.exist(juegoUsuario)) {
				dao.add(juegoUsuario);
			}
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public List<JuegoUsuario> obtenPorId(Integer idUsuario) throws ServiceException {
		try {
			return dao.getAllById(idUsuario);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

}
