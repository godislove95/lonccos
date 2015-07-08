<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/registro.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Restaurante Lonccos</title>
</head>
<body>
<section id="cero">
		<div id="uno">
			<div id="table">
				<h2 align="center">Registro</h2>
				
				<form action="/saveCliente" method="post" onsubmit="return validar();">
				<div class="row">
				<div class="cell">Ingrese su Nombre :</div>
				<div class="cell"><input type="text" name="nombre" size="40" pattern="([a-z]{2,20})|([a-z]{2,20} [a-z]{2,20})|([a-z]{2,20} [a-z]{2,20} [a-z]{2,20})" required></div>	
				</div>
				<div class="row">
				<div class="cell">Ingrese su Apellido Paterno :</div>
				<div class="cell"><input type="text" name="paterno" size="40" pattern="([a-z]{2,20})"  required></div>
				</div>
				<div class="row">
				<div class="cell"> Ingrese su Apellido Materno :</div>
				<div class="cell"><input type="text" name="materno" size="40" pattern="([a-z]{2,20})" required></div>	
				</div>
				<div class="row">
				<div class="cell">DNI</div>
				<div class="cell"><input type="text" name="dni" size="10" maxlength="8"  pattern="[0-9]{8}"required/></div>
				</div>
				<div class="row">
				<div class="cell">Correo electronico</div> 
				<div class="cell"><input type="text" name="email" size="40"  pattern="^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,3})$" required/></div>	
				</div>
				<div class="row">
				<div class="cell">Ingrese password </div>
				<div class="cell"><input type="password" name="pass" size="40" placeholder="pass" required/></div>
				</div>
				<div class="row">
				<div class="cell"></div>
				<div class="cell"><input type="submit" value="registrarse"/></div>
				</div>
				</form>
			</div>
		</div>
	</section>
</body>
</html>