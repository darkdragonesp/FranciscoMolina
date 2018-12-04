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
	 *            {@link Juego} a agregar
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
	 * Filtra todas las instancias de {@link Juego} existentes 
	 * por titulo
	 * 
	 * @param titulo
	 *            Titulo del {@link Juego}
	 * @return Lista con los juegos que cumplen el filtro
	 * @throws ServiceException
	 */
	Iterable<Juego> filtrar(String titulo) throws ServiceException;

	/**
	 * Elimina un {@link Juego} del sistema
	 * 
	 * @param juego
	 *            Identificador del {@link Juego}
	 * @throws ServiceException
	 */
	void eliminar(Juego juego) throws ServiceException;

	/**
	 * Edita un {@link Juego} del sistema
	 * 
	 * @param juego
	 *            {@link Juego} ya modificado
	 * @throws ServiceException
	 */
	void modificar(Juego juego) throws ServiceException;

	/**
	 * Busca un {@link Juego} dado su identificador y lo devuelve
	 * 
	 * @param idJuego
	 *            Identificador del {@link Juego} a buscar
	 * @return {@link Juego} si encontrado; null en otro caso
	 * @throws ServiceException
	 */
	Juego buscar(Integer idJuego) throws ServiceException;

}
