$(document).ready(function(){
	var j = 0;
	function columna1(){
		switch (j % 4) {
		case 1:
			$("#columna1Ofertas").html('<img class="imgOfertas" src="img/of_rocoto.jpg">');
			break;
		case 2:
			$("#columna1Ofertas").html('<img class="imgOfertas" src="img/of_triple.jpg">');
			break;
		case 3:
			$("#columna1Ofertas").html('<img class="imgOfertas" src="img/of_chicharron.jpg">');
			break;
		default:
			$("#columna1Ofertas").html('<img class="imgOfertas" src="img/of_adobo.jpg">');
			break;
		}
		j++;
	}
	setInterval(function(){columna1()}, 4000);
});