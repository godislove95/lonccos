$(document).ready(function(){
	$("#adminIndex").click(function(event) {
		$("#cuerpoAdmin").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "/administrador",
            data: {"admin": "admin"},
            success: function(data){
            	$("#cuerpoAdmin").html(data);
            }
        });
	});
	$("#menuIndex").click(function(event) {
		$("#cuerpoAdmin").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "/administrador",
            data: {"admin": "menu"},
            success: function(data){
            	$("#cuerpoAdmin").html(data);
            }
        });
	});
	$("#bebidaIndex").click(function(event) {
		$("#cuerpoAdmin").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "/administrador",
            data: {"admin": "bebida"},
            success: function(data){
            	$("#cuerpoAdmin").html(data);
            }
        });
	});
	$("#reservaIndex").click(function(event) {
		$("#cuerpoAdmin").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "/administrador",
            data: {"admin": "reserva"},
            success: function(data){
            	$("#cuerpoAdmin").html(data);
            }
        });
	});
	$("#clienteIndex").click(function(event) {
		$("#cuerpoAdmin").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "/administrador",
            data: {"admin": "cliente"},
            success: function(data){
            	$("#cuerpoAdmin").html(data);
            }
        });
	});
	$("#agregarAdmin").click(function(event) {
		$("#subcuerpoAdmin").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "/administrador",
            data: {"admin": "agregarAdmin"},
            success: function(data){
            	$("#subcuerpoAdmin").html(data);
            }
        });
	});
	$("#borrarAdmin").click(function(event) {
		$("#subcuerpoAdmin").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "/administrador",
            data: {"admin": "borrarAdmin"},
            success: function(data){
            	$("#subcuerpoAdmin").html(data);
            }
        });
	});
	$("#mostrarAdmin").click(function(event) {
		$("#subcuerpoAdmin").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "/administrador",
            data: {"admin": "mostrarAdmin"},
            success: function(data){
            	$("#subcuerpoAdmin").html(data);
            }
        });
	});
});