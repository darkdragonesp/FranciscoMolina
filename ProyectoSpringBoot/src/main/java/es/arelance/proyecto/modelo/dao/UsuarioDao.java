package es.arelance.proyecto.modelo.dao;

import es.arelance.proyecto.modelo.Usuario;

/**
 * Interfaz DAO para la entidad {@link Usuario}
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface UsuarioDao {
	/**
	 * Busca a un {@link Usuario} por nombre y contrasena
	 * 
	 * @param nombreUsuario
	 *            Nombre del usuario
	 * @param contrasena
	 *            Contrase�a del usuario
	 * @return {@link Usuario} si existe; {@code null} en otro caso
	 * @throws DaoException
	 *             Error relativo a la base de datos
	 */
	Usuario findByNameAndPass(String nombreUsuario, String contrasena)
			throws DaoException;

	/**
	 * Busca a un {@link Usuario} por identificador para mostrar su perfil
	 * 
	 * @param idUsuario
	 *            Identificador del usuario
	 * @return {@link Usuario} si encontrado; {@code null} en otro caso
	 * @throws DaoException
	 *             Error relativo a la base de datos
	 */
	Usuario findById(Integer idUsuario) throws DaoException;

	/**
	 * Guarda un {@link Usuario} nuevo en el sistema
	 * 
	 * @param usuario
	 *            {@link Usuario}
	 * @throws DaoException
	 *             Error relativo a la base de datos
	 */
	void save(Usuario usuario) throws DaoException;
}
