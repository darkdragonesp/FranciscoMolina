package es.arelance.proyecto.controlador.usuario;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.arelance.proyecto.modelo.TipoUsuario;
import es.arelance.proyecto.modelo.Usuario;
import es.arelance.proyecto.servicios.UsuarioSvc;

@Controller
//En este caso se usará para dos acciones, la de nuevo al cargar (view) y la de guardar desde el form (guardar)
@RequestMapping(value = "/guardarUsuario")
public class GuardarUsuario {
	
	private static final String ATT_ITEM = "juego";
	private static final String ATT_LISTA = "listaCategorias";
	private static final String ATT_LISTA_EXTRA = "listaPlataformas";
	private static final String ATT_EXITO = "msg";
	private static final String ATT_ERROR = "error";

	private static final String FORM = "formUsuario";
	private static final String SUCCESS = "forward:/inicio";
	private static final String ERROR = "error";

	
	@Autowired
	private UsuarioSvc svc;
	
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
    public String view(@ModelAttribute Usuario usuario, Model model) {
		try {
			return FORM;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	//guardar: almacenar el producto, también se vuelve a cargar la lista para el select ya que se vuelve al formulario
    @RequestMapping(method=RequestMethod.POST)
    public String execute(@Valid Usuario usuario, BindingResult result, Model model, Locale locale) {
		try {
			if (result.hasErrors()){
				return FORM;
			}else {
				usuario.setFechaAlta(new Date());
				TipoUsuario tipo =new TipoUsuario(2);
				usuario.setTipoUsuario(tipo);
				
				svc.guardar(usuario);
				
				model.addAttribute(ATT_EXITO, messages.getMessage("mensaje.exito.registrar", null, locale));
				
				return SUCCESS;
			}
			
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
    }
    

}
