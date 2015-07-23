$(document).ready(function(){
	var j = 0;
	function col1(){
		switch (j % 4) {
		case 1:
			$("#col1").html('<img class="imgLocales" src="img/of_rocoto.jpg">');
			break;
		case 2:
			$("#col1").html('<img class="imgLocales" src="img/of_triple.jpg">');
			break;
		case 3:
			$("#col1").html('<img class="imgLocales" src="img/of_chicharron.jpg">');
			break;
		default:
			$("#col1").html('<img class="imgLocales" src="img/of_adobo.jpg">');
			break;
		}
		j++;
	}
	setInterval(function(){col1()}, 4000);
});