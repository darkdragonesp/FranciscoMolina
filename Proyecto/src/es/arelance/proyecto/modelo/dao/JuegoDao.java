package es.arelance.proyecto.modelo.dao;

import java.util.List;

import es.arelance.proyecto.modelo.Juego;

/**
 * Interfaz DAO para la entidad {@link Juego}
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface JuegoDao {
	/**
	 * Añade un {@link Juego} nuevo al sistema
	 * 
	 * @param juego
	 *            {@link Juego} a añadir
	 * @throws DaoException error relativo a la base de datos
	 */
	void add(Juego juego) throws DaoException;

	/**
	 * Devuelve todas las instancias de {@link Juego} existentes 
	 * en el sistema
	 * 
	 * @return lista de juegos
	 * @throws DaoException error relativo a la base de datos
	 */
	List<Juego> findAll() throws DaoException;

	/**
	 * Filtra las instancias de {@link Juego} existentes 
	 * por titulo, categoria y/o plataforma
	 * 
	 * @param titulo
	 *            titulo del juego
	 * @param categoria
	 *            categoria del juego
	 * @param plataforma
	 *            plataforma del juego
	 * @return lista con los juegos que cumplen el filtro
	 * @throws DaoException error relativo a la base de datos
	 */
	List<Juego> filter(String titulo, String categoria, String plataforma) throws DaoException;

	/**
	 * Elimina un {@link Juego} del sistema
	 * 
	 * @param idJuego
	 *            identificador del juego
	 * @throws DaoException error relativo a la base de datos
	 */
	void deleteById(Integer idJuego) throws DaoException;

	/**
	 * Edita un {@link Juego} del sistema
	 * 
	 * @param juegoEditado
	 *            juego ya modificado
	 * @return juego ya modificado
	 * @throws DaoException
	 *             error relativo a la base de datos
	 */
	Juego edit(Juego juegoEditado) throws DaoException;

}
