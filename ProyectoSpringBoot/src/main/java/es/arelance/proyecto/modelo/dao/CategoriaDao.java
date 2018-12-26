package es.arelance.proyecto.modelo.dao;

import org.springframework.data.repository.CrudRepository;

import es.arelance.proyecto.modelo.Categoria;

/**
 * Interfaz DAO para la entidad {@link Categoria}
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface CategoriaDao extends CrudRepository<Categoria, Integer> {

}
