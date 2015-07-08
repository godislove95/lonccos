$(document).ready(function(){
	$("#registro").click(function(event) {
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