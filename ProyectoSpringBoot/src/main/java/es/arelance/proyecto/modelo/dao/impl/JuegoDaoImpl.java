package es.arelance.proyecto.modelo.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.arelance.proyecto.modelo.Juego;
import es.arelance.proyecto.modelo.dao.DaoException;
import es.arelance.proyecto.modelo.dao.JuegoDao;

@Repository
public class JuegoDaoImpl implements JuegoDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(Juego juego) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer idJuego) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Juego update(Juego juego) throws DaoException {
		// TODO Auto-generated method stub
		return null;
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

}
