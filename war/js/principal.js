$(document).ready(function(){
	
	var i = 0;
	function slider(){
		switch (i % 3) {
		case 1:
			$("#slider").html('<img class="cambio" src="img/slider1.png">');
			break;
		case 2:
			$("#slider").html('<img class="cambio" src="img/slider2.png">');
			break;
		default:
			$("#slider").html('<img class="cambio" src="img/slider3.png">');
			break;
		}
		i++;
	}
	setInterval(function(){slider()}, 4000);
	
	$("#cambiar_Pass").click(function(event) {
		$("#cuerpo").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "restaurant",
            data: {"rest": "inicio"},
            success: function(data){
            	$("#cuerpo").html("Cambiar Contraseña");
            }
        });
	});
	
	$("#cambiar_Nombre").click(function(event) {
		$("#cuerpo").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "restaurant",
            data: {"rest": "inicio"},
            success: function(data){
            	$("#cuerpo").html("Cambiar Nombre");
            }
        });
	});
	
	$("#cambiar_Paterno").click(function(event) {
		$("#cuerpo").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "restaurant",
            data: {"rest": "inicio"},
            success: function(data){
            	$("#cuerpo").html("Cambiar Apellido Paterno");
            }
        });
	});
	
	$("#cambiar_Materno").click(function(event) {
		$("#cuerpo").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "restaurant",
            data: {"rest": "inicio"},
            success: function(data){
            	$("#cuerpo").html("Cambiar Apellido Materno");
            }
        });
	});
	
	$("#menu_Usuario").click(function(event) {
		$("#cuerpo").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "restaurant",
            data: {"rest": "inicio"},
            success: function(data){
            	$("#cuerpo").html("Cambiar Apellido Materno");
            }
        });
	});
	
	$("#sesionAdmin").click(function(event) {
		$("#cuerpo").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "restaurant",
            data: {"rest": "inicio"},
            success: function(data){
            	$("#cuerpo").html("Administrador");
            }
        });
	});
	
	$.ajax({
        type: "POST",
        url: "restaurant",
        data: {"rest": "inicio"},
        success: function(data){
        	$("#cuerpo").html(data);
        }
    });
	// Attach a submit handler to the form
	$("#inicio").click(function(event) {
		$("#cuerpo").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "restaurant",
            data: {"rest": "inicio"},
            success: function(data){
            	$("#cuerpo").html(data);
            }
        });
	});
	$("#nosotros").click(function(event) {
		$("#cuerpo").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "restaurant",
            data: {"rest": "nosotros"},
            success: function(data){
            	$("#cuerpo").html(data);
            }
        });
	});
	$("#menu").click(function(event) {
		$("#cuerpo").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "restaurant",
            data: {"rest": "menu"},
            success: function(data){
            	$("#cuerpo").html(data);
            }
        });
	});
	$("#ofertas").click(function(event) {
		$("#cuerpo").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "restaurant",
            data: {"rest": "ofertas"},
            success: function(data){
            	$("#cuerpo").html(data);
            }
        });
	});
	$("#locales").click(function(event) {
		$("#cuerpo").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "restaurant",
            data: {"rest": "locales"},
            success: function(data){
            	$("#cuerpo").html(data);
            }
        });
	});
	$("#eventos").click(function(event) {
		$("#cuerpo").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "restaurant",
            data: {"rest": "eventos"},
            success: function(data){
            	$("#cuerpo").html(data);
            }
        });
	});
	$("#reservas").click(function(event) {
		$("#cuerpo").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "restaurant",
            data: {"rest": "reservas"},
            success: function(data){
            	$("#cuerpo").html(data);
            }
        });
	});
	$("#ingresar").click(function(event) {
		$("#cuerpo").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "restaurant",
            data: {"rest": "ingresar"},
            success: function(data){
            	$("#cuerpo").html(data);
            }
        });
	});
	$("#salir").click(function(event) {
		$("#cuerpo").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "restaurant",
            data: {"rest": "salir"},
            success: function(data){
            	$("#cuerpo").html(data);
            }
        });
	});
});