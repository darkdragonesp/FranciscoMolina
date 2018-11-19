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
	 *            nombre del usuario
	 * @param contrasena
	 *            contraseņa del usuario
	 * @return {@link Usuario} si existe; {@code null} en otro caso
	 * @throws DaoException 
	 */
	Usuario findByNameAndPass(String nombreUsuario,
			String contrasena) throws DaoException;

	/**
	 * Busca a un {@link Usuario} por identificador para mostrar su perfil
	 * 
	 * @param idUsuario
	 *            identificador del usuario
	 * @return {@link Usuario} si encontrado; {@code null} en otro caso
	 * @throws DaoException
	 */
	Usuario findById(Integer idUsuario) throws DaoException;
}
