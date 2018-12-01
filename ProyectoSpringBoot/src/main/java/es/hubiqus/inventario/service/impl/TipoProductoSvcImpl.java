package es.hubiqus.inventario.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.hubiqus.inventario.model.TipoProducto;
import es.hubiqus.inventario.model.dao.TipoProductoDao;
import es.hubiqus.inventario.service.SvcException;
import es.hubiqus.inventario.service.TipoProductoSvc;

/**
 * Implementación del servicio, marcar con @Service
 * @author ajurado
 *
 */
@Service
@Transactional
public class TipoProductoSvcImpl implements TipoProductoSvc{
	
	@Autowired
	private TipoProductoDao dao;
	
	@Override
	public Iterable<TipoProducto> listar() throws SvcException {
		Iterable<TipoProducto> res = null;
		
		try{
			res = dao.findAll();
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}

}
