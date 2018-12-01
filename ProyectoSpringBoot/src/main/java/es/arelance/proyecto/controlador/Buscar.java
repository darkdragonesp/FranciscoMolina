package es.arelance.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.hubiqus.inventario.service.ProductoSvc;
import es.hubiqus.inventario.service.TipoProductoSvc;

@Controller
public class Buscar {
	
	private static final String ATT_ITEM = "producto";
	private static final String ATT_LISTA = "lista";
	private static final String ATT_ERROR = "error";

	private static final String SUCCESS = "form";
	private static final String ERROR = "error";
	
	@Autowired
	private ProductoSvc svc;
	
	@Autowired
	private TipoProductoSvc pSvc;

	@RequestMapping(value="/buscar", method=RequestMethod.GET)
    public String execute(@RequestParam int id, Model model){//, HttpServletRequest request) {
    	try {
			//No es necesario acceder al request para el parámetro, directamente lo paso por el método
//			String id = Integer.parseInt(request.getParameter("id"));
			model.addAttribute(ATT_ITEM, svc.buscar(id));
			
			//Incluir elementos para la selección porque vamos hacia el formulario
			model.addAttribute(ATT_LISTA, pSvc.listar());
			
			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
    }

}
