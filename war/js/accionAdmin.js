$(document).ready(function(){
	$("#bloquearAccionCliente").submit(function(event) {
		event.preventDefault();
		var $form = $(this),
		email = $form.find('input:radio[name = emailAdmin]:checked').val(),
	    url = $form.attr( "action" );
		$("#subcuerpocliente").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: url,
            data: {"accion": "bloquearAccionCliente", "email": email},
            success: function(data){
            	$("#subcuerpocliente").html(data);
            }
        });
	});
	$("#borrarAccionCliente").submit(function(event) {
		event.preventDefault();
		var $form = $(this),
		email = $form.find('input:radio[name = emailCliente]:checked').val(),
	    url = $form.attr( "action" );
		$("#subcuerpocliente").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: url,
            data: {"accion": "borrarCliente", "email": email},
            success: function(data){
            	$("#subcuerpocliente").html(data);
            }
        });
	});
	
	$("#borrarAccionAdmin").submit(function(event) {
		event.preventDefault();
		var $form = $(this),
		email = $form.find('input:radio[name = emailAdmin]:checked').val(),
	    url = $form.attr( "action" );
		$("#bodyborrarAccionAdmin").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: url,
            data: {"accion": "borrarAdmin", "email": email},
            success: function(data){
            	$("#bodyborrarAccionAdmin").html(data);
            }
        });
	});
	$("#borrarAccionPlato").submit(function(event) {
		event.preventDefault();
		var $form = $(this),
		id = $form.find('input:radio[name = id]:checked').val(),
	    url = $form.attr( "action" );
		$("#subcuerpomenu").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: url,
            data: {"accion": "borrarPlato", "id": id},
            success: function(data){
            	$("#subcuerpomenu").html(data);
            }
        });
	});
	$("#borrarAccionBebida").submit(function(event) {
		event.preventDefault();
		var $form = $(this),
		id = $form.find('input:radio[name = id]:checked').val(),
	    url = $form.attr( "action" );
		$("#subcuerpoBebida").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: url,
            data: {"accion": "borrarAccionBebida", "id": id},
            success: function(data){
            	$("#subcuerpoBebida").html(data);
            }
        });
	});
});