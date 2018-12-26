package es.arelance.proyecto.modelo.dao;

import org.springframework.data.repository.CrudRepository;

import es.arelance.proyecto.modelo.Usuario;

/**
 * Interfaz DAO para la entidad {@link Usuario}
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface UsuarioDao extends CrudRepository<Usuario,Integer>{
	/**
	 * Busca a un {@link Usuario} por nombre y contraseña
	 * 
	 * @param nombreUsuario
	 *            Nombre del usuario
	 * @param contrasena
	 *            Contrase�a del usuario
	 * @return {@link Usuario} si existe; {@code null} en otro caso
	 * @throws DaoException
	 *             Error relativo a la base de datos
	 */
	Usuario findByNombreUsuarioAndContrasena(String nombreUsuario, String contrasena);

}
