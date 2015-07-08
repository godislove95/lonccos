<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="java.util.*"%>
<%@ page import="pw.*"%>
<%@ page import="javax.jdo.Query"%>
<%@ page import="javax.jdo.PersistenceManager"%>
<%@ page import="javax.servlet.*"%>
<%
 List <Plato> registro = (List<Plato>)request.getAttribute("lista");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="/administradorServlet" method="post">
			<input type="submit" name="admi" value="BACK">
		</form>
			
	</div>
	<div class="Table">

		<div class="Title">
			<h1>LISTA DE ENTRADAS</h1>
		</div>
		<div class="Heading">
			<div class="Cell"><h3>NOMBRE</h3></div>
			<div class="Cell"><h3>PRECIO</h3></div>
			<div class="Cell"><h3>DESCRIPCION</h3></div>
			<div class="Cell"><h3>IMAGEN</h3></div>
		</div>

		<%for(Plato p: registro){%>
		<% if(p.getTipo().equals("Entrada")) %>
		<div class="Heading">
			
			<div class="Cell">
				<% out.println(p.getNombre()); %>
			</div>

			<div class="Cell">
				<% out.println(p.getPrecio()); %>
			</div>
			
			<div class="Cell">
				<% out.println(p.getDescripcion()); %>
			</div>
			
			<div class="Cell">
				<% out.println(p.getImagen());%>
			</div>

		</div>
		<% }%>
	</div>
</body>
</html>