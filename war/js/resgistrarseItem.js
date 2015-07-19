$(document).ready(function(){
	$("#savePlato").submit(function(event) {

		event.preventDefault();
		var $form = $(this),
		nombre = $form.find( "input[name='nombrePlato']" ).val(),
		tipo = $form.find( "select[name='tipo']" ).val(),
		descripcion = $form.find( "textarea[name='descripcion']" ).val(),
		precio = $form.find( "input[name='precio']" ).val(),
		url = $form.attr( "action" );
		$("#cuerpoAgregarPlato").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');	
		$.ajax({
			type: "POST",
			url: url,
			data: {"nombre": nombre,"tipo": tipo,"descripcion": descripcion,
				"precio": precio},
				success: function(data){
					$("#cuerpoAgregarPlato").html(data);
				}
		});
	});
	$("#saveBebida").submit(function(event) {

		event.preventDefault();
		var $form = $(this),
		nombre = $form.find( "input[name='nombreBebida']" ).val(),
		tipo = $form.find( "select[name='tipoBebida']" ).val(),
		descripcion = $form.find( "textarea[name='descripcionBebida']" ).val(),
		precio = $form.find( "input[name='precioBebida']" ).val(),
		url = $form.attr( "action" );
		$("#cuerpoAgregarBebida").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');	
		$.ajax({
			type: "POST",
			url: url,
			data: {"nombreBebida": nombre,"tipoBebida": tipo,"descripcionBebida": descripcion,
				"precioBebida": precio},
				success: function(data){
					$("#cuerpoAgregarBebida").html(data);
				}
		});
	});
	
	$("#saveImagen").submit(function(event) {

		event.preventDefault();
		var $form = $(this),
		file = $form.find( "input[name='myFile']" ).val(),
		url = $form.attr( "action" );
		$("#anadirImagenBebida").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');	
		$.ajax({
			type: "POST",
			url: url,
			data: {"myFile": file},
				success: function(data){
					$("#anadirImagenBebida").html(data);
				}
		});
	});
});