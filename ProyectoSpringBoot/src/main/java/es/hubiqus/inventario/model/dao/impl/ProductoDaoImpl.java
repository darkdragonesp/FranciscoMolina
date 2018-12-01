package es.hubiqus.inventario.model.dao.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.hubiqus.inventario.model.Producto;
import es.hubiqus.inventario.model.dao.DaoException;
import es.hubiqus.inventario.model.dao.ProductoDao;

/**
 * Implementación del dao, marcar con @Repository
 * @author ajurado
 *
 */
@Repository
public class ProductoDaoImpl implements ProductoDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Producto producto) throws DaoException{
		try{
			sessionFactory.getCurrentSession().save(producto);	
		}catch (Exception ex){
			throw new DaoException(ex);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> findByNombre(String nombre) throws DaoException{
		List<Producto> res = null;
		
		try{					
			String hql = "FROM Producto p WHERE p.nombre LIKE :nombre";
			res = sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("nombre", "%" + nombre + "%")
					.list();
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}
	
	@Override
	public void update(Producto producto) throws DaoException {
		try{
			sessionFactory.getCurrentSession().update(producto);		
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
	}

	@Override
	public void delete(Producto producto) throws DaoException {
		try{
			sessionFactory.getCurrentSession().delete(producto);		
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
	}

	@Override
	public Optional<Producto> findById(int id) throws DaoException {
		Optional<Producto> res = Optional.empty();
		
		try{					
			Producto item = (Producto) sessionFactory.getCurrentSession().get(Producto.class, id);
			if (item != null) {
				res = Optional.of(item);
			}
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}
}
