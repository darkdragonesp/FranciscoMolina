package es.arelance.proyecto.modelo.dao;

import java.util.List;

import es.arelance.proyecto.modelos.Juego;

public interface JuegoDao {
	void add(Juego juego);
	List<Juego> getAll();
	List<Juego> filter(String titulo,String categoria,String plataforma);
	void deleteById(Integer idJuego);
	Juego editById(Integer idJuego,Juego juegoEditado);
	
}
