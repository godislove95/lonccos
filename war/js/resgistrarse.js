$(document).ready(function(){
	$("#registrarse").click(function(event) {
		$.ajax({
            type: "POST",
            url: "restaurant",
            data: {"rest": "registrarse"},
            success: function(data){
            	$("#cuerpo").html(data);
            }
        });
	});
});