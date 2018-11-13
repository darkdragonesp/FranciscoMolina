package es.arelance.proyecto.servicios;

import java.util.List;

import es.arelance.proyecto.modelo.Plataforma;

/**
 * Servicio para plataforma dao
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface PlataformaSvc {
	/**
	 * Obtiene todas las plataformas disponibles
	 * 
	 * @return lista de plataformas
	 */
	List<Plataforma> listar() throws ServiceException;
}
