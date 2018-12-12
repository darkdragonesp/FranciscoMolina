package es.arelance.proyecto.controlador.usuario;

import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.arelance.proyecto.modelo.TipoUsuario;
import es.arelance.proyecto.modelo.Usuario;
import es.arelance.proyecto.servicios.UsuarioSvc;

/**
 * Controlador para guardar un {@link Usuario} del sistema
 * 
 * @author Francisco Molina Sanchez
 * 
 */
@Controller
@RequestMapping(value = "/guardarUsuario")
public class GuardarUsuario {

	private static final String ATT_EXITO = "msg";
	private static final String ATT_ERROR = "error";

	private static final String FORM = "usuario/form";
	private static final String SUCCESS = "forward:/inicio";
	private static final String ERROR = "error";

	@Autowired
	private UsuarioSvc svc;

	@Autowired
	private MessageSource messages;

	/**
	 * Muestra el formulario de registro de {@link Usuario}
	 * 
	 * @param usuario
	 *            {@link Usuario} a guardar
	 * @param model
	 *            Objeto de Spring MVC para el almacenamiento de atributos
	 * @return Formulario de registro de {@link Usuario}
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String view(@ModelAttribute Usuario usuario, Model model) {
		try {
			return FORM;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Valida y guarda un {@link Usuario}
	 * 
	 * @param usuario
	 *            {@link Usuario} a guardar
	 * @param result
	 *            Control de errores
	 * @param model
	 *            Objeto de Spring MVC para el almacenamiento de atributos
	 * @param locale
	 *            Internacionalización
	 * @return Página de login
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String execute(@Valid Usuario usuario, BindingResult result,
			Model model, Locale locale) {
		try {
			if (result.hasErrors()) {
				return FORM;
			} else {
				usuario.setFechaAlta(new Date());
				TipoUsuario tipo = new TipoUsuario(2);
				usuario.setTipoUsuario(tipo);

				svc.guardar(usuario);

				model.addAttribute(ATT_EXITO, messages
						.getMessage("mensaje.exito.registrar", null, locale));

				return SUCCESS;
			}

		} catch (Exception e) {
			e.printStackTrace();
			if (e.getCause()
					.getCause() instanceof ConstraintViolationException) {
				result.reject("mensaje.error.registrar");
			} else {
				result.reject("mensaje.error.form");
			}
			return FORM;
		}
	}

}
