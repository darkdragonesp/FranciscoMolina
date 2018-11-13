package es.arelance.proyecto.modelo;

/**
 * Clase que representa la plataforma o ssitema a la que pertenece cada juego
 * 
 * @author Francisco Molina Sanchez
 *
 */
public class Plataforma {
	private Integer idPlataforma;
	private String nombre;

	public Integer getIdPlataforma() {
		return idPlataforma;
	}

	public void setIdPlataforma(Integer idPlataforma) {
		this.idPlataforma = idPlataforma;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
