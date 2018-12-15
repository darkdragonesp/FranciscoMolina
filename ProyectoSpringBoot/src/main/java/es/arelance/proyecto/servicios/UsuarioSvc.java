package es.arelance.proyecto.servicios;

import es.arelance.proyecto.modelo.Juego;
import es.arelance.proyecto.modelo.Usuario;

/**
 * Interfaz de la capa de servicio para gestionar {@link Usuario}
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface UsuarioSvc {

	/**
	 * Busca a un {@link Usuario} por identificador para mostrar su perfil
	 * 
	 * @param idUsuario
	 *            Identificador del {@link Usuario}
	 * @param fetch
	 *            Si {@code true} obtiene relaciones de {@link Juego}; Si
	 *            {@code false} no realiza el fetch
	 * @return Usuario si encontrado; null en otro caso
	 * @throws ServiceException
	 *             Error relativo a la capa DAO
	 */
	Usuario obtenPorId(Integer id, boolean fetch) throws ServiceException;

	/**
	 * Guarda un {@link Usuario} nuevo
	 * 
	 * @param Usuario
	 *            {@link Usuario} a guardar
	 * @throws ServiceException
	 *             Error relativo a la capa DAO
	 */
	void guardar(Usuario usuario) throws ServiceException;

	/**
	 * Identificar un {@link Usuario}
	 * 
	 * @param usuario
	 *            {@link Usuario}
	 * @return {@link Usuario} si lo encuentra;en otro caso {@code null}
	 * @throws SvcException
	 *             Error relativo a la capa DAO
	 */
	Usuario identificar(Usuario usuario) throws ServiceException;

	/**
	 * Comprueba si un {@link Usuario} tiene acceso a una funcionalidad de la
	 * aplicación web
	 * 
	 * @param usuario
	 *            {@link Usuario}
	 * @param uri
	 *            Dirección a al que se intenta acceder
	 * @return {@code true} si {@link Usuario} tiene acceso; en otro caso
	 *         {@code false}
	 * @throws SvcException
	 *             Error en la comprobación
	 */
	boolean comprobar(Usuario usuario, String uri) throws ServiceException;
}
