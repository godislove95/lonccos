<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/cambiar.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form action="cambio" id="cambiarPass">
		ACTUAL CONTRASEÑA<br>
		<input type="password" name="pass" required><br>
		NUEVA CONTRASEÑA<br>
		<input type="password" name="nuevoPass1" required><br>
		REPITA NUEVA CONTRASEÑA<br>
		<input type="password" name="nuevoPass2" required><br>
		<input type="submit" value="CAMBIAR CONTRASEÑA">
	</form>
</body>
</html>