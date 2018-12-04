package es.arelance.proyecto.controlador.juego.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.arelance.proyecto.modelo.Usuario;
import es.arelance.proyecto.servicios.JuegoUsuarioSvc;

//Indica que se trata de un controlador
@Controller
public class ListarJuegosUsuario {
	
	private static final String ATT_LISTA = "listaJuegos";
	private static final String ATT_ERROR = "error";

	private static final String SUCCESS = "listaJuegosUsuario";
	private static final String ERROR = "error";
	
	//Autoinyección del servicio
	@Autowired
	private JuegoUsuarioSvc svc;
	

	
	//Trayectoria y método (al ser un GET desde navegador o link)
	//Los métodos del controlador los definimos nosotros, podemos poner el nombre o parámetros que queramos
	@RequestMapping(value="/listarJuegosPorUsuario", method=RequestMethod.GET)
    public String execute(Model model){
    	try {
    		//TODO coger usuario de la sesion
    		Usuario usuario = new Usuario();
    		usuario.setIdUsuario(4);
    		
			model.addAttribute(ATT_LISTA, svc.listarPorUsuario(usuario));
			
			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
    }
	
}
