<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="pw.*"%>
<%@ page import="javax.jdo.Query"%>
<%@ page import="javax.jdo.PersistenceManager"%>
<%@ page import="javax.servlet.*"%>
<%
 List <Cliente> registro = (List<Cliente>)request.getAttribute("lista");
%>
<%%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/tablaRegistro.css">
<title>Clientes</title>
</head>
<body>


	<div>
		<form action="/administradorServlet" method="post">
			<input type="submit" name="admi" value="BACK">
		<</form>
		  
			
	</div>
	<div class="Table">

		<div class="Title">
			<h1>Clientes Registrado</h1>
		</div>
		<div class="Heading">
			<div class="Cell"><h3>CORREO ELECT.</h3></div>
			<div class="Cell"><h3>NOMBRE</h3></div>
			<div class="Cell"><h3>A. PATERNO</h3></div>
			<div class="Cell"><h3>A. MATERNO</h3></div>
			<div class="Cell"><h3>DNI</h3></div>
			<div class="Cell"><h3>PASSWORD</h3></div>
		</div>

		<%for(Cliente p: registro){%>

		<div class="Heading">
			<div class="Cell">
				<% out.println(p.getEmail()); %>
			</div>
			
			<div class="Cell">
				<% out.println(p.getNombre()); %>
			</div>

			<div class="Cell">
				<% out.println(p.getPaterno()); %>
			</div>

			<div class="Cell">
				<% out.println(p.getMaterno()); %>
			</div>
			
			<div class="Cell">
				<% out.println(p.getDni()); %>
			</div>
			
			<div class="Cell">
				<% out.println(p.getPass());%>
			</div>

		</div>
		<% }%>
	</div>



</body>
</html>