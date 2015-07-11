$(document).ready(function(){
	$("#cambiarPass").submit(function(event) {
		event.preventDefault();
		var $form = $(this),
		pass = $form.find( "input[name='pass']" ).val(),
		nuevoPass1 = $form.find( "input[name='nuevoPass1']" ).val(),
		nuevoPass2 = $form.find( "input[name='nuevoPass2']" ).val(),
	    url = $form.attr( "action" );
		if(nuevoPass1 != nuevoPass2)
			alert("Su contraseña no es igual");
		else{
			$("#cuerpo").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
			$.ajax({
	            type: "post",
	            url: url,
	            data: {"rest": "cambiarPass","pass": pass, "nuevoPass1": nuevoPass1},
	            success: function(data){
	            	$("#cuerpo").html(data);
	            }
	        });
		}
	});
	$("#cambiarPaterno").submit(function(event) {
		event.preventDefault();
		var $form = $(this),
		paterno = $form.find( "input[name='paterno']" ).val(),
	    url = $form.attr( "action" );
		$("#cuerpo").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "post",
            url: url,
            data: {"rest": "cambiarPaterno","paterno": paterno},
            success: function(data){
            	$("#cuerpo").html(data);
            }
        });
	});
	$("#cambiarNombre").submit(function(event) {
		event.preventDefault();
		var $form = $(this),
		nombre = $form.find( "input[name='nombre']" ).val(),
	    url = $form.attr( "action" );
		$("#cuerpo").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "post",
            url: url,
            data: {"rest": "cambiarNombre","nombre": nombre},
            success: function(data){
            	$("#cuerpo").html(data);
            }
        });
	});
	$("#cambiarMaterno").submit(function(event) {
		event.preventDefault();
		var $form = $(this),
		materno = $form.find( "input[name='materno']" ).val(),
	    url = $form.attr( "action" );
		$("#cuerpo").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "post",
            url: url,
            data: {"rest": "cambiarMaterno","materno": materno},
            success: function(data){
            	$("#cuerpo").html(data);
            }
        });
	});
});