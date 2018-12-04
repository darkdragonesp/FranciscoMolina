package es.arelance.proyecto.controlador.juego;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
	private static final String ATT_EXITO = "msg";
	
	private static final String SUCCESS = "forward:/listarJuegos";
	private static final String ERROR = "error";


	
	@Autowired
	private JuegoSvc svc;
	
	@Autowired
	private MessageSource messages;
	
	@RequestMapping(value="/borrarJuego", method=RequestMethod.GET)
    public String borrar(@RequestParam int idJuego, Model model,Locale locale,@RequestParam String titulo, @RequestParam Integer idCategoria,@RequestParam Integer idPlataforma){
		try {
			Juego juego = new Juego();
			juego.setIdJuego(idJuego);
			
			svc.eliminar(juego);
			model.addAttribute(ATT_EXITO, messages.getMessage("mensaje.exito.borrar", null, locale));
			
			if(idCategoria!=null) {
				return "forward:/listarPorCategoria";
			}else if(idPlataforma!=null){
				return "forward:/listarPorPlataforma";
			}else if(titulo!=null){
				return "forward:/listarJuegosFiltro";
			}else {
				return SUCCESS;
			}
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
    }

}
