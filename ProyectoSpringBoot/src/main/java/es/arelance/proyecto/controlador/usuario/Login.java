package es.arelance.proyecto.controlador.usuario;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import es.arelance.proyecto.interceptor.LoginInterceptor;
import es.arelance.proyecto.modelo.Usuario;
import es.arelance.proyecto.servicios.UsuarioSvc;

@Controller
@SessionAttributes(LoginInterceptor.ATT_USER)
@RequestMapping(value = "/usuario")
public class Login {

	private static final String MSG_ERROR = "mensaje.error.login";
	private static final String FORM = "login/form";
	private static final String ERROR = "login/form";
	private static final String SUCCESS = "forward:/inicio";
	private static final String INICIO = "redirect:/login";

	@Autowired
	private UsuarioSvc svc;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String view(@ModelAttribute Usuario usuario, Model model) {
		return FORM;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String execute(@Valid Usuario usuario, BindingResult result,
			Model model) {
		try {
			if (result.getFieldError("nombreUsuario") != null
					|| result.getFieldError("contrasena") != null) {
				return FORM;
			} else {
				usuario = svc.identificar(usuario);
				if (usuario == null) {
					result.reject(MSG_ERROR);
					return ERROR;
				} else {

					model.addAttribute(LoginInterceptor.ATT_USER, usuario);
					return SUCCESS;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.reject(MSG_ERROR);
			return ERROR;
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, SessionStatus sessionStatus) {
		// Destrucción de la sesión
		sessionStatus.setComplete();
		// Hace un redirect, para completar el cierre de sesión
		return INICIO;
	}
}
