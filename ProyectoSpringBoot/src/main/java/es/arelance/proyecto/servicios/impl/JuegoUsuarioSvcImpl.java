package es.arelance.proyecto.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.arelance.proyecto.modelo.JuegoUsuario;
import es.arelance.proyecto.modelo.Usuario;
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
@Service
@Transactional
public class JuegoUsuarioSvcImpl implements JuegoUsuarioSvc {
	
	@Autowired
	private JuegoUsuarioDao dao;

	
	@Override
	public void guardar(JuegoUsuario juegoUsuario) throws ServiceException {
		try {
			if(!dao.exist(juegoUsuario)) {
				dao.save(juegoUsuario);
			}	
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public Iterable<JuegoUsuario> listarPorUsuario(Usuario usuario) throws ServiceException {
		try {
			return dao.findByUser(usuario);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void eliminar(JuegoUsuario juegoUsuario) throws ServiceException {
		try {
			dao.delete(juegoUsuario);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

}
