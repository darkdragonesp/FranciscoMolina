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
	 *            Archivo a almacenar
	 * @param destino
	 *            Ruta en disco
	 * @throws IOException
	 *             Excepción relativa a la manipulación de archivos
	 */
	public void guardar(MultipartFile file, String destino) throws IOException;

}