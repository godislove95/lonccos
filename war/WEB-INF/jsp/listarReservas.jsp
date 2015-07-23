<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="pw.*"%>
<%@ page import="java.util.*;"%>
<%
	List<Usuario> users = (List<Usuario>) request.getAttribute("lista");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/tablaRegistroAdmin.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
	<%
		if (users.size() != 0) {
	%>

	<div class="Table">

		<div class="Title">
			<h1>LISTA DE RESERVAS</h1>
		</div>
		<div class="Heading">
			<div class="Cell"><h3>USUARIO</h3></div>
			<div class="Cell"><h3>HORA</h3></div>
			<div class="Cell"><h3>NUMERO</h3></div>
			<div class="Cell"><h3>LUGAR</h3></div>
			<div class="Cell"><h3>ZONA</h3></div>
			<div class="cell"><h3>FECHA</h3></div>
			<div class="Cell"><h3>TIPO</h3></div>
		</div>

		<%
		for(Usuario u:users){
		if(u.getAdmin()==0 || u.getAdmin()==1)%>
		<div class="Heading">
			<div class="cell"> 
			<%out.println(u.getEmail()); %>
			</div>
			<% for(Reserva p: u.getReservas()){
		%>
		
			<div class="Cell">
				<% out.println(p.getHora()); %>
			</div>

			<div class="Cell">
				<% out.println(p.getNumero()); %>
			</div>
			
			<div class="Cell">
				<% out.println(p.getLugar()); %>
			</div>
			
			<div class="Cell">
				<% out.println(p.getZona());%>
			</div>
			
			<div class="Cell">
				<% out.println(p.getFecha());%>
			</div>
			
			<div class="Cell">
			<% out.println(p.getTipo());%>
			</div>
		</div>
		<% }}%>
	</div>
	<%
		} else {
	%>
	<b> NO EXISTE RESERVAS</b>
	<br> ¡¡¡ Reserve !!!
	<%}%>
</body>
</html>