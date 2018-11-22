package es.arelance.proyecto.controlador;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.arelance.proyecto.modelo.Categoria;
import es.arelance.proyecto.modelo.Juego;


@WebServlet("/listarJuegos")
public class ListarJuegos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String SUCCESS = "/listadoJuegos.jsp"; 
	private static final String ERROR = "/error.jsp";
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarJuegos() {
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
			List<Juego> lista = new LinkedList<Juego>();
			Juego j= new Juego();
			j.setIdJuego(2);
			j.setFechaLanzamiento(new Date());
			Categoria c=new Categoria();
			c.setIdCategoria(1);
			c.setNombre("categoria a");
			j.setCategoria(c);
			j.setTitulo("titulo juego");
			
			lista.add(j);
			request.setAttribute("listaJuegos", lista);
			//Success
			request.getRequestDispatcher(SUCCESS).forward(request, response);
		}catch (Exception ex){
			ex.printStackTrace();
			request.setAttribute("error", ex);
			request.getRequestDispatcher(ERROR).forward(request, response);
		}
	}

}
