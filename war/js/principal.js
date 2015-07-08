$(document).ready(function(){
	var i = 0;
	function slider(){
		switch (i % 3) {
		case 1:
			$("#slider").html('<img class="cambio" src="img/diversion.png">');
			break;
		case 2:
			$("#slider").html('<img class="cambio" src="img/contactanos.png">');
			break;
		default:
			$("#slider").html('<img class="cambio" src="img/comunicado.png">');
			break;
		}
		i++;
	}
	setInterval(function(){slider()}, 4000);
	$("#alumno").click(function(){
		$("#formIngreso").css("background-image", 'url("../img/formAlumno.png")');
		$("#formIngreso").load("/formAlumno.do")
	});
	$("#docente").click(function(){
		$("#formIngreso").css("background-image", 'url("../img/formDocente.png")');
		$("#formIngreso").load("/formDocente.do")
	});
	$("#apoderado").click(function(){
		$("#formIngreso").css("background-image", 'url("../img/formApoderado.png")');
		$("#formIngreso").load("/formApoderado.do")
	});

});