package es.arelance.proyecto.servicios.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.arelance.proyecto.modelo.Categoria;
import es.arelance.proyecto.modelo.dao.CategoriaDao;
import es.arelance.proyecto.servicios.CategoriaSvc;
import es.arelance.proyecto.servicios.ServiceException;

/**
 * Implementacion de la interfaz del servicio {@link CategoriaSvc}
 * 
 * @author Francisco Molina Sanchez
 *
 */
@Service
@Transactional
public class CategoriaSvcImpl implements CategoriaSvc {

	@Autowired
	private CategoriaDao dao;

	@Override
	public Iterable<Categoria> listar() throws ServiceException {
		try {
			return dao.findAll();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Categoria buscarPorId(int idCategoria) throws ServiceException {
		Categoria res = null;
		try {
			Optional<Categoria> categoria = dao.findById(idCategoria);
			if (categoria.isPresent()) {
				res = categoria.get();
			}

		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return res;
	}

}
