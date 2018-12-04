package es.arelance.proyecto.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que representa los {@link Juego} que cada {@link Usuario} guarda en su biblioteca
 * 
 * @author Francisco Molina Sanchez
 *
 */
@Entity
@Table(name = "juego_usuario")
public class JuegoUsuario {
	private Integer idJuegoUsuario;
	private Usuario usuario;
	private Juego juego;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdJuegoUsuario() {
		return idJuegoUsuario;
	}

	public void setIdJuegoUsuario(Integer idJuegoUsuario) {
		this.idJuegoUsuario = idJuegoUsuario;
	}

	@ManyToOne
	@JoinColumn(name = "idUsuario", nullable = false)
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@ManyToOne
	@JoinColumn(name = "idJuego", nullable = false)
	public Juego getJuego() {
		return juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}

}
