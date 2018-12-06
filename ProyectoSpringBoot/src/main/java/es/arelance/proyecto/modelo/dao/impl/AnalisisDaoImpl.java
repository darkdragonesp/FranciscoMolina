package es.arelance.proyecto.modelo.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.arelance.proyecto.modelo.Analisis;
import es.arelance.proyecto.modelo.dao.AnalisisDao;
import es.arelance.proyecto.modelo.dao.DaoException;

/**
 * Implementación de la interfaz del DAO {@link AnalisisDao}
 * 
 * @author Francisco Molina Sanchez
 *
 */
@Repository
public class AnalisisDaoImpl implements AnalisisDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Analisis analisis) throws DaoException {
		try {
			sessionFactory.getCurrentSession().save(analisis);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

	@Override
	public boolean exist(Analisis analisis) throws DaoException {
		Analisis res = null;
		try {
			String hql = "FROM Analisis a "
					+ "WHERE a.usuario.idUsuario = :idUsuario "
					+ "AND a.juego.idJuego = :idJuego";
			
			res = (Analisis) sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("idUsuario", analisis.getUsuario().getIdUsuario())
					.setParameter("idJuego",analisis.getJuego().getIdJuego())
					.uniqueResult();

		} catch (Exception ex) {
			throw new DaoException(ex);
		}

		return res!=null;
	}


}
