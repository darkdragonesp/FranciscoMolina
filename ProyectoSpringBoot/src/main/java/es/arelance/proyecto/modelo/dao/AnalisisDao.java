package es.arelance.proyecto.modelo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import es.arelance.proyecto.modelo.Analisis;
import es.arelance.proyecto.modelo.Juego;
import es.arelance.proyecto.modelo.Usuario;

/**
 * Interfaz DAO para la entidad {@link Analisis}
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface AnalisisDao extends CrudRepository<Analisis, Integer> {

	/**
	 * Comprueba si ya existe un {@link Analisis} de un {@link Juego} y
	 * {@link Usuario} para no crear duplicidad
	 * 
	 * @param analisis
	 *            {@link Analisis}
	 * @return {@code true} si existe; {@code false} en otro caso
	 */
	boolean existsByUsuarioAndJuego(Usuario usuario, Juego juego);

	/**
	 * Calcula la media de los {@link Analisis} de un {@link Juego}
	 * 
	 * @param idJuego
	 *            Identificador del {@link Juego}
	 * @return Media de los {@link Analisis} de un {@link Juego}
	 * @throws DaoException
	 *             Error relativo a la base de datos
	 */
	@Query("SELECT CEILING(AVG(a.nota)) FROM Analisis a WHERE a.juego.idJuego = ?1")
	Integer avg(int idJuego);
}
