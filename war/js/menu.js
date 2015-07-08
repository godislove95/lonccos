$(document).ready(function(){
	$("#Entrada").click(function(event) {
		$.ajax({
            type: "POST",
            url: "restaurant",
            data: {"rest": "inicio"},
            success: function(data){
            	$("#cuerpo").html(data);
            }
        });
	});
	$("#Sopa").click(function(event) {
		$.ajax({
            type: "POST",
            url: "restaurant",
            data: {"rest": "nosotros"},
            success: function(data){
            	$("#cuerpo").html(data);
            }
        });
	});
	$("#Fondo").click(function(event) {
		$.ajax({
            type: "POST",
            url: "restaurant",
            data: {"rest": "menu"},
            success: function(data){
            	$("#cuerpo").html(data);
            }
        });
	});
	$("#Ensalada").click(function(event) {
		$.ajax({
            type: "POST",
            url: "restaurant",
            data: {"rest": "ofertas"},
            success: function(data){
            	$("#cuerpo").html(data);
            }
        });
	});
	$("#Postre").click(function(event) {
		$.ajax({
            type: "POST",
            url: "restaurant",
            data: {"rest": "locales"},
            success: function(data){
            	$("#cuerpo").html(data);
            }
        });
	});
	$("#Extra").click(function(event) {
		$.ajax({
            type: "POST",
            url: "restaurant",
            data: {"rest": "eventos"},
            success: function(data){
            	$("#cuerpo").html(data);
            }
        });
	});
	$("#Bebida").click(function(event) {
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
		$.ajax({
            type: "POST",
            url: "restaurant",
            data: {"rest": "ingresar"},
            success: function(data){
            	$("#cuerpo").html(data);
            }
        });
	});
});