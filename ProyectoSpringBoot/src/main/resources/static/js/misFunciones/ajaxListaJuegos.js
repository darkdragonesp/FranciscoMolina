/*
 *Función ajax para filtrar juegos
 */
function filtrar() {
	var form = $('form[name="filtrarJuegos"]');
	var formdata = false;
	if (window.FormData) { // Objeto HTML5, si no existe serializa el form
		formdata = new FormData(form[0]);
	}

	$.ajax({
		url : "/ajax/juego/list/filter",
		method : "POST",
		contentType : false,
		processData : false,
		timeout : 20000,
		data : formdata ? formdata : form.serialize(),
		success : function(result) {
			$('#tabla').replaceWith(result);
		},
		error : function(result) {
			alert(JSON.stringify(result));
		}
	});
}
/*
 * Función ajax para listar todos los juegos
 */
function listar() {
	$.ajax({
		url : "/ajax/juego/list",
		method : "POST",
		contentType : false,
		processData : false,
		timeout : 20000,
		success : function(result) {
			$('#tabla').replaceWith(result);
			// Limpio el filtro
			$('#tituloFiltro').val("");
			$('#categoriaFiltro').prop('selectedIndex', 0);
			$('#plataformaFiltro').prop('selectedIndex', 0);
		},
		error : function(result) {
			alert(JSON.stringify(result));
		}
	});
}