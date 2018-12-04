package es.arelance.proyecto.controlador.juego;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.arelance.proyecto.modelo.Categoria;
import es.arelance.proyecto.modelo.Juego;
import es.arelance.proyecto.modelo.Plataforma;
import es.arelance.proyecto.servicios.CategoriaSvc;
import es.arelance.proyecto.servicios.JuegoSvc;
import es.arelance.proyecto.servicios.PlataformaSvc;

/**
 * Controlador para listar las instancias de {@link Juego} del sistema. Permite
 * el filtrado de estos.
 * 
 * @author Francisco Molina Sanchez
 * 
 */
@Controller
public class ListarJuegos {

	private static final String ATT_LISTA = "listaJuegos";
	private static final String ATT_ERROR = "error";

	private static final String SUCCESS = "listaJuegos";
	private static final String ERROR = "error";

	@Autowired
	private JuegoSvc svc;

	@Autowired
	private CategoriaSvc catSvc;

	@Autowired
	private PlataformaSvc platSvc;

	/**
	 * Muestra la lista de instancias de {@link Juego}
	 * 
	 * @param juego
	 * @param model
	 * @return Formulario listaJuegos relleno
	 */
	@RequestMapping(value = "/listarJuegos", method = RequestMethod.GET)
	public String execute(@ModelAttribute Juego juego, Model model) {
		try {
			model.addAttribute(ATT_LISTA, svc.listar());

			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Muestra la lista de instancias de {@link Juego} filtrado por
	 * {@link Categoria}
	 * 
	 * @param juego
	 * @param idCategoria
	 *            Identificador de la categoria seleccionada
	 * @param model
	 * @return Formulario listaJuegos relleno y filtrado
	 */
	@RequestMapping(value = "/listarPorCategoria", method = RequestMethod.GET)
	public String listarPorCategoria(@ModelAttribute Juego juego,
			@RequestParam int idCategoria, Model model) {
		try {
			Categoria categoria = catSvc.buscarPorId(idCategoria);
			model.addAttribute(ATT_LISTA, categoria.getJuegos());

			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Muestra la lista de instancias de {@link Juego} filtrado por
	 * {@link Plataforma}
	 * 
	 * @param juego
	 * @param idPlataforma
	 *            Identificador de la plataforma seleccionada
	 * @param model
	 * @return Formulario listaJuegos relleno y filtrado
	 */
	@RequestMapping(value = "/listarPorPlataforma", method = RequestMethod.GET)
	public String listarPorPlataforma(@ModelAttribute Juego juego,
			@RequestParam int idPlataforma, Model model) {
		try {
			Plataforma plataforma = platSvc.buscarPorId(idPlataforma);
			model.addAttribute(ATT_LISTA, plataforma.getJuegos());

			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Muestra la lista de instancias de {@link Juego} filtrado por titulo
	 * 
	 * @param juego
	 *            Contiene el titulo a filtrar
	 * @param model
	 * @return Formulario listaJuegos relleno y filtrado
	 */
	@RequestMapping(value = "/listarJuegosFiltro", method = RequestMethod.GET)
	public String listarJuegosFiltro(@ModelAttribute Juego juego, Model model) {
		try {
			model.addAttribute(ATT_LISTA, svc.filtrar(juego.getTitulo()));

			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}
}
