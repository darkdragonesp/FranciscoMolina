package es.arelance.proyecto.modelo.dao;

import java.util.List;

import es.arelance.proyecto.modelo.JuegoUsuario;

/**
 * Dao para la entidad juegoUsuario que representa 
 * los juegos de un usuario
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
	void add(JuegoUsuario juegoUsuario) throws DaoException;

	/**
	 * Obtiene todos los juegos pertenecientes a un usuario
	 * 
	 * @param idUsuario
	 *            identificador del usuario
	 */
	List<JuegoUsuario> getAllById(Integer idUsuario)
			throws DaoException;
}
