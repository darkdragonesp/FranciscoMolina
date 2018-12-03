package es.arelance.proyecto.controlador.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.arelance.proyecto.modelo.Usuario;
import es.arelance.proyecto.servicios.UsuarioSvc;

//Indica que se trata de un controlador
@Controller
public class MostrarUsuario {
	
	private static final String ATT_ITEM = "usuario";
	
	private static final String ATT_LISTA = "listaJuegos";
	private static final String ATT_ERROR = "error";

	private static final String SUCCESS = "verMiPerfil";
	private static final String ERROR = "error";
	
	//Autoinyección del servicio
	@Autowired
	private UsuarioSvc svc;
	
	//Trayectoria y método (al ser un GET desde navegador o link)
	//Los métodos del controlador los definimos nosotros, podemos poner el nombre o parámetros que queramos
	@RequestMapping(value="/mostrarUsuario", method=RequestMethod.GET)
    public String execute(Model model){
    	try {
    		//TODO obten usuario de la sesion
    		Usuario usuario = svc.obtenPorId(4);
    		model.addAttribute(ATT_ITEM, usuario);
			
			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
    }
	
}
