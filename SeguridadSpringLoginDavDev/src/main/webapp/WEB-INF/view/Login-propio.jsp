<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario</title>
<style type="text/css">
	.formatoError{
		color:red;
		font-size: 1.5em;
	}
</style>
</head>
<body>
	<h2 style="text-alig:center">Formulario de Acceso</h2>
	
	<form:form action="${pageContext.request.contextPath}/autenticacionUsuario" method="POST">
		<c:if test="${param.error!=null}">
			<strong class="formatoError">Usuario o contraseña incorrectos</strong>
		</c:if>
		
		<p> USUARIO <input type="text" name="username"/>  </p>
		<p> CONTRASEÑA <input type="password" name="password"/>  </p>
		<input type="submit" value="Login" />
	</form:form>

</body>
</html>