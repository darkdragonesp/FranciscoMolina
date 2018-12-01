package es.arelance.proyecto.modelo.dao;

import java.util.List;

import es.arelance.proyecto.modelo.JuegoUsuario;

/**
 * Interfaz DAO para la entidad {@link juegoUsuario} que representa los juegos
 * pertenecientes a un usuario
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface JuegoUsuarioDao {
	/**
	 * Añade un {@link Juego} a la lista personal de un {@link Usuario}
	 * 
	 * @param juegoUsuario
	 *            objeto formado por el {@link Usuario} y {@link Juego} que
	 *            añado
	 * @throws DaoException
	 *             error relativo a la base de datos
	 */
	void add(JuegoUsuario juegoUsuario) throws DaoException;

	/**
	 * Obtiene todos las instancias de {@link Juego} pertenecientes a un
	 * {@link Usuario}
	 * 
	 * @param idUsuario
	 *            identificador del usuario
	 * @throws DaoException
	 *             error relativo a la base de datos
	 */
	List<JuegoUsuario> getAllById(Integer idUsuario) throws DaoException;

	/**
	 * Comprueba si existe una instancia de tipo {@link JuegoUsuario} con el
	 * mismo {@linkUsuario} y {@link Juego}
	 * 
	 * @param juegoUsuario
	 *            objeto formado por el {@link Usuario} y {@link Juego}
	 * @return
	 * @throws DaoException
	 *             error relativo a la base de datos
	 */
	Boolean exist(JuegoUsuario juegoUsuario) throws DaoException;
}
