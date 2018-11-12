package es.arelance.proyecto.modelos;

/**
 * Clase que representa los juegos que cada usuario sigue o juega
 * 
 * @author Francisco Molina Sanchez
 *
 */
public class JuegoUsuario {
	private Integer idJuegoUsuario;
	private Usuario usuario;
	private Juego juego;
	public Integer getIdJuegoUsuario() {
		return idJuegoUsuario;
	}
	public void setIdJuegoUsuario(Integer idJuegoUsuario) {
		this.idJuegoUsuario = idJuegoUsuario;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Juego getJuego() {
		return juego;
	}
	public void setJuego(Juego juego) {
		this.juego = juego;
	}
	
	
}
