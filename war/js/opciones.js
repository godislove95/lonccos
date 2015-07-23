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
            data: {"rest": "historialCliente"},
            success: function(data){
            	$("#subcuerpocliente").html(data);
            }
        });
	});
	
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
	$("#agregarPlato").click(function(event) {
		$("#subcuerpomenu").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "/cambio",
            data: {"rest": "agregarPlato"},
            success: function(data){
            	$("#subcuerpomenu").html(data);
            }
        });
	});
	$("#borrarPlato").click(function(event) {
		
		$("#subcuerpomenu").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "/cambio",
            data: {"rest": "borrarPlato"},
            success: function(data){
            	$("#subcuerpomenu").html(data);
            }
        });
	});
	$("#editarPlato").click(function(event) {
		$("#subcuerpomenu").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "/cambio",
            data: {"rest": "editarPlato"},
            success: function(data){
            	$("#subcuerpomenu").html(data);
            }
        });
	});
	
	$("#listarPlato").click(function(event) {
		$("#subcuerpomenu").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "/cambio",
            data: {"rest": "listarPlato"},
            success: function(data){
            	$("#subcuerpomenu").html(data);
            }
        });
	});
	
	$("#imagenPlato").click(function(event) {
		$("#subcuerpomenu").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "/cambio",
            data: {"rest": "imagenPlato"},
            success: function(data){
            	$("#subcuerpomenu").html(data);
            }
        });
	});
	
	$("#agregarBebida").click(function(event) {
		$("#subcuerpoBebida").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "/cambio",
            data: {"rest": "agregarBebida"},
            success: function(data){
            	$("#subcuerpoBebida").html(data);
            }
        });
	});
	$("#borrarBebida").click(function(event) {
		
		$("#subcuerpoBebida").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "/cambio",
            data: {"rest": "borrarBebida"},
            success: function(data){
            	$("#subcuerpoBebida").html(data);
            }
        });
	});
	$("#editarBebida").click(function(event) {
		$("#subcuerpoBebida").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "/cambio",
            data: {"rest": "editarBebida"},
            success: function(data){
            	$("#subcuerpoBebida").html(data);
            }
        });
	});
	
	$("#listarBebida").click(function(event) {
		$("#subcuerpoBebida").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "/cambio",
            data: {"rest": "listarBebida"},
            success: function(data){
            	$("#subcuerpoBebida").html(data);
            }
        });
	});
	
	$("#borrarReserva").click(function(event) {
		$("#subcuerpoReserva").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "/cambio",
            data: {"rest": "borrarReserva"},
            success: function(data){
            	$("#subcuerpoReserva").html(data);
            }
        });
	});
	
	
	
	$("#editarReserva").click(function(event) {
		$("#subcuerpoReserva").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "/cambio",
            data: {"rest": "editarReserva"},
            success: function(data){
            	$("#subcuerpoReserva").html(data);
            }
        });
	});
	
	
	$("#listarReserva").click(function(event) {
		$("#subcuerpoReserva").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "POST",
            url: "/cambio",
            data: {"rest": "listarReserva"},
            success: function(data){
            	$("#subcuerpoReserva").html(data);
            }
        });
	});
	
	
	
	
});