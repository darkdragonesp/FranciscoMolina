package es.arelance.proyecto.controlador.juego;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.arelance.proyecto.modelo.Juego;
import es.arelance.proyecto.servicios.CategoriaSvc;
import es.arelance.proyecto.servicios.JuegoSvc;
import es.arelance.proyecto.servicios.PlataformaSvc;

/**
 * Controlador para guardar un {@link Juego} del sistema
 * 
 * @author Francisco Molina Sanchez
 * 
 */
@Controller
@RequestMapping(value = "/guardarJuego")
public class GuardarJuego {

	private static final String ATT_ITEM = "juego";
	private static final String ATT_LISTA_CAT = "listaCategorias";
	private static final String ATT_LISTA_PLAT = "listaPlataformas";
	private static final String ATT_EXITO = "msg";
	private static final String ATT_ERROR = "error";

	private static final String SUCCESS = "juego/form";
	private static final String FORM = "juego/form";
	private static final String ERROR = "error";

	@Autowired
	private JuegoSvc svc;

	@Autowired
	private CategoriaSvc catSvc;

	@Autowired
	private PlataformaSvc platSvc;

	@Autowired
	private MessageSource messages;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class,
				new CustomDateEditor(dateFormat, false));
	}

	/**
	 * Muestra el formulario para crear un {@link Juego} nuevo
	 * 
	 * @param juego
	 *            {@link Juego} a guardar
	 * @param model
	 *            Objeto de Spring MVC para el almacenamiento de atributos
	 * @return Formulario para crear o modificar un {@link Juego}
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String view(@ModelAttribute Juego juego, Model model) {
		try {
			model.addAttribute(ATT_LISTA_CAT, catSvc.listar());
			model.addAttribute(ATT_LISTA_PLAT, platSvc.listar());
			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Valida y guarda un {@link Juego} nuevo
	 * 
	 * @param juego
	 *            {@link Juego} a guardar
	 * @param result
	 *            Control de errores
	 * @param model
	 *            Objeto de Spring MVC para el almacenamiento de atributos
	 * @param locale
	 *            Internacionalización
	 * @return Vuelve al formulario
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String execute(@Valid Juego juego, BindingResult result, Model model,
			Locale locale) {
		try {
			model.addAttribute(ATT_LISTA_CAT, catSvc.listar());
			model.addAttribute(ATT_LISTA_PLAT, platSvc.listar());
			if (result.hasErrors()) {
				return FORM;
			} else {
				if (juego.getIdJuego() == null) {
					svc.guardar(juego);
				} else {
					svc.modificar(juego);
				}

				model.addAttribute(ATT_EXITO,
						messages.getMessage("mensaje.exito", null, locale));

				// Limpiar formulario
				model.addAttribute(ATT_ITEM, new Juego());

				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (e.getCause() instanceof ConstraintViolationException || e
					.getCause()
					.getCause() instanceof ConstraintViolationException) {
				result.reject("mensaje.error.guardar");
			} else {
				result.reject("mensaje.error.form");
			}
			return FORM;
		}
	}

}
