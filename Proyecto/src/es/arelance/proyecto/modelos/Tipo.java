package es.arelance.proyecto.modelos;

/**
 * Clase que representa al tipo de un usuario
 * 
 * @author Francisco Molina Sanchez
 *
 */
public class Tipo {
	private Integer idTipo;
	private String nombre;

	public Integer getId() {
		return idTipo;
	}

	public void setId(Integer id) {
		this.idTipo = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
