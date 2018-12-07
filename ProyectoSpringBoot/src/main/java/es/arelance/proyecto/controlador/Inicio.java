package es.arelance.proyecto.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador para el cambio de idioma, simplemente redirige a página de inicio
 * 
 * @author ajurado
 *
 */
@Controller
public class Inicio {

	private static final String SUCCESS = "index";

	@RequestMapping(value = "/inicio")
	public String execute(Model model) {
		return SUCCESS;
	}

}
