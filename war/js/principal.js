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
	// Attach a submit handler to the form
	$("#inicio").click(function(event) {
		$.ajax({
            type: "POST",
            url: "restaurant",
            data: {"rest": "Inicio"},
            success: function(data){
            	$("#cuerpo").html(data);
            }
        });
	});
	
});