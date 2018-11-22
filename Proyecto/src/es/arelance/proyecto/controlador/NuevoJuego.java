package es.arelance.proyecto.controlador;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.arelance.proyecto.modelo.TipoUsuario;
import es.arelance.proyecto.modelo.Usuario;


@WebServlet("/nuevoJuego")
public class NuevoJuego extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String SUCCESS = "/formJuego.jsp"; 
	private static final String ERROR = "/error.jsp";
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevoJuego() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Usuario user = new Usuario();
			user.setNombreUsuario("admin");
			user.setCorreo("admin@admin.com");
			user.setFechaAlta(new Date());
			TipoUsuario tipo= new TipoUsuario();
			tipo.setId(1);
			tipo.setNombre("admin");
			user.setTipoUsuario(tipo);
			
			
			HttpSession sesion = request.getSession();
			sesion.setAttribute("user", user);
			//Success
			request.getRequestDispatcher(SUCCESS).forward(request, response);
		}catch (Exception ex){
			request.setAttribute("error", ex);
			request.getRequestDispatcher(ERROR).forward(request, response);
		}
	}

}
