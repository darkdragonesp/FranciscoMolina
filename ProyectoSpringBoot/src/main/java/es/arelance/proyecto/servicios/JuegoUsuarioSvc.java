package es.arelance.proyecto.servicios;

import es.arelance.proyecto.modelo.JuegoUsuario;
import es.arelance.proyecto.modelo.Usuario;

/**
 * Interfaz de la capa de servicio para gestionar {@link JuegoUsuario}
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface JuegoUsuarioSvc {
	/**
	 * Agrega un juego a la lista personal de un usuario 
	 * comprobando que no existe
	 * 
	 * @param juegoUsuario
	 *            objeto formado por el usuario y juego que a�ado
	 * @throws ServiceException
	 */
	void guardar(JuegoUsuario juegoUsuario) throws ServiceException;

	/**
	 * Obtiene todos los juegos pertenecientes a un usuario
	 * 
	 * @param usuario
	 *            {@link Usuario}
	 * @throws ServiceException            
	 */
	Iterable<JuegoUsuario> listarPorUsuario(Usuario usuario)
			throws ServiceException;
}
