package es.arelance.proyecto.servicios;

import java.util.List;

import es.arelance.proyecto.modelo.Juego;

/**
 * Interfaz de la capa de servicio para gestionar {@link Juego}
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface JuegoSvc {
	/**
	 * A�ade un juego nuevo al sistema
	 * 
	 * @param juego
	 *            juego a a�adir
	 * @throws ServiceException          
	 */
	void anadir(Juego juego) throws ServiceException;

	/**
	 * Devuelve todos los juegos existentes en el sistema
	 * 
	 * @return lista de juegos
	 * @throws ServiceException
	 */
	List<Juego> listar() throws ServiceException;

	/**
	 * Filtra los juegos existentes por titulo, categoria y/o plataforma
	 * 
	 * @param titulo
	 *            titulo del juego
	 * @param categoria
	 *            categoria del juego
	 * @param plataforma
	 *            plataforma del juego
	 * @return lista con los juegos que cumplen el filtro
	 * @throws ServiceException
	 */
	List<Juego> filtrar(String titulo, String categoria,
			String plataforma) throws ServiceException;

	/**
	 * Elimina un juego del sistema
	 * 
	 * @param idJuego
	 *            identificador del juego
	 * @throws ServiceException           
	 */
	void borrarporId(Integer idJuego) throws ServiceException;

	/**
	 * Edita un juego del sistema
	 * 
	 * @param juegoEditado
	 *            juego ya modificado
	 * @return juego ya modificado
	 * @throws ServiceException
	 */
	Juego edit(Juego juegoEditado) throws ServiceException;

}
