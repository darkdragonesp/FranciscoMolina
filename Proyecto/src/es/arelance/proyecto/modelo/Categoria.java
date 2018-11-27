package es.arelance.proyecto.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase que representa la categoría a la que pertenece cada juego
 * 
 * @author Francisco Molina Sanchez
 *
 */
@Entity
@Table(name="categoria")
public class Categoria {
	private Integer idCategoria;
	private String nombre;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	@Column(nullable = false, unique = true, length = 45)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
