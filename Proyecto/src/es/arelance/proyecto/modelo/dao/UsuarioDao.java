package es.arelance.proyecto.modelo.dao;

import es.arelance.proyecto.modelos.Usuario;
/**
 * Interfaz para la entidad usuario
 * @author Francisco Molina Sanchez
 *
 */
public interface UsuarioDao {
	Integer findByNameAndPass(String nombreUsuario,String contrasena);
	Usuario findById(Integer idUsuario);
}
