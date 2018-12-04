package es.arelance.proyecto.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;


/**
 * Clase que representa a un usuario del sistema
 * 
 * @author Francisco Molina Sanchez
 *
 */
@Entity
@Table(name="usuario")
public class Usuario {
	private Integer idUsuario;
	private String nombreUsuario;
	private String correo;
	private String contrasena;
	private TipoUsuario tipoUsuario;
	private Date fechaAlta;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	@NotEmpty
	@Column(nullable = false, unique = true, length = 45)
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	@Email(regexp=".+@.+\\..+")
	@NotEmpty
	@Column(nullable = false, length = 45)
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@NotEmpty
	@Size(min=4, max=8)
	@Column(nullable = false, length = 45)
	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@ManyToOne
	@JoinColumn(name="tipoUsuario", nullable = false)
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

}
