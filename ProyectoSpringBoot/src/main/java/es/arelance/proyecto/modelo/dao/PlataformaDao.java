package es.arelance.proyecto.modelo.dao;

import org.springframework.data.repository.CrudRepository;

import es.arelance.proyecto.modelo.Plataforma;

/**
 * Interfaz DAO para la entidad {@link Plataforma}
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface PlataformaDao extends CrudRepository<Plataforma, Integer> {

}
