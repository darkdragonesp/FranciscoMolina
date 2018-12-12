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
	private static final String ATT_LISTA_CAT = "listaCategorias";
	private static final String ATT_LISTA_PLAT = "listaPlataformas";
	private static final String ATT_ERROR = "error";

	private static final String SUCCESS = "juego/list";
	private static final String CARGAR_TIPOS = "forward:/cargarTipos";
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
	 * @param model
	 *            Objeto de Spring MVC para el almacenamiento de atributos
	 * @return Destino controlador de carga de tipos
	 */
	@RequestMapping(value = "/juego/list", method = RequestMethod.GET)
	public String execute(Model model) {
		try {
			model.addAttribute(ATT_LISTA, svc.listar());
			return CARGAR_TIPOS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Muestra la lista de instancias de {@link Juego} filtrado por
	 * {@link Categoria}
	 * 
	 * @param idCategoria
	 *            Identificador de la categoria seleccionada
	 * @param model
	 *            Objeto de Spring MVC para el almacenamiento de atributos
	 * @return Destino controlador de carga de tipos
	 */
	@RequestMapping(value = "/listarPorCategoria", method = RequestMethod.GET)
	public String listarPorCategoria(@RequestParam int idCategoria,
			Model model) {
		try {
			Categoria categoria = catSvc.buscarPorId(idCategoria);
			model.addAttribute(ATT_LISTA, categoria.getJuegos());

			return CARGAR_TIPOS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Muestra la lista de instancias de {@link Juego} filtrado por
	 * {@link Plataforma}
	 * 
	 * @param idPlataforma
	 *            Identificador de la plataforma seleccionada
	 * @param model
	 *            Objeto de Spring MVC para el almacenamiento de atributos
	 * @return Destino controlador de carga de tipos
	 */
	@RequestMapping(value = "/listarPorPlataforma", method = RequestMethod.GET)
	public String listarPorPlataforma(@RequestParam int idPlataforma,
			Model model) {
		try {
			Plataforma plataforma = platSvc.buscarPorId(idPlataforma);
			model.addAttribute(ATT_LISTA, plataforma.getJuegos());

			return CARGAR_TIPOS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Muestra la lista de instancias de {@link Juego} filtrado por titulo
	 * 
	 * @param juego
	 *            Contiene los atributos a filtrar
	 * @param model
	 *            Objeto de Spring MVC para el almacenamiento de atributos
	 * @return Destino controlador de carga de tipos
	 */
	@RequestMapping(value = "/listarJuegosFiltro", method = RequestMethod.GET)
	public String listarJuegosFiltro(@ModelAttribute Juego juego, Model model) {
		try {
			model.addAttribute(ATT_LISTA, svc.filtrar(juego));
			return CARGAR_TIPOS;
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Carga las listas necesarias para rellenar los selectores del buscador y
	 * muestra la página con la lista de juegos
	 * 
	 * @param juego
	 *            Contiene los atributos a filtrar
	 * @param model
	 *            Objeto de Spring MVC para el almacenamiento de atributos
	 * @return Página con la lista de juegos
	 */
	@RequestMapping(value = "/cargarTipos", method = RequestMethod.GET)
	public String cargarTipos(@ModelAttribute Juego juego, Model model) {
		try {
			model.addAttribute(ATT_LISTA_CAT, catSvc.listar());
			model.addAttribute(ATT_LISTA_PLAT, platSvc.listar());
			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}
}
