package es.arelance.proyecto.modelo.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import es.arelance.proyecto.modelo.Juego;
import es.arelance.proyecto.modelo.dao.DaoException;
import es.arelance.proyecto.modelo.dao.JuegoDao;

public class JuegoDaoImpl implements JuegoDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void add(Juego juego) throws DaoException {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Juego> findAll() throws DaoException {
		List<Juego> res = null;

		try{					
			String hql = "FROM Juego";
			res = sessionFactory.getCurrentSession().createQuery(hql).list();
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}

	@Override
	public List<Juego> filter(String titulo, String categoria,
			String plataforma) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer idJuego) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public Juego edit(Juego juegoEditado) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}