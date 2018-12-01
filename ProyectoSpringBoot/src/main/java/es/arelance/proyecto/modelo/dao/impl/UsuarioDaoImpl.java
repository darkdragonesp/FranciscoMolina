package es.arelance.proyecto.modelo.dao.impl;

import org.springframework.stereotype.Repository;

import es.arelance.proyecto.modelo.Usuario;
import es.arelance.proyecto.modelo.dao.DaoException;
import es.arelance.proyecto.modelo.dao.UsuarioDao;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	@Override
	public Usuario findByNameAndPass(String nombreUsuario,
			String contrasena) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findById(Integer idUsuario) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
