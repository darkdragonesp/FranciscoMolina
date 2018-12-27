package es.arelance.proyecto;

import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import es.arelance.proyecto.modelo.TipoUsuario;
import es.arelance.proyecto.modelo.Usuario;
import es.arelance.proyecto.modelo.dao.UsuarioDao;
import es.arelance.proyecto.servicios.ServiceException;
import es.arelance.proyecto.servicios.UsuarioSvc;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioSvcTest {

	// Dao falso MockBean
	@MockBean
	private UsuarioDao dao;
	
	@Autowired
	private UsuarioSvc svc;

	private Usuario usuario;
	// Configuracion del Dao falso
	@Before
	public void setUp() throws Exception {
		usuario = new Usuario();
		usuario.setNombreUsuario("user");
		usuario.setContrasena("user");
		usuario.setCorreo("user@user.com");
		usuario.setFechaAlta(new Date());
		usuario.setTipoUsuario(new TipoUsuario(1));

		// Mockito given: define un resultado fijo para un repositorio
		// Se puede leer, dado que llamo al método findById(1) obtendré el
		// objeto item
//		given(dao.findById(1)).willReturn(Optional.of(usuario));
		given(dao.findByNombreUsuarioAndContrasena("user", "user")).willReturn(usuario);
	}

	@Test
	public void test() throws ServiceException {
		Usuario saved = svc.identificar(usuario);

		assertTrue(saved != null
				&& saved.getNombreUsuario().equals(usuario.getNombreUsuario()));
	}

}
