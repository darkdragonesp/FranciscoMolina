package es.arelance.proyecto.controlador.analisis;

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
import org.springframework.web.bind.annotation.SessionAttributes;

import es.arelance.proyecto.interceptor.LoginInterceptor;
import es.arelance.proyecto.modelo.Analisis;
import es.arelance.proyecto.modelo.Juego;
import es.arelance.proyecto.modelo.Usuario;
import es.arelance.proyecto.servicios.AnalisisSvc;
import es.arelance.proyecto.servicios.DuplicateException;

/**
 * Controlador para guardar un {@link Analisis} de un {@link Juego} y
 * {@link Usuario}
 * 
 * @author Francisco Molina Sanchez
 * 
 */
@Controller
@SessionAttributes({ LoginInterceptor.ATT_USER })
@RequestMapping(value = "/analisis/save")
public class GuardarAnalisis {

	private static final String ATT_EXITO = "msgInfo";
	private static final String ATT_ERROR = "error";

	private static final String FORM = "analisis/form";
	private static final String SUCCESS = "forward:/";
	private static final String ERROR = "error";

	@Autowired
	private AnalisisSvc svc;

	@Autowired
	private MessageSource messages;

	/**
	 * Muestra el formulario para guardar un {@link Analisis}
	 * 
	 * @param analisis
	 *            {@link Analisis} a guardar
	 * @param idJuego
	 *            Identificador del {@link Juego} a analizar
	 * @param model
	 *            Objeto de Spring MVC para el almacenamiento de atributos
	 * @return Destino formulario para guardar un {@link Analisis}
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String view(
			@ModelAttribute(LoginInterceptor.ATT_USER) Usuario usuario,
			@ModelAttribute Analisis analisis, @RequestParam int idJuego,
			Model model) {
		try {
			Juego juego = new Juego();
			juego.setIdJuego(idJuego);

			analisis.setJuego(juego);
			analisis.setUsuario(usuario);

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
	 *            {@link Analisis} a guardar
	 * @param result
	 *            Control de errores
	 * @param model
	 *            Objeto de Spring MVC para el almacenamiento de atributos
	 * @param locale
	 *            Internacionalización
	 * @return Si éxito vuelve a la ficha del {@link Juego};en otro caso vuelve
	 *         a mostrar el formulario de análisis
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String execute(@Valid Analisis analisis, BindingResult result,
			Model model, Locale locale) {
		try {
			if (result.hasErrors()) {
				return FORM;
			} else {

				analisis.setFechaAlta(new Date());
				svc.guardar(analisis);

				model.addAttribute(ATT_EXITO, messages
						.getMessage("mensaje.exito.analisis", null, locale));

				return SUCCESS + analisis.getJuego().getIdJuego()
						+ "/juego/view";
			}

		} catch (Exception e) {
			
			if (e instanceof DuplicateException) {
				result.reject("mensaje.error.analisis");
			} else {
				result.reject("mensaje.error.form");
			}
			return FORM;

		}
	}

}
