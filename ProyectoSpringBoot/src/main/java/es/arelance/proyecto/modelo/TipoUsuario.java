package es.arelance.proyecto.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase que representa al tipo de un {@link Usuario}
 * 
 * @author Francisco Molina Sanchez
 *
 */
@Entity
@Table(name = "tipo_usuario")
public class TipoUsuario {
	private Integer idTipo;
	private String nombre;

	public TipoUsuario() {

	}
	public TipoUsuario(Integer id) {
		this.idTipo=id;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(nullable = false, unique = true, length = 45)
	public String getNombre() {
		return nombre;
	}





}
