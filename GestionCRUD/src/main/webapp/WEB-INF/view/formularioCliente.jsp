<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Cliente</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css">
</head>
<body>

<h1>Fomulario para Agregar cliente</h1>
	<form:form action="insertarCliente" modelAttribute="cliente" tethod="POST">
		<form:hidden path="id"/>
		<table>
			<tr>
				<td>Nombre: </td>
				<td><form:input path="nombre"/></td>
			</tr>
			
			<tr>
				<td>Apellido: </td>
				<td><form:input path="apellido"/></td>
			</tr>
			
			<tr>
				<td>E-mail: </td>
				<td><form:input path="email"/></td>
			</tr>
			
			<tr>
				<td colspan="2"> <input type="submit" value="Insertar"></td>
			</tr>
			
		</table>		
	</form:form>

</body>
</html>