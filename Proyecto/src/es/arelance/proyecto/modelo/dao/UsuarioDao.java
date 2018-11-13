package es.arelance.proyecto.modelo.dao;

import es.arelance.proyecto.modelo.Usuario;

/**
 * Interfaz para la entidad usuario
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface UsuarioDao {
	/**
	 * Busca a un usuario por nombre y contrasena
	 * 
	 * @param nombreUsuario
	 *            nombre del usuario
	 * @param contrasena
	 *            contraseña del usuario
	 * @return idUsuario si existe; null en otro caso
	 */
	Usuario findByNameAndPass(String nombreUsuario,
			String contrasena) throws DaoException;

	/**
	 * Busca a un usuario por identificador para mostrar su perfil
	 * 
	 * @param idUsuario
	 *            identificador del usuario
	 * @return usuario si encontrado; null en otro caso
	 */
	Usuario findById(Integer idUsuario) throws DaoException;
}
