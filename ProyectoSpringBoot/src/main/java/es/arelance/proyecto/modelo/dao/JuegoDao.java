package es.arelance.proyecto.modelo.dao;

import java.util.List;

import es.arelance.proyecto.modelo.Categoria;
import es.arelance.proyecto.modelo.Juego;
import es.arelance.proyecto.modelo.Plataforma;

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
	 *             Error relativo a la base de datos
	 */
	void save(Juego juego) throws DaoException;

	/**
	 * Elimina un {@link Juego} del sistema
	 * 
	 * @param juego
	 *            Juego a eliminar
	 * @throws DaoException
	 *             Error relativo a la base de datos
	 */
	void delete(Juego juego) throws DaoException;

	/**
	 * Edita un {@link Juego} del sistema
	 * 
	 * @param juego
	 *            {@link Juego} ya modificado
	 * @return Juego ya modificado
	 * @throws DaoException
	 *             Error relativo a la base de datos
	 */
	void update(Juego juego) throws DaoException;

	/**
	 * Devuelve todas las instancias de {@link Juego} existentes en el sistema
	 * 
	 * @return Lista de juegos
	 * @throws DaoException
	 *             Error relativo a la base de datos
	 */
	List<Juego> findAll() throws DaoException;

	/**
	 * Filtra todas las instancias de {@link Juego} existentes 
	 * por titulo, {@link Categoria} y/o {@link Plataforma}
	 * 
	 * @param juego
	 *            Titulo, {@link Categoria} y/o {@link Plataforma} del {@link Juego}
	 * @return Lista con los juegos que cumplen el filtro
	 * @throws DaoException
	 *             Error relativo a la base de datos
	 */
	List<Juego> filter(Juego juego) throws DaoException;

	/**
	 * Busca un {@link Juego} por su identificador
	 * 
	 * @param idJuego
	 *            Identificador del juego
	 * @return {@link Juego}
	 * @throws DaoException
	 *             Error relativo a la base de datos
	 */
	Juego findById(Integer idJuego) throws DaoException;


}
