package es.arelance.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.arelance.proyecto.servicios.CategoriaSvc;
import es.arelance.proyecto.servicios.JuegoSvc;
import es.arelance.proyecto.servicios.PlataformaSvc;
import es.hubiqus.inventario.service.TipoProductoSvc;

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

	@RequestMapping(value="/buscarJuego", method=RequestMethod.GET)
    public String execute(@RequestParam int idJuego, Model model){//, HttpServletRequest request) {
    	try {
			//No es necesario acceder al request para el parámetro, directamente lo paso por el método
//			String id = Integer.parseInt(request.getParameter("id"));
			model.addAttribute(ATT_ITEM, svc.buscar(idJuego));
			
			//Incluir elementos para la selección porque vamos hacia el formulario
//			model.addAttribute(ATT_LISTA, Svc.listar());
			model.addAttribute(ATT_LISTA, catSvc.listar());
			model.addAttribute(ATT_LISTA_EXTRA, platSvc.listar());
			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
    }

}
