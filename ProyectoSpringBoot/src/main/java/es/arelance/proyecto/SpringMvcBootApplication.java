package es.arelance.proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Aplicación Spring Boot integrada con MVC (JSP)
 * @author ajurado
 *
 */
@SpringBootApplication
@EnableJpaRepositories("es.arelance.proyecto.modelo.dao")
public class SpringMvcBootApplication extends SpringBootServletInitializer {
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringMvcBootApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcBootApplication.class, args);
	}
}
