$(document).ready(function(){
	$("#borarCliente").click(function(event) {
		$("#subcuerpocliente").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "/cambio",
            data: {"rest": "borrarCliente"},
            success: function(data){
            	$("#subcuerpocliente").html(data);
            }
        });
	});
	$("#editarCliente").click(function(event) {
		$("#subcuerpocliente").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "/cambio",
            data: {"rest": "editarCliente"},
            success: function(data){
            	$("#cuerpoAdmin").html(data);
            }
        });
	});
	$("#listarCliente").click(function(event) {
		
		$("#subcuerpocliente").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "/cambio",
            data: {"rest": "listarCliente"},
            success: function(data){
            	$("#subcuerpocliente").html(data);
            }
        });
	});
	$("#historialCliente").click(function(event) {
		$("#subcuerpocliente").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "/cambio",
            data: {"rest": "subcuerpocliente"},
            success: function(data){
            	$("#subcuerpocliente").html(data);
            }
        });
	});
});