package es.arelance.proyecto.modelo.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.arelance.proyecto.modelo.Juego;
import es.arelance.proyecto.modelo.dao.DaoException;
import es.arelance.proyecto.modelo.dao.JuegoDao;

/**
 * Implementación de la interfaz del DAO {@link JuegoDao}
 * 
 * @author Francisco Molina Sanchez
 *
 */
@Repository
public class JuegoDaoImpl implements JuegoDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Juego juego) throws DaoException {
		try {
			sessionFactory.getCurrentSession().save(juego);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

	@Override
	public void delete(Juego juego) throws DaoException {
		try {
			sessionFactory.getCurrentSession().delete(juego);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

	@Override
	public void update(Juego juego) throws DaoException {
		try {
			sessionFactory.getCurrentSession().update(juego);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Juego> findAll() throws DaoException {
		List<Juego> res = null;
		try {
			String hql = "FROM Juego j ORDER BY j.titulo";
			res = sessionFactory.getCurrentSession().createQuery(hql).list();
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Juego> filter(Juego juego) throws DaoException {
		List<Juego> res = null;

		try {
			String hql = "FROM Juego j WHERE j.titulo LIKE concat('%',:titulo,'%')";

			if (juego.getCategoria().getIdCategoria() != null) {
				hql += " AND j.categoria.idCategoria = "
						+ juego.getCategoria().getIdCategoria();
			}
			if (juego.getPlataforma().getIdPlataforma() != null) {
				hql += " AND j.plataforma.idPlataforma = "
						+ juego.getPlataforma().getIdPlataforma();
			}
			hql += " ORDER BY j.titulo";
			res = sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("titulo", juego.getTitulo()).getResultList();
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

		return res;
	}

	@Override
	public Juego findById(Integer idJuego) throws DaoException {
		Juego res = null;
		try {
			res = (Juego) sessionFactory.getCurrentSession().get(Juego.class,idJuego);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		return res;
	}

}
