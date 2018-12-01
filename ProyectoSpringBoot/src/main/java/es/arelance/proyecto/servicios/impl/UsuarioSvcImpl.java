package es.arelance.proyecto.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.arelance.proyecto.modelo.Usuario;
import es.arelance.proyecto.modelo.dao.DaoException;
import es.arelance.proyecto.modelo.dao.UsuarioDao;
import es.arelance.proyecto.servicios.ServiceException;
import es.arelance.proyecto.servicios.UsuarioSvc;

/**
 * Implementacion de la interfaz del servicio {@link UsuarioSvc}
 * 
 * @author Francisco Molina Sanchez
 *
 */
@Service
@Transactional
public class UsuarioSvcImpl implements UsuarioSvc {
	
	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	public Usuario acceder(String nombreUsuario, String contrasena)
			throws ServiceException {
		try {
			return usuarioDao.findByNameAndPass(nombreUsuario,
					contrasena);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Usuario obtenPorId(Integer idUsuario)
			throws ServiceException {
		try {
			return usuarioDao.findById(idUsuario);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

}
