package es.arelance.proyecto.modelo.dao;

import java.util.List;

import es.arelance.proyecto.modelos.Plataforma;

/**
 * Interfaz para la entidad plataforma
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface PlataformaDao {
	/**
	 * Obtiene todas las plataformas disponibles
	 * 
	 * @return lista de plataformas
	 */
	List<Plataforma> getAll();
}
