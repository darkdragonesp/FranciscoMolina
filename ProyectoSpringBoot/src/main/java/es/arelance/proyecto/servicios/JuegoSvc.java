package es.arelance.proyecto.servicios;

import es.arelance.proyecto.modelo.Juego;

/**
 * Interfaz de la capa de servicio para gestionar {@link Juego}
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface JuegoSvc {
	/**
	 * Agrega un juego nuevo al sistema
	 * 
	 * @param juego
	 *            juego a agregar
	 * @throws ServiceException          
	 */
	void guardar(Juego juego) throws ServiceException;

	/**
	 * Devuelve todos los juegos existentes en el sistema
	 * 
	 * @return lista de juegos
	 * @throws ServiceException
	 */
	Iterable<Juego> listar() throws ServiceException;

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
	Iterable<Juego> filtrar(String titulo, String categoria,
			String plataforma) throws ServiceException;

	/**
	 * Elimina un {@link Juego} del sistema
	 * 
	 * @param juego
	 *            identificador del juego
	 * @throws ServiceException           
	 */
	void eliminar(Juego juego) throws ServiceException;

	/**
	 * Edita un {@link Juego} del sistema
	 * 
	 * @param juego
	 *            juego ya modificado
	 * @throws ServiceException
	 */
	void modificar(Juego juego) throws ServiceException;

}
