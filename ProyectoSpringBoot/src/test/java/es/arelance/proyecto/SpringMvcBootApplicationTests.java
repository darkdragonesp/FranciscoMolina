package es.arelance.proyecto;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringMvcBootApplicationTests {

	@Autowired
    private MockMvc mockMvc;

	/**
	 * Rutas permitidas / y /inicio
	 */
	@Test
	public void index() throws Exception {
		mockMvc.perform(get("/"))
        	.andExpect(status().isFound());
	}
	@Test
	public void inicio() throws Exception {
		mockMvc.perform(get("/inicio"))
        	.andExpect(status().isFound());
	}

	@Test
	public void login() throws Exception {
		mockMvc.perform(get("/usuario/login"))
        	.andExpect(status().isOk());
	}
	
	@Test
	public void guardar() throws Exception {
		mockMvc.perform(get("/usuario/save"))
        	.andExpect(status().isOk())
        	.andExpect(view().name("usuario/form"))
//    		.andExpect(model().attributeExists("lista"))
    		;
	}
	@Test
	public void listaJuegos() throws Exception {
		mockMvc.perform(get("/juego/list"))
        	.andExpect(status().isFound());
	}
	
	
	
	
}
