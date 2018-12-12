package es.arelance.proyecto.controlador.juego.usuario;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

@RequestMapping(value = "/guardarJuegoUsuario")
public class Guardar {

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
	@RequestMapping(method = RequestMethod.GET)
	public String view(@RequestParam int idJuego,
			@RequestParam Integer idCategoria,
			@RequestParam Integer idPlataforma, Model model, Locale locale) {
		try {
			// TODO obtener usuario de la sesion
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(4);

			Juego juego = new Juego();
			juego.setIdJuego(idJuego);

			JuegoUsuario juegoUsuario = new JuegoUsuario();
			juegoUsuario.setJuego(juego);
			juegoUsuario.setUsuario(usuario);
			svc.guardar(juegoUsuario);
			model.addAttribute(ATT_EXITO,
					messages.getMessage("mensaje.exito.agregar", null, locale));

			if (idCategoria != null) {
				return "forward:/juego/list/categoria";
			} else if (idPlataforma != null) {
				return "forward:/listarPorPlataforma";
			} else {
				return SUCCESS;
			}

		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

}
