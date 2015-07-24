<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="pw.*"%>
<%@ page import="java.util.*;"%>
<% List<Plato> array = (List<Plato>) request.getAttribute("lista");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="../js/accionAdmin.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%if(array.size() != 0) {%>
	<form action="/accionAdministrador" id="bloquearAccionPlato">
	<%	for(Plato r : array) {	%><br>
	<div class="relacion">
		<input type="radio" name="idPlato" value="<%out.print(r.getId().getId());%>">
		<b>Nombre : </b><%	out.print(r.getNombre());%><br>
		<b>Precio :</b> <%	out.print(r.getPrecio() + " ");%>
		<b>Tipo :</b> <%	out.print(r.getTipo() + " ");%>
		<b>Descripcioin : </b><%	out.print(r.getDescripcion());%><br>
		<%if(r.getBloqueado() == true) {%>
		<b>Estado : </b><p style="color : red">BLOQUEADO<br></p>
		<%} else {%>
		<b>Estado : </b><p style="color : green">DESBLOQUEADO<br></p>
	<%}%>
	</div>
	<%	}%>
	<br>
	<input type="submit" value="Bloquear/Desbloquear Plato">
	</form>
	<%} else {%>
		<br>
		<b> NO EXISTE NINGUN USUARIO</b><br>
	<%}%>
	<br>

</body>
</html>