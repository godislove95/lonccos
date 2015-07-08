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
});