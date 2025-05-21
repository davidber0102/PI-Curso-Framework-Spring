<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario procesado</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/recursos/estilos/miestilo.css">
</head>
<body>

 hola ${param.nombreAlumno}. Bienvenido al curso de Spring


	<p> <br>	
	<h3>	Atencion a todos </h3> 
		${mensaje}
	</p>
	
	<img alt="img" src="${pageContext.request.contextPath}/recursos/imgs/tree-8411271_1920.jpg">
	
</body>
</html>