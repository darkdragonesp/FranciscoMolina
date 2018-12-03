package es.arelance.proyecto.modelo.dao;

import java.util.List;

import es.arelance.proyecto.modelo.JuegoUsuario;
import es.arelance.proyecto.modelo.Usuario;

/**
 * Interfaz DAO para la entidad {@link juegoUsuario} que representa los juegos
 * pertenecientes a un usuario
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface JuegoUsuarioDao {
	/**
	 * Guarda un {@link Juego} a la lista personal de un {@link Usuario} como {@link JuegoUsuario}
	 * 
	 * @param {@link JuegoUsuario}
	 *            objeto formado por el {@link Usuario} y {@link Juego} que
	 *            guardo como {@link JuegoUsuario}
	 * @throws DaoException
	 *             error relativo a la base de datos
	 */
	void save(JuegoUsuario juegoUsuario) throws DaoException;

	/**
	 * Obtiene todos las instancias de {@link Juego} pertenecientes a un
	 * {@link Usuario}
	 * 
	 * @param usuario
	 *            {@link Usuario}
	 * @throws DaoException
	 *             error relativo a la base de datos
	 */
	List<JuegoUsuario> findByUser(Usuario usuario) throws DaoException;
}
