package es.arelance.proyecto.modelo.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.arelance.proyecto.modelo.Usuario;
import es.arelance.proyecto.modelo.dao.DaoException;
import es.arelance.proyecto.modelo.dao.UsuarioDao;

/**
 * Implementación de la interfaz del DAO {@link UsuarioDao}
 * 
 * @author Francisco Molina Sanchez
 *
 */
@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Usuario findByUsernameAndPassword(String nombreUsuario,
			String contrasena) throws DaoException {
		Usuario res = null;
		try {
			String hql = "FROM Usuario u "
					+ "WHERE u.nombreUsuario =:nombreUsuario "
					+ "AND u.contrasena =:contrasena ";
			res = (Usuario) sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("nombreUsuario", nombreUsuario)
					.setParameter("contrasena", contrasena).uniqueResult();
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

		return res;
	}

	@Override
	public Usuario findById(Integer idUsuario) throws DaoException {
		Usuario res = null;
		try {
			res = sessionFactory.getCurrentSession().get(Usuario.class,
					idUsuario);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

		return res;
	}

	
	@Override
	public void save(Usuario usuario) throws DaoException {
		try {
			sessionFactory.getCurrentSession().save(usuario);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}



}
