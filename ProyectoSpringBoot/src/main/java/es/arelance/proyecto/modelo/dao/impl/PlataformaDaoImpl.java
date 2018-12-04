package es.arelance.proyecto.modelo.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.arelance.proyecto.modelo.Plataforma;
import es.arelance.proyecto.modelo.dao.DaoException;
import es.arelance.proyecto.modelo.dao.PlataformaDao;
/**
 * Implementación de la interfaz del DAO {@link PlataformaDao}
 * @author Francisco Molina Sanchez
 *
 */
@Repository
public class PlataformaDaoImpl implements PlataformaDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Plataforma> findAll() throws DaoException {
		List<Plataforma> res = null;
		try{					
			String hql = "FROM Plataforma";
			res = sessionFactory.getCurrentSession().createQuery(hql).list();
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}

	@Override
	public Plataforma findById(int idPlataforma) throws DaoException {
		Plataforma res = null;
		try{					
			res = (Plataforma) sessionFactory.getCurrentSession().get(Plataforma.class, idPlataforma);
		}catch (Exception ex){
			throw new DaoException(ex);
		}	
		return res;
	}

}
