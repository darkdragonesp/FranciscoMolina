package es.arelance.proyecto.modelo.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.arelance.proyecto.modelo.JuegoUsuario;
import es.arelance.proyecto.modelo.Usuario;
import es.arelance.proyecto.modelo.dao.DaoException;
import es.arelance.proyecto.modelo.dao.JuegoUsuarioDao;

@Repository
public class JuegoUsuarioDaoImpl implements JuegoUsuarioDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(JuegoUsuario juegoUsuario) throws DaoException {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JuegoUsuario> findByUser(Usuario usuario)
			throws DaoException {
		List<JuegoUsuario> res = null;
		try {
			String hql = "FROM JuegoUsuario j WHERE j.usuario.idUsuario = :idUsuario";
			res = sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("idUsuario", usuario.getIdUsuario())
					.list();

		} catch (Exception ex) {
			throw new DaoException(ex);
		}

		return res;
	}

	@Override
	public Boolean exist(JuegoUsuario juegoUsuario)
			throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
