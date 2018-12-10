package es.arelance.proyecto.controlador.juego;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.arelance.proyecto.modelo.Juego;
import es.arelance.proyecto.servicios.CategoriaSvc;
import es.arelance.proyecto.servicios.JuegoSvc;
import es.arelance.proyecto.servicios.PlataformaSvc;

/**
 * Controlador para buscar y modificar un {@link Juego} del sistema
 * 
 * @author Francisco Molina Sanchez
 * 
 */
@Controller
public class BuscarJuego {

	private static final String ATT_ITEM = "juego";
	private static final String ATT_LISTA = "listaCategorias";
	private static final String ATT_LISTA_EXTRA = "listaPlataformas";
	private static final String ATT_ERROR = "error";

	private static final String SUCCESS = "formJuego";
	private static final String ERROR = "error";

	@Autowired
	private JuegoSvc svc;

	@Autowired
	private CategoriaSvc catSvc;

	@Autowired
	private PlataformaSvc platSvc;

	/**
	 * Obtiene el {@link Juego} dado su identificador y carga el formulario con
	 * los datos para modificarlo
	 * 
	 * @param idJuego
	 *            Identificador del {@link Juego}
	 * @param model
	 *            Objeto de Spring MVC para el almacenamiento de atributos
	 * @return Formulario para modificar el {@link Juego}
	 */
	@RequestMapping(value = "/buscarJuego", method = RequestMethod.GET)
	public String execute(@RequestParam int idJuego, Model model) {
		try {
			model.addAttribute(ATT_ITEM, svc.buscar(idJuego, false));
			model.addAttribute(ATT_LISTA, catSvc.listar());
			model.addAttribute(ATT_LISTA_EXTRA, platSvc.listar());
			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

}
