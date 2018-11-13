package es.arelance.proyecto.modelo;

import java.util.Date;

/**
 * Clase que representa a un usuario del sistema
 * 
 * @author Francisco Molina Sanchez
 *
 */
public class Usuario {
	private Integer idUsuario;
	private String nombreUsuario;
	private String correo;
	private String contrasena;
	private Tipo tipoUsuario;
	private Date fechaAlta;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Tipo getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(Tipo tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

}
