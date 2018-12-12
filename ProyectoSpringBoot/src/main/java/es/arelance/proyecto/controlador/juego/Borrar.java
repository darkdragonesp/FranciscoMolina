package es.arelance.proyecto.controlador.juego;

import java.util.Locale;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.arelance.proyecto.modelo.Juego;
import es.arelance.proyecto.servicios.JuegoSvc;

/**
 * Controlador para borrar un {@link Juego} del sistema
 * 
 * @author Francisco Molina Sanchez
 * 
 */
@Controller
public class Borrar {

	private static final String ATT_ERROR = "error";
	private static final String ATT_EXITO = "msg";

	private static final String SUCCESS = "forward:/juego/list";
	private static final String ERROR = "error";

	@Autowired
	private JuegoSvc svc;

	@Autowired
	private MessageSource messages;

	/**
	 * Borra un {@link Juego} dado su identificador
	 * 
	 * @param idJuego
	 *            Identificador del {@link Juego}
	 * @param model
	 *            Objeto de Spring MVC para el almacenamiento de atributos
	 * @param locale
	 *            Internacionalización
	 * @param idCategoria
	 *            Categoria filtrada
	 * @param idPlataforma
	 *            Plataforma filtrada
	 * @return Destino listado de juegos (aplicando filtrado si es necesario)
	 */
	@RequestMapping(value = "{idJuego}/juego/delete", method = RequestMethod.GET)
	public String borrar(@PathVariable int idJuego, Model model, Locale locale,
			@RequestParam Integer idCategoria,
			@RequestParam Integer idPlataforma) {
		try {
			Juego juego = new Juego();
			juego.setIdJuego(idJuego);

			svc.eliminar(juego);
			model.addAttribute(ATT_EXITO,
					messages.getMessage("mensaje.exito.borrar", null, locale));

			if (idCategoria != null) {
				return "forward:/juego/list/categoria";
			} else if (idPlataforma != null) {
				return "forward:/listarPorPlataforma";
			} else {
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (e.getCause() instanceof ConstraintViolationException) {
				model.addAttribute(ATT_EXITO, messages
						.getMessage("mensaje.error.borrar", null, locale));
				return SUCCESS;
			} else {
				model.addAttribute(ATT_ERROR, e);
				return ERROR;
			}
		}
	}

}
