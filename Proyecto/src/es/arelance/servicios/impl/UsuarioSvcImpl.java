package es.arelance.servicios.impl;

import es.arelance.proyecto.modelo.Usuario;
import es.arelance.proyecto.modelo.dao.DaoException;
import es.arelance.proyecto.modelo.dao.UsuarioDao;
import es.arelance.proyecto.servicios.ServiceException;
import es.arelance.proyecto.servicios.UsuarioSvc;

public class UsuarioSvcImpl implements UsuarioSvc {
	private UsuarioDao usuarioDao;

	@Override
	public Usuario acceder(String nombreUsuario, String contrasena)
			throws ServiceException {
		try {
			return usuarioDao.findByNameAndPass(nombreUsuario, contrasena);
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
