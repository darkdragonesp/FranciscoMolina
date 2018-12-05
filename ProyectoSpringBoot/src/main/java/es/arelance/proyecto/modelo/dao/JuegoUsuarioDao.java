package es.arelance.proyecto.modelo.dao;

import java.util.List;

import es.arelance.proyecto.modelo.Juego;
import es.arelance.proyecto.modelo.JuegoUsuario;
import es.arelance.proyecto.modelo.Usuario;

/**
 * Interfaz DAO para la entidad {@link JuegoUsuario} que representa los juegos
 * pertenecientes a un usuario
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface JuegoUsuarioDao {
	/**
	 * Guarda un {@link Juego} a la lista personal de un {@link Usuario} como
	 * {@link JuegoUsuario}
	 * 
	 * @param juegoUsuario
	 *            Objeto formado por el {@link Usuario} y {@link Juego} que
	 *            guardo como {@link JuegoUsuario}
	 * @throws DaoException
	 *             Error relativo a la base de datos
	 */
	void save(JuegoUsuario juegoUsuario) throws DaoException;

	/**
	 * Obtiene todos las instancias de {@link Juego} pertenecientes a un
	 * {@link Usuario}
	 * 
	 * @param usuario
	 *            {@link Usuario}
	 * @throws DaoException
	 *             Error relativo a la base de datos
	 */
	List<JuegoUsuario> findByUser(Usuario usuario) throws DaoException;

	/**
	 * Comprueba si ya existe un {@link JuegoUsuario} con el mismo
	 * {@link Usuario} y {@link Juego} para no crear duplicidad
	 * 
	 * @param juegoUsuario
	 *            {@link JuegoUsuario} a comprobar
	 * @return
	 * @throws DaoException
	 *             Error relativo a la base de datos
	 */
	boolean exist(JuegoUsuario juegoUsuario) throws DaoException;

	/**
	 * Elimina un {@link JuegoUsuario} del sistema
	 * 
	 * @param juegoUsuario
	 *            {@link JuegoUsuario} a eliminar
	 * @throws DaoException
	 *             Error relativo a la base de datos
	 */
	void delete(JuegoUsuario juegoUsuario) throws DaoException;
}
