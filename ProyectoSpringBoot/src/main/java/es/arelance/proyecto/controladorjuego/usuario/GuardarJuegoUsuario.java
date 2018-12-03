package es.arelance.proyecto.controladorjuego.usuario;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.arelance.proyecto.modelo.Juego;
import es.arelance.proyecto.modelo.JuegoUsuario;
import es.arelance.proyecto.modelo.Usuario;
import es.arelance.proyecto.servicios.CategoriaSvc;
import es.arelance.proyecto.servicios.JuegoUsuarioSvc;
import es.arelance.proyecto.servicios.PlataformaSvc;

@Controller

@RequestMapping(value = "/guardarJuegoUsuario")
public class GuardarJuegoUsuario {
	
	private static final String ATT_ITEM = "juego";
	private static final String ATT_EXITO = "msg";
	private static final String ATT_ERROR = "error";
	
	private static final String SUCCESS = "forward:/inicio";
	private static final String ERROR = "error";
	
	@Autowired
	private JuegoUsuarioSvc svc;
	
	@Autowired
	private MessageSource messages;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		//Se encarga de parsear las fechas correctamente cuando vienen de formulario
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	//nuevo: simplemente guardar la lista para el select y pasar al form
	@RequestMapping(method=RequestMethod.GET)
    public String view(@RequestParam int idJuego, Model model) {
		try {
			//TODO obtener usuario de la sesion
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(4);
			
			Juego juego = new Juego();
			juego.setIdJuego(idJuego);
			
			JuegoUsuario juegoUsuario=new JuegoUsuario();
			juegoUsuario.setJuego(juego);
			juegoUsuario.setUsuario(usuario);			
			svc.guardar(juegoUsuario);
			
			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}
    

}
