package es.arelance.proyecto.servicios.impl;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
	private UsuarioDao dao;

	@Override
	public Usuario obtenPorId(Integer idUsuario, boolean fetch)
			throws ServiceException {
		Usuario res = null;
		try {
			res = dao.findById(idUsuario);
			if (fetch) {
				Hibernate.initialize(res.getAnalisis());
			}
			return res;
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void guardar(Usuario usuario) throws ServiceException {
		try {
			dao.save(usuario);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
	@Override
	public Usuario identificar(Usuario usuario) throws ServiceException {
		Usuario res = null;
		try{
			res = dao.findByUsernameAndPassword(usuario.getNombreUsuario(), usuario.getContrasena());
		}catch (Exception e){
			throw new ServiceException(e);
		}
		return res;
	}
}
