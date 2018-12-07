package es.arelance.proyecto.controlador.juego.analisis;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.arelance.proyecto.modelo.Analisis;
import es.arelance.proyecto.servicios.AnalisisSvc;

/**
 * Controlador para borrar un {@link Analisis} del sistema
 * 
 * @author Francisco Molina Sanchez
 * 
 */
@Controller
public class BorrarAnalisis {

	private static final String ATT_ERROR = "error";
	private static final String ATT_EXITO = "msg";

	private static final String SUCCESS = "forward:/mostrarUsuario";
	private static final String ERROR = "error";

	@Autowired
	private AnalisisSvc svc;

	@Autowired
	private MessageSource messages;

	/**
	 * Borra un {@link Analisis} dado su identificador
	 * 
	 * @param idAnalisis
	 *            Identificador del {@link Analisis}
	 * @param model
	 *            Objeto de Spring MVC para el almacenamiento de atributos
	 * @param locale
	 *            Internacionalización
	 * @return Destino controlador mostrarUsuario
	 */
	@RequestMapping(value = "/borrarAnalisis", method = RequestMethod.GET)
	public String borrar(@RequestParam int idAnalisis, Model model,
			Locale locale) {
		try {
			Analisis analisis = new Analisis();
			analisis.setIdAnalisis(idAnalisis);

			svc.eliminar(analisis);
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
