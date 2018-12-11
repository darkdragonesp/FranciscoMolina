package es.arelance.proyecto.modelo;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase que representa cada uno de los juegos disponibles en la aplicacion web
 * 
 * @author Francisco Molina Sanchez
 *
 */
@Entity
@Table(name = "juego")
public class Juego {
	private Integer idJuego;
	private String titulo;
	private Date fechaLanzamiento;
	private String descripcion;
	private Categoria categoria;
	private Plataforma plataforma;

	private Set<Analisis> analisis;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdJuego() {
		return idJuego;
	}

	public void setIdJuego(Integer idJuego) {
		this.idJuego = idJuego;
	}

	@NotEmpty
	@Size(max = 45)
	@Column(nullable = false, unique = true, length = 45)
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@NotNull
	@Temporal(TemporalType.DATE)
	public Date getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	public void setFechaLanzamiento(Date fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}

	@Size(max = 500)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@NotNull
	@ManyToOne
	@JoinColumn(name = "idCategoria", nullable = false)
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@NotNull
	@ManyToOne
	@JoinColumn(name = "idPlataforma", nullable = false)
	public Plataforma getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "juego")
	@OrderBy("fechaAlta DESC")
	public Set<Analisis> getAnalisis() {
		return analisis;
	}

	public void setAnalisis(Set<Analisis> analisis) {
		this.analisis = analisis;
	}

}
