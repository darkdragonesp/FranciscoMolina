package es.arelance.proyecto.modelo.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.arelance.proyecto.modelo.Usuario;
import es.arelance.proyecto.modelo.dao.DaoException;
import es.arelance.proyecto.modelo.dao.UsuarioDao;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Usuario findByNameAndPass(String nombreUsuario,
			String contrasena) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findById(Integer idUsuario) throws DaoException {
		Usuario res = null;
		try{					
			res = sessionFactory.getCurrentSession().get(Usuario.class,idUsuario);
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}

}
