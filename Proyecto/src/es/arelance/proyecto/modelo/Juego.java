package es.arelance.proyecto.modelo;

import java.util.Date;

/**
 * Clase que representa cada uno de los juegos disponibles en 
 * la aplicacion web
 * 
 * @author Francisco Molina Sanchez
 *
 */
public class Juego {
	private Integer idJuego;
	private String titulo;
	private Date fechaLanzamiento;
	private String text;
	private Categoria categoria;
	private Plataforma plataforma;
	public Integer getIdJuego() {
		return idJuego;
	}
	public void setIdJuego(Integer idJuego) {
		this.idJuego = idJuego;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getFechaLanzamiento() {
		return fechaLanzamiento;
	}
	public void setFechaLanzamiento(Date fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Plataforma getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}
	
	
}
