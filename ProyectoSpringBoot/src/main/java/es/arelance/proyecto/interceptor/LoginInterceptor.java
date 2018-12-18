package es.arelance.proyecto.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import es.arelance.proyecto.modelo.Usuario;
import es.arelance.proyecto.servicios.UsuarioSvc;

/**
 * Interceptor de control de acceso de {@link Usuario} para su autentificación y
 * autenticación
 * 
 * @author Francisco Molina Sanchez
 * 
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

	public static final String ATT_USER = "sessionUser";
	private static final String INDEX = "/index.jsp";
	private static final String LOGIN = "usuario/login";
	private static final String REGISTRO = "/usuario/save";
	private static final String ERROR = "/error";

	@Autowired
	private UsuarioSvc svc;

	/**
	 * Controla a que puede acceder dentro del sistema un {@link Usuario} según
	 * el tipo de usuario
	 * 
	 * @return {@code true} si se tiene acceso al recurso; en otro caso
	 *         {@code false}
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String uri = request.getRequestURI();
		Usuario usuario = (Usuario) request.getSession().getAttribute(ATT_USER);

		if (usuario == null) {
			if (!(uri.endsWith(LOGIN) || uri.endsWith(REGISTRO)
					|| uri.endsWith(ERROR))) {
				response.sendRedirect(INDEX);
				return false;
			}
		} else {
			// Comprobar autorización
			boolean res = svc.comprobar(usuario, uri);
			if (!res) {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				response.sendRedirect(request.getContextPath() + INDEX);
			}
			return res;
		}
		return true;
	}

}
