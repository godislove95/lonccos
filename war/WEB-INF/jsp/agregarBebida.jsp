<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService" %>

<%
    BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/registro.css" rel="stylesheet" type="text/css">
<script  type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/resgistrarseItem.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Registrar Bebida</title>
</head>
<body>
<div id=cuerpoAgregarBebida>
<div id="cero">

			<div id="table">
				<h2 align="center">Registrar Plato</h2>
				
				<form action="/saveBebida" id="saveBebida" method="post" onsubmit="return validar();">
				
				<div class="row">
				<div class="cell">Nombre</div>
				<div class="cell"><input type="text" name="nombreBebida" id="nombreBebida" size="40" pattern="([a-z]{2,20})"  required></div>
				</div>
				<div class="row">
				<div class="cell">Tipo de Bebida</div>
				<div class="cell"><select name="tipoBebida" id="tipoBebida">
								<option value="ad_gaseosa">Gaseosa</option>
								<option value="ad_cerveza">Verveza</option>
								<option value="ad_tragos">Tragos</option>
								<option value="ad_agua">Agua</option>
								</select>
								</div>	
				</div>
				<div class="row">
				<div class="cell">Descripcion</div> 
				<div class="cell"><textarea name="descripcionBebida" id="descripcionBebida" width="100px" higth="100px"  required="required" placeholder="Ingrese descripcion"></textarea></div>	
				</div>
				<div class="row">
				<div class="cell">Precio</div>
				<div class="cell"><input type="text" name="precioBebida" id="precioBebida" size="10"   pattern="[0-9]{8}"required/></div>
				</div>
				<div class="row">
				<div class="cell"></div>
				<div class="cell"><input id="agregarBebida" type="submit" value="agregarBebida"/></div>
				</div>
				</form>
			</div>
	</div>
</div>	
</body>
</html>