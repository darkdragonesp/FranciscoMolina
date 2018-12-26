package es.arelance.proyecto.modelo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

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
public interface JuegoUsuarioDao extends CrudRepository<JuegoUsuario, Integer> {

	/**
	 * Obtiene todos las instancias de {@link Juego} pertenecientes a un
	 * {@link Usuario}
	 * 
	 * @param usuario
	 *            {@link Usuario}
	 */
	List<JuegoUsuario> findByUsuarioOrderByJuegoTitulo(Usuario usuario);

	/**
	 * Comprueba si ya existe un {@link JuegoUsuario} con el mismo
	 * {@link Usuario} y {@link Juego} para no crear duplicidad
	 * 
	 * @param juegoUsuario
	 *            {@link JuegoUsuario} a comprobar
	 * @return {@code true} si existe; en otro caso {@code false}
	 */
	boolean existsByUsuarioAndJuego(Usuario usuario, Juego juego);
}
