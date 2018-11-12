package es.arelance.proyecto.modelo.dao;

import es.arelance.proyecto.modelos.JuegoUsuario;

/**
 * Interfaz para la entidad juegoUsuario que representa los juegos de un usuario
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface JuegoUsuarioDao {
	/**
	 * Añade un juego a la lista personal de un usuario
	 * 
	 * @param juegoUsuario
	 *            objeto formado por el usuario y juego que añado
	 */
	void add(JuegoUsuario juegoUsuario);

	/**
	 * Obtiene todos los juegos pertenecientes a un usuario
	 * 
	 * @param idUsuario
	 *            identificador del usuario
	 */
	void getAllById(Integer idUsuario);
}
