package es.arelance.proyecto.servicios;

import es.arelance.proyecto.modelo.Plataforma;

/**
 * Interfaz de la capa de servicio para gestionar {@link Plataforma}
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface PlataformaSvc {
	/**
	 * Obtiene todas las instancias de {@link Plataforma}
	 * 
	 * @return lista de plataformas
	 * @throws ServiceException
	 */
	Iterable<Plataforma> listar() throws ServiceException;
}
