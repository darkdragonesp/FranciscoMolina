package es.arelance.proyecto.controlador.juego.usuario;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.arelance.proyecto.interceptor.LoginInterceptor;
import es.arelance.proyecto.modelo.Juego;
import es.arelance.proyecto.modelo.JuegoUsuario;
import es.arelance.proyecto.modelo.Usuario;
import es.arelance.proyecto.servicios.JuegoUsuarioSvc;

/**
 * Controlador para guardar un {@link JuegoUsuario} en el sistema
 * 
 * @author Francisco Molina Sanchez
 *
 */
@Controller
@SessionAttributes({ LoginInterceptor.ATT_USER })
public class GuardarJuegoUsuario {

	private static final String ATT_EXITO = "msg";
	private static final String ATT_ERROR = "error";

	private static final String SUCCESS = "forward:/juego/list";
	private static final String ERROR = "error";

	@Autowired
	private JuegoUsuarioSvc svc;

	@Autowired
	private MessageSource messages;

	/**
	 * Guardar un {@link JuegoUsuario} en el sistema
	 * 
	 * @param idJuego
	 *            Identificador del {@link Juego}
	 * @param idCategoria
	 *            Categoria filtrada
	 * @param idPlataforma
	 *            Plataforma filtrada
	 * @param model
	 *            Objeto de Spring MVC para el almacenamiento de atributos
	 * @param locale
	 *            Internacionalización
	 * @return Destino listado de juegos (aplicando filtrado si es necesario)
	 * 
	 */
	@RequestMapping(value = "{idJuego}/juego/usuario/save",method = RequestMethod.GET)
	public String view(@ModelAttribute(LoginInterceptor.ATT_USER) Usuario usuario, @PathVariable int idJuego,
			@RequestParam Integer idCategoria,
			@RequestParam Integer idPlataforma, Model model, Locale locale) {
		try {

			Juego juego = new Juego();
			juego.setIdJuego(idJuego);

			JuegoUsuario juegoUsuario = new JuegoUsuario();
			juegoUsuario.setJuego(juego);
			juegoUsuario.setUsuario(usuario);
			svc.guardar(juegoUsuario);
			model.addAttribute(ATT_EXITO,
					messages.getMessage("mensaje.exito.agregar", null, locale));

			if (idCategoria != null) {
				return "forward:/juego/list/{idCategoria}/categoria";
			} else if (idPlataforma != null) {
				return "forward:/juego/list/{idPlataforma}/plataforma";
			} else {
				return SUCCESS;
			}

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

}
