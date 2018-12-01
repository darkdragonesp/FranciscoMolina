package es.arelance.proyecto.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase que representa la plataforma o ssitema a la que pertenece cada juego
 * 
 * @author Francisco Molina Sanchez
 *
 */
@Entity
@Table(name="plataforma")
public class Plataforma {
	private Integer idPlataforma;
	private String nombre;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdPlataforma() {
		return idPlataforma;
	}

	public void setIdPlataforma(Integer idPlataforma) {
		this.idPlataforma = idPlataforma;
	}

	@Column(nullable = false, unique = true, length = 45)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
