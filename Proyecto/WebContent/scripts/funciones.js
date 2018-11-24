/**
 * @autor Francisco Molina Sánchez
 */

/**
 * Función que pide la confirmación de un evento al usuario
 * 
 * @param mensaje
 *            mensaje para el usuario
 * @returns true si es confirmado; false en otro caso
 */
function confirmar(mensaje) {
	console.log(mensaje);
	return window.confirm(mensaje);
}