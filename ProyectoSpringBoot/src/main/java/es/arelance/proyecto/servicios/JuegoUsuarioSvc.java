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
	 * Agrega un juego a la lista personal de un {@link Usuario}
	 * 
	 * @param juegoUsuario
	 *            Objeto formado por el {@link Usuario} y {@link Juego} que
	 *            guarda
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
