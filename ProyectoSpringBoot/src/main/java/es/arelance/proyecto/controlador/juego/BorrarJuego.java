package es.arelance.proyecto.controlador.juego;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.arelance.proyecto.modelo.Juego;
import es.arelance.proyecto.servicios.JuegoSvc;

@Controller
public class BorrarJuego {
	
	private static final String ATT_ERROR = "error"; 

	private static final String SUCCESS = "forward:/listarJuegos";
	private static final String ERROR = "error";
	
	@Autowired
	private JuegoSvc svc;
	
	@RequestMapping(value="/borrarJuego", method=RequestMethod.GET)
    public String borrar(@RequestParam int idJuego, Model model){
		try {
			Juego juego = new Juego();
			juego.setIdJuego(idJuego);
			
			svc.eliminar(juego);
			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
    }

}
