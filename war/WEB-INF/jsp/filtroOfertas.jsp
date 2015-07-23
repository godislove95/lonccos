<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="pw.*"%>
<%@ page import="java.util.*;"%>
<%
	List<Plato> lista = (List<Plato>) request.getAttribute("lista");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/tablaRegistro.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
	<%
		if (lista.size() != 0) {
	%>

	<div class="Table">

		<div class="Title">
			<h1>LAS OFERTAS DEL MES </h1>
			<p>Los mas exquisitos platos a tu alcanse de tu economia aprovecha las grandes promociones
			 que tietes nuestros restaurantes <strong>LONCCOS</strong> la mejor casena de restaurantes de la Region<p>
		</div>
		<div class="Heading">
			<div class="Cell"><h3>IMAGEN</h3></div>
			<div class="Cell"><h3>NOMBRE</h3></div>
			<div class="Cell"><h3>PRECIO</h3></div>
			
		</div>

		<%for(Plato p: lista){
			if(p.getPrecio()<=15){
		%>
		<div class="Heading">
			
			<div class="Cell">
				<% out.println(p.getImg());%>
			</div> 
			<div class="Cell">
				<% out.println(p.getNombre()); %>
			</div>
			<div class="Cell">
				<% out.println(p.getPrecio()); %>
			</div>
		</div>
		<% }
		}%>
	
	</div>

	<%
		} else {
	%>
	<b> NO EXISTE NINGUNA PLATO EN OFERTA</b>
	<%}%>
</body>
</html>