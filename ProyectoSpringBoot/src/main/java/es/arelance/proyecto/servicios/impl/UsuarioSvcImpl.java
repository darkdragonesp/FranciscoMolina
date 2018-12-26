package es.arelance.proyecto.servicios.impl;

import java.util.Optional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.arelance.proyecto.modelo.Usuario;
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

	private static final String URI_INICIO = "inicio";
	private static final String URI_VIEW = "view";
	private static final String URI_LIST = "list";
	private static final String URI_USUARIO = "usuario";
	private static final String URI_ANALISIS = "analisis";

	@Autowired
	private UsuarioDao dao;

	@Override
	public Usuario obtenPorId(Integer idUsuario, boolean fetch)
			throws ServiceException {
		Usuario res = null;
		try {
			Optional<Usuario> user = dao.findById(idUsuario);
			if(user.isPresent()) {
				res=user.get();
				if (fetch) {
					Hibernate.initialize(res.getAnalisis());
				}
			}

			return res;
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void guardar(Usuario usuario) throws ServiceException {
		try {
			dao.save(usuario);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Usuario identificar(Usuario usuario) throws ServiceException {
		Usuario res = null;
		try {
			res = dao.findByNombreUsuarioAndContrasena(usuario.getNombreUsuario(),
					usuario.getContrasena());
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return res;
	}

	@Override
	public boolean comprobar(Usuario usuario, String uri)
			throws ServiceException {
		switch (usuario.getTipoUsuario().getIdTipo()) {
		// Administrador
		case 1:
			return true;
		// Usuario normal
		case 2:
			return (uri.contains(URI_INICIO) || uri.contains(URI_USUARIO)
					|| uri.contains(URI_VIEW) || uri.contains(URI_LIST)
					|| uri.contains(URI_ANALISIS));
		default:
			return false;
		}
	}
}
