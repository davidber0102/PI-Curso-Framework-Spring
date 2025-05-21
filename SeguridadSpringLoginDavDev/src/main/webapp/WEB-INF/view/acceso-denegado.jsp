<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sin Acceso</title>
</head>
<body><h2><%= "Bievenidos" %></h2>
<hr>
<h3 style="text-align:center"><%= "Tu cuenta, notiene lospermisos de rolles para accerder" %></h3>
	<hr>
	<a href="${pageContext.request.contextPath}/">Volver a Inicio</a>
	<hr>

</body>
</html>