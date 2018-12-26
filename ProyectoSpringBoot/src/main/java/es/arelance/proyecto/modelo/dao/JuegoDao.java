package es.arelance.proyecto.modelo.dao;

import org.springframework.data.repository.CrudRepository;

import es.arelance.proyecto.modelo.Categoria;
import es.arelance.proyecto.modelo.Juego;
import es.arelance.proyecto.modelo.Plataforma;

/**
 * Interfaz DAO para la entidad {@link Juego}
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface JuegoDao extends CrudRepository<Juego, Integer> {

	/**
	 * Devuelve todos los juegos ordenados por titulo
	 * 
	 * @return Lista de {@link Juego}
	 */
	Iterable<Juego> findAllByOrderByTitulo();

	/*
	 * Nota: Necesito diferentes métodos de búsqueda ya que por ahora no se
	 * permiten parametros nulos
	 */
	/**
	 * Filtra todas las instancias de {@link Juego} existentes por titulo,
	 * {@link Categoria} y/o {@link Plataforma}
	 * 
	 * @param juego
	 *            Titulo, {@link Categoria} y/o {@link Plataforma} del
	 *            {@link Juego}
	 * @return Lista con los juegos que cumplen el filtro
	 */
	Iterable<Juego> findByTituloContainingOrderByTitulo(String titulo);

	Iterable<Juego> findByTituloContainingAndPlataformaOrderByTitulo(
			String titulo, Plataforma plataforma);

	Iterable<Juego> findByTituloContainingAndCategoriaOrderByTitulo(
			String titulo, Categoria categoria);

	Iterable<Juego> findByTituloContainingAndPlataformaAndCategoriaOrderByTitulo(
			String titulo, Plataforma plataforma, Categoria categoria);
}
