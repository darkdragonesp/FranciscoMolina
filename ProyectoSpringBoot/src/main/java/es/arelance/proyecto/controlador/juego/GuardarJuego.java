package es.arelance.proyecto.controlador.juego;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.arelance.proyecto.modelo.Juego;
import es.arelance.proyecto.servicios.CategoriaSvc;
import es.arelance.proyecto.servicios.JuegoSvc;
import es.arelance.proyecto.servicios.PlataformaSvc;

@Controller
//En este caso se usará para dos acciones, la de nuevo al cargar (view) y la de guardar desde el form (guardar)
@RequestMapping(value = "/guardarJuego")
public class GuardarJuego {
	
	private static final String ATT_ITEM = "juego";
	private static final String ATT_LISTA = "listaCategorias";
	private static final String ATT_LISTA_EXTRA = "listaPlataformas";
	private static final String ATT_EXITO = "msg";
	private static final String ATT_ERROR = "error";
	
	private static final String SUCCESS = "formJuego";
	private static final String ERROR = "error";
	
	@Autowired
	private JuegoSvc svc;
	
	@Autowired
	private CategoriaSvc catSvc;
	
	@Autowired
	private PlataformaSvc platSvc;
	
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
    public String view(@ModelAttribute Juego juego, Model model) {
		try {
			//Incluir elementos para la selección
			model.addAttribute(ATT_LISTA, catSvc.listar());
			model.addAttribute(ATT_LISTA_EXTRA, platSvc.listar());
			
			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	//guardar: almacenar el producto, también se vuelve a cargar la lista para el select ya que se vuelve al formulario
    @RequestMapping(method=RequestMethod.POST)
    public String execute(@ModelAttribute Juego juego, Model model, Locale locale) {
		try {
			//Incluir elementos para la selección de nuevo porque vamos hacia el formulario
			model.addAttribute(ATT_LISTA, catSvc.listar());
			model.addAttribute(ATT_LISTA_EXTRA, platSvc.listar());
			
			if (juego.getIdJuego() == null){
				svc.guardar(juego);
			}else{
				svc.modificar(juego);
			}
			
			model.addAttribute(ATT_EXITO, messages.getMessage("mensaje.exito", null, locale));
			
			//Limpiar formulario
			model.addAttribute(ATT_ITEM, new Juego());
			
			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
    }
    

}
