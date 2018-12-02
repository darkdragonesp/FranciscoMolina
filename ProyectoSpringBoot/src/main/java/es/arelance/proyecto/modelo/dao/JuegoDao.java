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
	 * Agrega un {@link Juego} nuevo al sistema
	 * 
	 * @param juego
	 *            {@link Juego} a agregar
	 * @throws DaoException
	 *             error relativo a la base de datos
	 */
	void save(Juego juego) throws DaoException;

	/**
	 * Elimina un {@link Juego} del sistema
	 * 
	 * @param juego
	 *            juego a eliminar
	 * @throws DaoException
	 *             error relativo a la base de datos
	 */
	void delete(Juego juego) throws DaoException;

	/**
	 * Edita un {@link Juego} del sistema
	 * 
	 * @param juego
	 *            juego ya modificado
	 * @return juego ya modificado
	 * @throws DaoException
	 *             error relativo a la base de datos
	 */
	void update(Juego juego) throws DaoException;

	/**
	 * Devuelve todas las instancias de {@link Juego} existentes en el sistema
	 * 
	 * @return lista de juegos
	 * @throws DaoException
	 *             error relativo a la base de datos
	 */
	List<Juego> findAll() throws DaoException;

	/**
	 * Filtra las instancias de {@link Juego} existentes por titulo, categoria y/o
	 * plataforma
	 * 
	 * @param titulo
	 *            titulo del juego
	 * @return lista con los juegos que cumplen el filtro
	 * @throws DaoException
	 *             error relativo a la base de datos
	 */
	List<Juego> filter(String titulo) throws DaoException;

	/**
	 * Busca un {@link Juego} por su identificador
	 * 
	 * @param idJuego
	 *            identificador del juego
	 * @return
	 * @throws DaoException
	 *             error relativo a la base de datos
	 */
	Juego findById(Integer idJuego) throws DaoException;

}
