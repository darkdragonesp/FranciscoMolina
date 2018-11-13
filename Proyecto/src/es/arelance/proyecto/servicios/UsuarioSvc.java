package es.arelance.proyecto.servicios;

import es.arelance.proyecto.modelo.Usuario;

/**
 * Servicio para usuario dao
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface UsuarioSvc {
	/**
	 * Busca a un usuario por nombre y contrasena
	 * 
	 * @param nombreUsuario
	 *            nombre del usuario
	 * @param contrasena
	 *            contraseña del usuario
	 * @return {@link Usuario} si existe; null en otro caso
	 */
	Usuario acceder(String nombreUsuario, String contrasena)
			throws ServiceException;

	/**
	 * Busca a un usuario por identificador para mostrar su perfil
	 * 
	 * @param idUsuario
	 *            identificador del usuario
	 * @return usuario si encontrado; null en otro caso
	 */
	Usuario obtenPorId(Integer id) throws ServiceException;
}
