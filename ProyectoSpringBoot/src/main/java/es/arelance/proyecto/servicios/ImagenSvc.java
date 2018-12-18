package es.arelance.proyecto.servicios;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

/**
 * Interfaz para la gestión de imágenes
 * 
 * @author ajurado
 *
 */
public interface ImagenSvc {

	/**
	 * Guardar un archivo
	 * 
	 * @param file
	 *            archivo a almacenar
	 * @param destino
	 *            ruta en disco
	 * @throws IOException
	 */
	public void guardar(MultipartFile file, String destino) throws IOException;

}