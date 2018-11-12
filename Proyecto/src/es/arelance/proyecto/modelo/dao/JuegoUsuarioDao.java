package es.arelance.proyecto.modelo.dao;

import es.arelance.proyecto.modelos.Juego;
import es.arelance.proyecto.modelos.Usuario;

public interface JuegoUsuarioDao {
	void add(Usuario usuario, Juego juego);
	void getAllById(Integer idUsuario);
}
