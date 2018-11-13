package es.arelance.proyecto.servicios;

import java.util.List;

/**
 * Servicio para plataforma dao
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface Plataforma {
	/**
	 * Obtiene todas las plataformas disponibles
	 * 
	 * @return lista de plataformas
	 */
	List<Plataforma> listar() throws ServiceException;
}
