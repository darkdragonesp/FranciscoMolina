package es.arelance.proyecto.controlador.juego;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.arelance.proyecto.modelo.Categoria;
import es.arelance.proyecto.modelo.Plataforma;
import es.arelance.proyecto.servicios.CategoriaSvc;
import es.arelance.proyecto.servicios.JuegoSvc;
import es.arelance.proyecto.servicios.PlataformaSvc;

//Indica que se trata de un controlador
@Controller
public class ListarJuegos {
	
	private static final String ATT_LISTA = "listaJuegos";
	private static final String ATT_ERROR = "error";

	private static final String SUCCESS = "listaJuegos";
	private static final String ERROR = "error";
	
	//Autoinyección del servicio
	@Autowired
	private JuegoSvc svc;
	
	@Autowired
	private CategoriaSvc catSvc;
	
	@Autowired
	private PlataformaSvc platSvc;
	
	//Trayectoria y método (al ser un GET desde navegador o link)
	//Los métodos del controlador los definimos nosotros, podemos poner el nombre o parámetros que queramos
	@RequestMapping(value="/listarJuegos", method=RequestMethod.GET)
    public String execute(Model model){//, HttpServletRequest request) {
    	try {
    		//Ya no necesitamos inyectar el servicio como en Servlets
			model.addAttribute(ATT_LISTA, svc.listar());
			
			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
    }
	
	@RequestMapping(value="/listarPorCategoria", method=RequestMethod.GET)
    public String listarPorCategoria(@RequestParam int idCategoria ,Model model){
    	try {
    		Categoria categoria = catSvc.buscarPorId(idCategoria);
			model.addAttribute(ATT_LISTA, categoria.getJuegos());
			
			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
    }

	@RequestMapping(value="/listarPorPlataforma", method=RequestMethod.GET)
    public String listarPorPlataforma(@RequestParam int idPlataforma ,Model model){
    	try {
    		Plataforma plataforma = platSvc.buscarPorId(idPlataforma);
			model.addAttribute(ATT_LISTA, plataforma.getJuegos());
			
			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
    }
	
	@RequestMapping(value="/listarJuegosFiltro", method=RequestMethod.GET)
    public String listarJuegosFiltro(@RequestParam String titulo ,Model model){
    	try {
    		model.addAttribute(ATT_LISTA, svc.filtrar(titulo));
			
			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
    }
}
