package es.hubiqus.inventario.model.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.hubiqus.inventario.model.TipoProducto;
import es.hubiqus.inventario.model.dao.DaoException;
import es.hubiqus.inventario.model.dao.TipoProductoDao;

/**
 * Implementación del dao, marcar con @Repository
 * @author ajurado
 *
 */
@Repository
public class TipoProductoDaoImpl implements TipoProductoDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TipoProducto> findAll() throws DaoException {		
		List<TipoProducto> res = null;
		
		try{					
			String hql = "FROM TipoProducto";			
			res = sessionFactory.getCurrentSession().createQuery(hql).list();		
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}

}
