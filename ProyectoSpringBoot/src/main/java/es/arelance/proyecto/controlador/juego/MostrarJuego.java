package es.arelance.proyecto.controlador.juego;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.arelance.proyecto.modelo.Juego;
import es.arelance.proyecto.servicios.JuegoSvc;

/**
 * Controlador para buscar y modificar un {@link Juego} del sistema
 * 
 * @author Francisco Molina Sanchez
 * 
 */
@Controller
public class MostrarJuego {

	private static final String ATT_ITEM = "juego";

	private static final String ATT_ERROR = "error";

	private static final String SUCCESS = "mostrarJuego";
	private static final String ERROR = "error";

	@Autowired
	private JuegoSvc svc;

	/**
	 * Obtiene el {@link Juego} dado su identificador y carga la ficha del juego
	 * 
	 * @param idJuego
	 *            Identificador del {@link Juego}
	 * @param model
	 * @return Destino ficha del {@link Juego}
	 */
	@RequestMapping(value = "/mostrarJuego", method = RequestMethod.GET)
	public String execute(@RequestParam int idJuego, Model model) {
		try {
			model.addAttribute(ATT_ITEM, svc.buscar(idJuego,true));

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

}
