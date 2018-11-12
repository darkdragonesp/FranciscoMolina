package es.arelance.proyecto.modelo.dao;

import es.arelance.proyecto.modelos.Usuario;
/**
 * Interfaz para la entidad usuario
 * @author Francisco Molina Sanchez
 *
 */
public interface UsuarioDao {
	/**
	 * 
	 * @param nombreUsuario
	 * @param contrasena
	 * @return
	 */
	Integer findByNameAndPass(String nombreUsuario,String contrasena);
	/**
	 * 
	 * @param idUsuario
	 * @return
	 */
	Usuario findById(Integer idUsuario);
}
