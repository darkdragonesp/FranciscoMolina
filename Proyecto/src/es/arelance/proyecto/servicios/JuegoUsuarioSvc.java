package es.arelance.proyecto.servicios;

import java.util.List;

import es.arelance.proyecto.modelo.JuegoUsuario;

/**
 * Interfaz de la capa de servicio para gestionar {@link JuegoUsuario}
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface JuegoUsuarioSvc {
	/**
	 * A�ade un juego a la lista personal de un usuario 
	 * comprobando que no existe
	 * 
	 * @param juegoUsuario
	 *            objeto formado por el usuario y juego que a�ado
	 * @throws ServiceException
	 */
	void anadir(JuegoUsuario juegoUsuario) throws ServiceException;

	/**
	 * Obtiene todos los juegos pertenecientes a un usuario
	 * 
	 * @param idUsuario
	 *            identificador del usuario
	 * @throws ServiceException            
	 */
	List<JuegoUsuario> getAllById(Integer idUsuario)
			throws ServiceException;
}
