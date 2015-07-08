$(document).ready(function(){
	$("#registro_submit").click(function(event) {
		$.ajax({
            type: "POST",
            url: "restaurant",
            data: {"rest": "registro"},
            success: function(data){
            	$("#cuerpo").html(data);
            }
        });
	});
	$("#iniciarSesion").submit(function(event) {
		event.preventDefault();
		var $form = $(this),
		user = $form.find( "input[name='user']" ).val(),
		pass = $form.find( "input[name='pass']" ).val(),
	    url = $form.attr( "action" );
		$("#cuerpo").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: url,
            data: {"user": user, "pass": pass},
            success: function(data){
            	$("#cuerpo").html(data);
            }
        });
	});
});