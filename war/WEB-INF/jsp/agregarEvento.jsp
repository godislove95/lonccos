<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script  type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/eventos.js"></script>

<script>
	$(function() {
		$("#datepicker2").datepicker({
			minDate : -20,
			maxDate : "+1M +10D"
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
<div id="cero">

			<div id="table">
				<h2 align="center">AGREGAR EVENTO</h2>
				
				<form action="/saveEvento" id="saveEvento" method="post" onsubmit="return validar();">
				
				<div class="row">
				<div class="cell">NOMBRE</div>
				<div class="cell"><input type="text" name="nombreEvento" id="nombreEvento" size="40"  required></div>
				</div>
				<div class="row">
				<div class="cell">
					<p>LUGAR DE RESERVA</p>
				</div>
				</div>
				<div id="columna2"><p>
					<input type="radio" name="lugar" value="yanahuara">YANAHUARA<br>
					<input type="radio" name="lugar"value="sachaca">SACHACA<br>
					<input type="radio"name="lugar" value="socabaya">SOCABAYA
					</p>
				</div>
				<div class="row">
				<div class="cell">HORA</div> 
				<div class="cell"><input type="text" id="horaEvento" name="horaEvento" size="40" required/></div>	
				</div>
				<div class="row">
				<div class="cell">FECHA</div>
				<div class="cell"><input type="text" id="datepicker2" name="fecha" placeholder="mes/dia/año"/><br></div>
				</div>
				<div class="row">
				<div class="cell"></div>
				<div class="cell"><input id="agregarEvento" type="submit" value="AGREGAR"/></div>
				</div>
				</form>
			</div>
	</div>


</body>
</html>