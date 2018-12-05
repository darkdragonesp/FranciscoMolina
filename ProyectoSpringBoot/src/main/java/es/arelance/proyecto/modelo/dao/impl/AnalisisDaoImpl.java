package es.arelance.proyecto.modelo.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.arelance.proyecto.modelo.Analisis;
import es.arelance.proyecto.modelo.Juego;
import es.arelance.proyecto.modelo.Usuario;
import es.arelance.proyecto.modelo.dao.AnalisisDao;
import es.arelance.proyecto.modelo.dao.DaoException;

/**
 * Implementación de la interfaz del DAO {@link Analisis}
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Analisis> filter(Juego juego,Usuario usuario) throws DaoException {
		List<Analisis> res = null;

		try {
			String hql = "FROM Analisis a ";
			if(usuario.getIdUsuario() != null && juego.getIdJuego() != null) {
				hql += "WHERE a.usuario.idUsuario = "+ usuario.getIdUsuario()
					+"AND a.juego.idJuego = "+ juego.getIdJuego();
			}else if (usuario.getIdUsuario() != null) {
				hql += "WHERE a.usuario.idUsuario = "
						+ usuario.getIdUsuario();
			}else if (juego.getIdJuego() != null) {
				hql += "WHERE a.juego.idJuego = "
						+ juego.getIdJuego();
			}
			hql += " ORDER BY a.fechaAlta DESC";
			res = sessionFactory.getCurrentSession().createQuery(hql).getResultList();
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

		return res;
	}

	@Override
	public boolean exist(Juego juego, Usuario usuario) throws DaoException {
		Analisis res = null;
		try {
			String hql = "FROM Analisis a "
					+ "WHERE a.usuario.idUsuario = :idUsuario "
					+ "AND a.juego.idJuego = :idJuego";
			
			res = (Analisis) sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("idUsuario", usuario.getIdUsuario())
					.setParameter("idJuego", juego.getIdJuego())
					.uniqueResult();

		} catch (Exception ex) {
			throw new DaoException(ex);
		}

		return res!=null;
	}


}
