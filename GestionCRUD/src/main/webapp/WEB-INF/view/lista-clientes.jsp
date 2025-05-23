<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Proyecto</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css">
</head>
<body>
<h1>Curso Spring</h1>
	<h2>CRUD</h2>
		<p> hemos llegado a la ldsita de futuros clientes </p>

	<h4>Tabla de Clientes</h4>
	<table border="1">
		<thead> Clientes</thead>
			<tr>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Email</th>
				
				<th> Modificar</th>
			</tr>
			
			<c:forEach var="clienteTemp" items="${clientes }">
			
			<!-- Link para modificar registros -->
			<c:url var="linkActualizar" value="/cliente/muestraFormularioActualizar">
				<c:param name="clienteId" value="${clienteTemp.id}"/>
			</c:url>
			
			<!-- Link para eliminarregistros -->
			<c:url var="linkEliminar" value="/cliente/eliminar">
				<c:param name="clienteId" value="${clienteTemp.id}"/>
			</c:url>
			
				<tr>
					<td>${clienteTemp.nombre}</td>
					<td>${clienteTemp.apellido}</td>
					<td>${clienteTemp.email}</td>
					
					<td> <a href="${linkActualizar}"><input type="button" value="Modificar"/></a> </td>
					
					<td> <a href="${linkEliminar}"><input type="button" value="Eliminar" 
					onclick="if(!(confirm('Vas a Eliminar un registro. ¿Estas seguro?'))) return false" /></a> </td>
				</tr>
			</c:forEach>
		
		<tfoot> Fuente: BBDD local </tfoot>
	</table>

	<br>
	
	<input type="button" value = "Agregar Cliente" onclick="window.location.href='muestraFormularioAgregar'; return false;"/>

</body>
</html>