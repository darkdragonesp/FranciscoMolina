package es.arelance.proyecto.modelo.dao;

import java.util.List;

import es.arelance.proyecto.modelo.Juego;

/**
 * Interfaz para la entidad juego
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface JuegoDao {
	/**
	 * Añade un juego nuevo al sistema
	 * 
	 * @param juego
	 *            juego a añadir
	 */
	void add(Juego juego);

	/**
	 * Devuelve todos los juegos existentes en el sistema
	 * 
	 * @return lista de juegos
	 */
	List<Juego> getAll();

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
	 */
	List<Juego> filter(String titulo, String categoria,
			String plataforma);

	/**
	 * Elimina un juego del sistema
	 * 
	 * @param idJuego
	 *            identificador del juego
	 */
	void deleteById(Integer idJuego);

	/**
	 * Edita un juego del sistema
	 * 
	 * @param juegoEditado
	 *            juego ya modificado
	 * @return juego ya modificado
	 */
	Juego edit(Juego juegoEditado);

}
