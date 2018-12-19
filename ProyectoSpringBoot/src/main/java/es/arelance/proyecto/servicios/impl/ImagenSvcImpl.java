package es.arelance.proyecto.servicios.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import es.arelance.proyecto.servicios.ImagenSvc;

/**
 * Implementación de servicios de imagen
 * 
 * @author ajurado
 *
 */
@Service
public class ImagenSvcImpl implements ImagenSvc {

	@Override
	public void guardar(MultipartFile file, String destino) throws IOException {
		BufferedInputStream entrada = null;
		BufferedOutputStream salida = null;

		try {
			// abrimos fichero para lectura
			entrada = new BufferedInputStream(file.getInputStream());
			// abrimos fichero para escritura
			salida = new BufferedOutputStream(
					new FileOutputStream(new File(destino)));

			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = entrada.read(bytes)) != -1) {
				salida.write(bytes, 0, read);
			}

		} finally {
			if (entrada != null) {
				entrada.close();
			}
			if (salida != null) {
				salida.flush();
				salida.close();
			}
		}
	}

}
