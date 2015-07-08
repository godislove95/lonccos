<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/ingresar.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
<div id="registro">

		<h1>INGRESAR</h1>
		<br>
		<div id="contenedor">
			<form method="post" action="/iniciarSesion">
				<div id="contenidos">
					<div id="columna1">Usuario:</div>
					<div id="columna2">
						<input type="text" name="user"pattern="^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,3})$"required>
					</div>
				</div>
				<div id="contenidos">
					<div id="columna1">Contraseña:</div>
					<div id="columna2">
						<input type="password" name="pass" required>
					</div>
				</div>
				<input type="submit" value="Ingresar" class="primero"> 
			</form>
			<form action="/restaurantServlet" method="post">
				<input type="submit" name="rest" value="Registrarse" class="segundo">
			</form>
		</div>
	</div>
</body>
</html>