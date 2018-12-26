package es.arelance.proyecto.servicios.impl;

import java.util.Optional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.arelance.proyecto.modelo.Juego;
import es.arelance.proyecto.modelo.dao.JuegoDao;
import es.arelance.proyecto.servicios.JuegoSvc;
import es.arelance.proyecto.servicios.ServiceException;

/**
 * Implementacion de la interfaz del servicio {@link JuegoSvc}
 * 
 * @author Francisco Molina Sanchez
 *
 */
@Service
@Transactional
public class JuegoSvcImpl implements JuegoSvc {

	@Autowired
	private JuegoDao dao;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void guardar(Juego juego) throws ServiceException {
		try {
			dao.save(juego);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Iterable<Juego> listar() throws ServiceException {
		try {
			return dao.findAllByOrderByTitulo();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Iterable<Juego> filtrar(Juego juego) throws ServiceException {
		try {
			boolean c = juego.getCategoria().getIdCategoria() != null;
			boolean p = juego.getPlataforma().getIdPlataforma() != null;

			if (!c && !p) {
				return dao.findByTituloContainingOrderByTitulo(juego.getTitulo());

			} else if (c && p) {
				return dao.findByTituloContainingAndPlataformaAndCategoriaOrderByTitulo(
						juego.getTitulo(), juego.getPlataforma(),
						juego.getCategoria());

			} else if (p) {
				return dao.findByTituloContainingAndPlataformaOrderByTitulo(
						juego.getTitulo(), juego.getPlataforma());
			} else {
				return dao.findByTituloContainingAndCategoriaOrderByTitulo(juego.getTitulo(),
						juego.getCategoria());
			}

		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void eliminar(Juego juego) throws ServiceException {
		try {
			dao.delete(juego);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void modificar(Juego juego) throws ServiceException {
		try {
			dao.save(juego);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Juego buscar(Integer idJuego, boolean fetch)
			throws ServiceException {
		Juego res = null;
		try {
			Optional<Juego> juego = dao.findById(idJuego);
			if (juego.isPresent()) {
				res = juego.get();
				if (fetch) {
					Hibernate.initialize(res.getAnalisis());
				}
			}

		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return res;
	}

}
