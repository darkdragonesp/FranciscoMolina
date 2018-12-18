/*
 * Si se ha aplicado truncado (ellipsis) en una cadena de texto se muestra 
 * una ventana emergente con el texto completo.
 */
$(document).on('mouseenter', ".iffyTip", function() {
	var $this = $(this);
	if (this.offsetWidth < this.scrollWidth && !$this.attr('title')) {
		$this.tooltip({
			title : $this.text(),
			placement : "top"
		});
		$this.tooltip('show');
	}
});
$('.hideText').css('width', $('.hideText').parent().width());
