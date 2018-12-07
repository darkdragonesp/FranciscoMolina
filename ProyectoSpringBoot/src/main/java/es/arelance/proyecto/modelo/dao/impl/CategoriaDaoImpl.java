package es.arelance.proyecto.modelo.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.arelance.proyecto.modelo.Categoria;
import es.arelance.proyecto.modelo.dao.CategoriaDao;
import es.arelance.proyecto.modelo.dao.DaoException;

/**
 * Implementación de la interfaz del DAO {@link CategoriaDao}
 * 
 * @author Francisco Molina Sanchez
 *
 */
@Repository
public class CategoriaDaoImpl implements CategoriaDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> findAll() throws DaoException {
		List<Categoria> res = null;
		try {
			String hql = "FROM Categoria";
			res = sessionFactory.getCurrentSession().createQuery(hql).list();
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

		return res;
	}

	@Override
	public Categoria findById(int idCategoria) throws DaoException {
		Categoria res = null;
		try {
			res = (Categoria) sessionFactory.getCurrentSession()
					.get(Categoria.class, idCategoria);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		return res;
	}

}
