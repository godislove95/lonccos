$(document).ready(function(){
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
});