<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="pw.*"%>
<%@ page import="javax.servlet.http.*"%>        
<%	//Cliente cliente = (Cliente) session.getAttribute("usuario");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/principal.js"></script>
<link href="css/inicio.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Restaurante Lonccos</title>
</head>
<body>
	<div id="cabeza">
		<img class="menu" id="inicio" alt="inicio" src="img/inicio.png">
		<img class="menu" id="nosotros" alt="nosotros" src="img/nosotros.png">
		<img class="menu" id="menu" alt="menu" src="img/menu.png">
		<img class="menu" id="ofertas" alt="ofertas" src="img/ofertas.png">
		<img class="menu" id="locales" alt="locales" src="img/locales.png">
		<img class="menu" id="eventos" alt="eventos" src="img/eventos.png">
		<img class="menu" id="reservas" alt="reservas" src="img/reservas.png">
		<% if(session.getAttribute("usuario") == null){%>
		<img class="menu" id="ingresar" alt="ingresar" src="img/ingresar.png">
		<% }else {%>
		<img class="menu" id="salir" alt="salir" src="img/salir.png">
		<% }%>
	</div>
	<div id="titulo">
		<br><br><br>
		<% if(session.getAttribute("usuario") != null){%>
		<p id="sesion"> Bienvenido <br>
		<% out.print(session.getAttribute("usuario"));%> 
		</p>
		<% }%>
	</div>
	<div id="cuerpo">
	</div>
	<div id="pie">
		<p id="pie_text">Copyright © Lonccos<br>
		Restaurant Lonccos<br>
		Derechos Reservados</p>
	</div>
</body>
</html>