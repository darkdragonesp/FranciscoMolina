package es.arelance.proyecto.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/miPerfil")
public class MiPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String SUCCESS = "/perfilUsuario.jsp"; 
	private static final String ERROR = "/error.jsp";
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MiPerfil() {
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
			
			
			//Success
			request.getRequestDispatcher(SUCCESS).forward(request, response);
		}catch (Exception ex){
			request.setAttribute("error", ex);
			request.getRequestDispatcher(ERROR).forward(request, response);
		}
	}

}
