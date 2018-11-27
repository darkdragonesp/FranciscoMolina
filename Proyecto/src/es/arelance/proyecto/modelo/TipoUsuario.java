package es.arelance.proyecto.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase que representa al tipo de un usuario
 * 
 * @author Francisco Molina Sanchez
 *
 */
@Entity
@Table(name = "tipo_usuario")
public class TipoUsuario {
	private Integer idTipo;
	private String nombre;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return idTipo;
	}

	public void setId(Integer id) {
		this.idTipo = id;
	}

	@Column(nullable = false, unique = true, length = 45)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
