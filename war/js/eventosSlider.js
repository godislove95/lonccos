$(document).ready(function(){
	var j = 0;
	function colm1(){
		switch (j % 4) {
		case 1:
			$("#colm1").html('<img class="imgEvento" src="img/of_rocoto.jpg">');
			break;
		case 2:
			$("#colm1").html('<img class="imgEvento" src="img/of_triple.jpg">');
			break;
		case 3:
			$("#colm1").html('<img class="imgEvento" src="img/of_chicharron.jpg">');
			break;
		default:
			$("#colm1").html('<img class="imgEvento" src="img/of_adobo.jpg">');
			break;
		}
		j++;
	}
	setInterval(function(){colm1()}, 4000);
});