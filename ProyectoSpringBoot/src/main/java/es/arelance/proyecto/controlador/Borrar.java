package es.arelance.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.hubiqus.inventario.model.Producto;
import es.hubiqus.inventario.service.ProductoSvc;

@Controller
public class Borrar {
	
	private static final String ATT_ERROR = "error"; 

	private static final String SUCCESS = "forward:/listar";
	private static final String ERROR = "error";
	
	@Autowired
	private ProductoSvc svc;
	
	@RequestMapping(value="/borrar", method=RequestMethod.GET)
    public String borrar(@RequestParam int id, Model model){
		try {
			Producto p = new Producto();
			p.setId(id);
			
			svc.eliminar(p);
			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
    }

}
