package es.arelance.proyecto.controlador.categoria;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.arelance.proyecto.modelo.Analisis;
import es.arelance.proyecto.modelo.Categoria;
import es.arelance.proyecto.modelo.Juego;
import es.arelance.proyecto.modelo.JuegoUsuario;
import es.arelance.proyecto.modelo.Usuario;
import es.arelance.proyecto.servicios.CategoriaSvc;

/**
 * Controlador para operar con {@link Categoria}
 * 
 * @author Francisco Molina Sanchez
 * 
 */
@Controller
@RequestMapping(value = "/categoria")
public class CategoriaController {

	private static final String ATT_EXITO = "msg";
	private static final String ATT_ERROR = "error";
	private static final String ATT_LISTA = "listaCategorias";
	private static final String ATT_ITEM = "categoria";

	private static final String FORM = "categoria/form";
	private static final String LIST = "categoria/list";
	private static final String SUCCESS = "form";
	private static final String ERROR = "error";

	

	@Autowired
	private CategoriaSvc svc;

	@Autowired
	private MessageSource messages;

	/**
	 * Muestra el formulario para guardar una {@link Categoria}
	 * 
	 * @param analisis
	 *            {@link Categoria} a guardar
	 * @param idJuego
	 *            Identificador del {@link Juego} a analizar
	 * @param model
	 *            Objeto de Spring MVC para el almacenamiento de atributos
	 * @return Destino formulario para guardar un {@link Analisis}
	 */
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String view(@ModelAttribute Categoria categoria, Model model) {
		try {
			return FORM;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Valida y guarda un {@link Analisis}
	 * 
	 * @param analisis
	 *            {@link Analisis} a guardar
	 * @param result
	 *            Control de errores
	 * @param model
	 *            Objeto de Spring MVC para el almacenamiento de atributos
	 * @param locale
	 *            Internacionalización
	 * @return Si éxito vuelve a la ficha del {@link Juego};en otro caso vuelve
	 *         a mostrar el formulario de análisis
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String execute(@Valid Categoria categoria, BindingResult result,
			Model model, Locale locale) {
		try {
			if (result.hasErrors()) {
				return FORM;
			} else {
				svc.guardar(categoria);

				model.addAttribute(ATT_EXITO, messages
						.getMessage("mensaje.exito.categoria", null, locale));
				if (categoria.getIdCategoria() != null) {
					return listar(model);
				}else {
					// Limpiar formulario
					model.addAttribute(ATT_ITEM, new Categoria());
					
					return FORM;
				}
			
			}

		} catch (Exception e) {

			if (e.getCause() instanceof org.hibernate.TransactionException) {
				result.reject("mensaje.error.categoria");
			} else {
				result.reject("mensaje.error.form");
			}
			return FORM;

		}
	}
	/**
	 * Muestra las instancias de {@link JuegoUsuario} de un usuario
	 * 
	 * @param model
	 *            Objeto de Spring MVC para el almacenamiento de atributos
	 * @return Página con la lista de {@link JuegoUsuario} del {@link Usuario}
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listar(Model model) {
		try {
			model.addAttribute(ATT_LISTA, svc.listar());
			return LIST;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}
	@RequestMapping(value = "{idCategoria}/delete", method = RequestMethod.GET)
	public String borrar(@PathVariable int idCategoria, Model model,
			Locale locale) {
		try {

			svc.eliminar(new Categoria(idCategoria));
			model.addAttribute(ATT_EXITO,
					messages.getMessage("mensaje.exito.borrar.analisis", null, locale));

			return listar(model);

		} catch (Exception e) {
			
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}
	@RequestMapping(value = "{idCategoria}/edit", method = RequestMethod.GET)
	public String execute(@PathVariable int idCategoria, Model model) {
		try {
			model.addAttribute(ATT_ITEM, svc.buscarPorId(idCategoria));
			return FORM;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}
}
