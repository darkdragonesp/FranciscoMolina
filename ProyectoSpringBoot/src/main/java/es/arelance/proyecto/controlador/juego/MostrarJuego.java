package es.arelance.proyecto.controlador.juego;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.arelance.proyecto.interceptor.LoginInterceptor;
import es.arelance.proyecto.modelo.Analisis;
import es.arelance.proyecto.modelo.Juego;
import es.arelance.proyecto.modelo.Usuario;
import es.arelance.proyecto.servicios.AnalisisSvc;
import es.arelance.proyecto.servicios.JuegoSvc;

/**
 * Controlador para mostrar la ficha y {@link analisis} de un {@link Juego} del
 * sistema
 * 
 * @author Francisco Molina Sanchez
 * 
 */
@Controller
@SessionAttributes({ LoginInterceptor.ATT_USER })
public class MostrarJuego {

	private static final String ATT_ITEM = "juego";

	private static final String ATT_ERROR = "error";

	private static final String SUCCESS = "juego/view";
	private static final String ERROR = "error";

	@Autowired
	private JuegoSvc svc;

	@Autowired
	private AnalisisSvc anSvc;

	/**
	 * Obtiene el {@link Juego} dado su identificador y carga la ficha del juego
	 * junto con sus {@link Analsis}
	 * 
	 * @param sesionUsuario
	 *            Sesión actual del {@link Usuario}
	 * @param idJuego
	 *            Identificador del {@link Juego}
	 * @param model
	 *            Objeto de Spring MVC para el almacenamiento de atributos
	 * @return Destino ficha del {@link Juego}
	 */
	@RequestMapping(value = "{idJuego}/juego/view")
	public String execute(
			@ModelAttribute(LoginInterceptor.ATT_USER) Usuario sesionUsuario,
			@PathVariable int idJuego, Model model) {
		try {
			Juego juego = svc.buscar(idJuego, true);
			model.addAttribute(ATT_ITEM, juego);
			model.addAttribute("notaMedia", anSvc.notaMedia(idJuego));

			// Si el usuario hizo un análisis no mostrar enlace a formulario
			Analisis analisis = new Analisis();
			analisis.setJuego(juego);
			analisis.setUsuario(sesionUsuario);
			if(anSvc.existe(analisis)) {
				model.addAttribute("existe", "existe");
			}

			return SUCCESS;
		} catch (Exception e) {
			
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

}
