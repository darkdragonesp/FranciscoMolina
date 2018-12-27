/**
 * 
 */
package es.arelance.proyecto;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.arelance.proyecto.modelo.TipoUsuario;
import es.arelance.proyecto.modelo.Usuario;
import es.arelance.proyecto.modelo.dao.TipoUsuarioDao;
import es.arelance.proyecto.modelo.dao.UsuarioDao;

/**
 * @author Francisco Molina Sánchez
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UsuarioDaoTest {

	@Autowired
	private UsuarioDao dao;

	@Autowired
	private TipoUsuarioDao tDao;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		TipoUsuario tipo = new TipoUsuario();
		tipo.setNombre("Usuario");
		tDao.save(tipo);
	}

	@Test
	public void test() {
		Usuario usuario = new Usuario();
		usuario.setNombreUsuario("user");
		usuario.setContrasena("user");
		usuario.setCorreo("user@user.com");
		usuario.setFechaAlta(new Date());
		usuario.setTipoUsuario(new TipoUsuario(1));
		dao.save(usuario);

		Usuario saved = dao.findByNombreUsuarioAndContrasena("user", "user");

		assertTrue(saved != null
				&& saved.getNombreUsuario().equals(usuario.getNombreUsuario()));

		Usuario otro = dao.findByNombreUsuarioAndContrasena("user", "user2");
		assertTrue(otro == null);

		// Optional<Producto> saved = dao.findById(1);
		//
		// assertTrue(saved.isPresent()
		// && saved.get().getNombre().equals(producto.getNombre()));
	}

}
