package es.arelance.proyecto.modelo.dao;

import java.util.List;

import es.arelance.proyecto.modelo.JuegoUsuario;

/**
 * Dao para la entidad {@link juegoUsuario} que representa los juegos de un
 * usuario
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface JuegoUsuarioDao {
	/**
	 * Añade un juego a la lista personal de un {@link Usuario}
	 * 
	 * @param juegoUsuario
	 *            objeto formado por el {@link Usuario} y {@link Juego} que añado
	 */
	void add(JuegoUsuario juegoUsuario) throws DaoException;

	/**
	 * Obtiene todos las instancias de {@link Juego} pertenecientes a un usuario
	 * 
	 * @param idUsuario
	 *            identificador del usuario
	 */
	List<JuegoUsuario> getAllById(Integer idUsuario)
			throws DaoException;
}
