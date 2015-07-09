$(document).ready(function(){
	var i = 1;
	function slider(){
		switch (i % 4) {
		case 1:
			$("#contador").html('Direccionando en 3 segundo');
			break;
		case 2:
			$("#contador").html('Direccionando en 2 segundo');
			break;
		case 3:
			$("#contador").html('Direccionando en 1 segundo');
			break;
		default:
			setTimeout('document.location.reload()', 500);
			break;
		}
		i++;
	}
	setInterval(function(){slider()}, 1000);
});