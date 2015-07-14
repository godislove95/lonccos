<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="pw.*"%>
<%@ page import="java.util.*;"%>
<% List<Reserva> array = (List<Reserva>) request.getAttribute("lista");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if(array.size() != 0) {%>
	<%	for(Reserva r : array) {	%><br>
	<div class="relacion">
		<b>Codigo :</b> <%	out.print(r.getKey().getId());%><br>
		<b>Lugar :</b> <%	out.print(r.getLugar() + " ");%>
		<b>Tipo : </b><%	out.print(r.getTipo() + " ");%>
		<b>Numero de Mesas : </b><%	out.print(r.getNumero());%><br>
		<b>Zona : </b><%	out.print(r.getZona() + " ");%>
		<b>Hora : </b><%	out.print(r.getHora() + " ");%>
		<b>Fecha : </b><%	out.print(r.getFecha());%><br>
	</div>
	<%	}%>
	<%} else {%>
		<b> NO EXISTE NINGUNA RESERVA</b><br>
		¡¡¡ Reserve !!!
	<%}%>
</body>
</html>