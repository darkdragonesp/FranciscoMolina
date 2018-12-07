package es.arelance.proyecto.controlador.juego.analisis;

import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.arelance.proyecto.modelo.Analisis;
import es.arelance.proyecto.modelo.Juego;
import es.arelance.proyecto.modelo.Usuario;
import es.arelance.proyecto.servicios.AnalisisSvc;

/**
 * Controlador para guardar un {@link Analisis} de un {@link Juego} y
 * {@link Usuario}
 * 
 * @author Francisco Molina Sanchez
 * 
 */
@Controller
@RequestMapping(value = "/guardarAnalisis")
public class GuardarAnalisis {

	private static final String ATT_EXITO = "msg";
	private static final String ATT_ERROR = "error";

	private static final String FORM = "formAnalisis";
	private static final String SUCCESS = "forward:/mostrarJuego";
	private static final String ERROR = "error";

	@Autowired
	private AnalisisSvc svc;

	@Autowired
	private MessageSource messages;

	/**
	 * Muestra el formulario de registro de {@link Usuario}
	 * 
	 * @param model
	 * @return Formulario de registro de {@link Analisis}
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String view(@ModelAttribute Analisis analisis,
			@RequestParam int idJuego, 
			Model model) {
		try {
			// TODO meter usuario de la sesion
			Usuario u = new Usuario();
			u.setIdUsuario(4);
			model.addAttribute("usuario", u);

			Juego juego = new Juego();
			juego.setIdJuego(idJuego);
			analisis.setJuego(juego);

			return FORM;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Valida y guarda un {@link Analisis}
	 * 
	 * @param analisis
	 *            {@link Analisis}
	 * @param result
	 * @param model
	 * @param locale
	 * @return Página de login
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String execute(@Valid Analisis analisis, BindingResult result,@RequestParam int idJuego,
			Model model, Locale locale) {
		try {
			if (result.hasErrors()) {
				return FORM;
			} else {
				analisis.setFechaAlta(new Date());

				svc.guardar(analisis);

				model.addAttribute(ATT_EXITO, messages
						.getMessage("mensaje.exito.analisis", null, locale));

				return SUCCESS;
			}

		} catch (Exception e) {
			e.printStackTrace();
			if (e.getMessage().equals("duplicidad")) {
				model.addAttribute(ATT_EXITO, messages
						.getMessage("mensaje.error.analisis", null, locale));
				return FORM;
			} else {
				model.addAttribute(ATT_ERROR, e);
				return ERROR;
			}

		}
	}

}
