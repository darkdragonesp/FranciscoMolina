package es.arelance.proyecto.servicios;

import java.util.List;

import es.arelance.proyecto.modelo.JuegoUsuario;

/**
 * Servicio para juegoUsuario dao que representa 
 * los juegos de un usuario
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface JuegoUsuarioSvc {
	/**
	 * Añade un juego a la lista personal de un usuario 
	 * comprobando que no existe
	 * 
	 * @param juegoUsuario
	 *            objeto formado por el usuario y juego que añado
	 */
	void anadir(JuegoUsuario juegoUsuario) throws ServiceException;

	/**
	 * Obtiene todos los juegos pertenecientes a un usuario
	 * 
	 * @param idUsuario
	 *            identificador del usuario
	 */
	List<JuegoUsuario> getAllById(Integer idUsuario)
			throws ServiceException;
}
