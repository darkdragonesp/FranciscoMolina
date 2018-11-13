package es.arelance.proyecto.modelo;

/**
 * Clase que representa la categoría a la que pertenece cada juego
 * 
 * @author Francisco Molina Sanchez
 *
 */
public class Categoria {
	private Integer idCategoria;
	private String nombre;

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
