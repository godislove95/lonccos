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
	<div class="Title"><h2>LISTA DE FONDO</h2></div>
	<div class="Table">
		<%for(Plato p: lista){%>
		<div class="Heading">
		
			<div class="Cell1">
			<img class="img" src="/mostrarImagen?blob-key=<% out.println(p.getImg());%>" alt="img">
			</div>
			<div class="cell2">
			<div class="contecell"> 
					<div class="Heading">
			<div class="datos"><h3><u>NOMBRE</u></h3></div>
			<div class="datos">
						<% out.println(p.getNombre()); %>
					</div>

		           </div>
		   		 <div class="Heading">       
					<div class="datos"><h3><u>PRECIO</u></h3></div>
					<div class="datos">
						<% out.println(p.getPrecio()); %>
					</div>
				</div>	
				<div class="Heading"> 
				<div class="datos"><h3><u>DESCRIPCION</u></h3></div>   
					<div class="datos">
						<textarea disabled ><% out.println(p.getDescripcion()); %></textarea>
					</div>
				
				 </div>
			</div>
			</div>
		</div>
		<% }%>
	</div>
	<%
		} else {
	%>
	<b> NO EXISTE NINGUNA BEBIDA</b>
	<br> ¡¡¡ Reserve !!!
	<%}%>
</body>
</html>