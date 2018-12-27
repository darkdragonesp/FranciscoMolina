package es.arelance.proyecto.modelo.dao;

import org.springframework.data.repository.CrudRepository;

import es.arelance.proyecto.modelo.TipoUsuario;

/**
 * Interfaz DAO para la entidad {@link TipoUsuario}
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface TipoUsuarioDao extends CrudRepository<TipoUsuario,Integer>{

}
