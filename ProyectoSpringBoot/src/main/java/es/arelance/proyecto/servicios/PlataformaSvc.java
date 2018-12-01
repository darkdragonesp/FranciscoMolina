package es.arelance.proyecto.servicios;

import java.util.List;

import es.arelance.proyecto.modelo.Plataforma;

/**
 * Interfaz de la capa de servicio para gestionar {@link Plataforma}
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface PlataformaSvc {
	/**
	 * Obtiene todas las plataformas disponibles
	 * 
	 * @return lista de plataformas
	 * @throws ServiceException
	 */
	List<Plataforma> listar() throws ServiceException;
}
