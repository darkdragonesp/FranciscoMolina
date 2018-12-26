package es.arelance.proyecto.servicios.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.arelance.proyecto.modelo.Plataforma;
import es.arelance.proyecto.modelo.dao.PlataformaDao;
import es.arelance.proyecto.servicios.PlataformaSvc;
import es.arelance.proyecto.servicios.ServiceException;

/**
 * Implementacion de la interfaz del servicio {@link PlataformaSvc}
 * 
 * @author Francisco Molina Sanchez
 *
 */
@Service
@Transactional
public class PlataformaSvcImpl implements PlataformaSvc {

	@Autowired
	private PlataformaDao dao;

	@Override
	public Iterable<Plataforma> listar() throws ServiceException {
		try {
			return dao.findAll();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Plataforma buscarPorId(int idPlataforma) throws ServiceException {
		Plataforma res = null;
		try {
			Optional<Plataforma> plataforma = dao.findById(idPlataforma);
			if (plataforma.isPresent()) {
				res = plataforma.get();
			}
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return res;
	}

}
