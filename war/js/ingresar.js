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
		
		var $form = $( this ),
			email = $form.find( "input[name='email']" ).val(),
		    pass = $form.find( "input[name='pass']" ).val(),
		    url = $form.attr( "action" );
		$("#cuerpo").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: url,
            data: {"email": email, "pass": pass},
            success: function(data){
            	$("#cuerpo").html(data);
            }
        });
	});
});