package es.arelance.proyecto.controlador.usuario;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.arelance.proyecto.interceptor.LoginInterceptor;
import es.arelance.proyecto.modelo.Juego;
import es.arelance.proyecto.modelo.Usuario;

/**
 * Controlador para buscar y modificar un {@link Juego} del sistema
 * 
 * @author Francisco Molina Sanchez
 * 
 */
@Controller
@SessionAttributes({ LoginInterceptor.ATT_USER })
public class BuscarUsuario {

	private static final String ATT_ITEM = "usuario";
	private static final String ATT_ERROR = "error";

	private static final String SUCCESS = "usuario/form";
	private static final String ERROR = "error";

	/**
	 * Obtiene el {@link Usuario} dado su identificador y carga el formulario
	 * con los datos para modificarlo
	 * 
	 * @param sesionUsuario
	 *            Sesión actual del {@link Usuario}
	 * @param model
	 *            Objeto de Spring MVC para el almacenamiento de atributos
	 * @return Formulario para modificar el {@link Usuario}
	 */
	@RequestMapping(value = "/usuario/edit", method = RequestMethod.GET)
	public String execute(
			@ModelAttribute(LoginInterceptor.ATT_USER) Usuario sesionUsuario,
			Model model) {
		try {
			model.addAttribute(ATT_ITEM, sesionUsuario);
			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

}
