package es.hubiqus.inventario.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.hubiqus.inventario.model.Producto;
import es.hubiqus.inventario.model.dao.ProductoDao;
import es.hubiqus.inventario.service.ProductoSvc;
import es.hubiqus.inventario.service.SvcException;

/**
 * Implementación del servicio, marcar con @Service
 * @author ajurado
 *
 */
@Service
@Transactional
public class ProductoSvcImpl implements ProductoSvc{
	
	@Autowired
	private ProductoDao dao;
	
	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void guardar(Producto producto) throws SvcException {
		try{
			dao.save(producto);
		}catch (Exception ex){
			throw new SvcException(ex);
		}
	}
	
	@Override
	public Iterable<Producto> listar() throws SvcException {
		Iterable<Producto> res = null;
		
		try{
			res = dao.findByNombre("");
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}

	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void modificar(Producto producto) throws SvcException {
		try{
			dao.update(producto);
		}catch (Exception ex){
			throw new SvcException(ex);
		}		
	}

	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void eliminar(Producto producto) throws SvcException {
		try{
			producto = buscar(producto.getId());
			dao.delete(producto);
		}catch (Exception ex){
			throw new SvcException(ex);
		}		
	}

	@Override
	public Producto buscar(int id) throws SvcException {
		Producto res = null;
		
		try{
			Optional<Producto> item = dao.findById(id); 
			res = item.isPresent() ? item.get() : null;
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}

}
