package es.arelance.proyecto.controlador.juego.usuario;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.arelance.proyecto.modelo.Juego;
import es.arelance.proyecto.modelo.JuegoUsuario;
import es.arelance.proyecto.servicios.JuegoUsuarioSvc;

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

	private static final String SUCCESS = "forward:/juego/usuario/list";
	private static final String ERROR = "error";

	@Autowired
	private JuegoUsuarioSvc svc;

	@Autowired
	private MessageSource messages;

	/**
	 * Borra un {@link JuegoUsuario} dado su identificador
	 * 
	 * @param idJuegoUsuario
	 *            Identificador del {@link JuegoUsuario}
	 * @param model
	 *            Objeto de Spring MVC para el almacenamiento de atributos
	 * @param locale
	 *            Internacionalización
	 * @return Destino biblioteca del usuario
	 */
	@RequestMapping(value = "/borrarJuegoUsuario", method = RequestMethod.GET)
	public String borrar(@RequestParam int idJuegoUsuario, Model model,
			Locale locale) {
		try {
			JuegoUsuario juegoUsuario = new JuegoUsuario();
			juegoUsuario.setIdJuegoUsuario(idJuegoUsuario);

			svc.eliminar(juegoUsuario);
			model.addAttribute(ATT_EXITO,
					messages.getMessage("mensaje.exito.borrar", null, locale));

			return SUCCESS;

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

}
