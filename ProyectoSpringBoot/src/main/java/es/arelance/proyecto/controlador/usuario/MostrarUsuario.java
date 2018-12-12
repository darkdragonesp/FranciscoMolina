package es.arelance.proyecto.controlador.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.arelance.proyecto.modelo.Usuario;
import es.arelance.proyecto.servicios.UsuarioSvc;

/**
 * Controlador para mostrar el perfil un {@link Usuario} del sistema
 * 
 * @author Francisco Molina Sanchez
 * 
 */
@Controller
public class MostrarUsuario {

	private static final String ATT_ITEM = "usuario";
	private static final String ATT_ERROR = "error";

	private static final String SUCCESS = "usuario/view";
	private static final String ERROR = "error";

	@Autowired
	private UsuarioSvc svc;

	/**
	 * Muestra el perfil un {@link Usuario} del sistema
	 * 
	 * @param model
	 *            Objeto de Spring MVC para el almacenamiento de atributos
	 * @return Página con la información del {@link Usuario}
	 */
	@RequestMapping(value = "/usuario/view", method = RequestMethod.GET)
	public String view(Model model) {
		try {
			// TODO obten usuario de la sesion
			Usuario usuario = svc.obtenPorId(4, true);
			model.addAttribute(ATT_ITEM, usuario);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

}
