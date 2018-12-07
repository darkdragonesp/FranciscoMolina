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
	 * @return Lista de plataformas
	 * @throws ServiceException
	 *             Error relativo a la capa DAO
	 */
	Iterable<Plataforma> listar() throws ServiceException;

	/**
	 * Obtiene la {@link Plataforma} dado su identificador
	 * 
	 * @param idPlataforma
	 *            Identificador de la {@link Plataforma}
	 * @return {@link Plataforma}
	 * @throws ServiceException
	 *             Error relativo a la capa DAO
	 */
	Plataforma buscarPorId(int idPlataforma) throws ServiceException;
}
