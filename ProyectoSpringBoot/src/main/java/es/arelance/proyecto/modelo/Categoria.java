package es.arelance.proyecto.modelo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * Clase que representa la categoria a la que pertenece cada {@link Juego}
 * 
 * @author Francisco Molina Sanchez
 *
 */
@Entity
@Table(name = "categoria")
public class Categoria {
	private Integer idCategoria;
	private String nombre;

	private Set<Juego> juegos;

	public Categoria() {

	}
	public Categoria(int idCategoria) {
		this.idCategoria=idCategoria;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	@Column(nullable = false, unique = true, length = 45)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "categoria")
	@OrderBy("titulo ASC")
	public Set<Juego> getJuegos() {
		return juegos;
	}

	public void setJuegos(Set<Juego> juegos) {
		this.juegos = juegos;
	}

}
