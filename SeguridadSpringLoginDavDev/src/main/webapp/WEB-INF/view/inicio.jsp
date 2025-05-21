<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
         <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2><%= "Bievenidos" %></h2>
<hr>
<h3><%= "El curso de Spring sigue, toca el tema de MAVEN!!!" %></h3>
	
	<p>
		Usuario: <sec:authentication property="principal.username"/> <br><br>
		Rol: <sec:authentication property="principal.authorities"/> <br><br>
	</p>
		<br><hr>	
		
		<sec:authorize access="hasRole('administrador')">
			<!-- Link para administradores -->
			<p> 
				<a href="${pageContext.request.contextPath}/administradores"> Ir a zona de administradores</a>
			</p>		
			<br><hr>
		</sec:authorize>	
		
		<sec:authorize access="hasRole('ayudante')">
			<!-- Link para ayudantes -->
			<p> 
				<a href="${pageContext.request.contextPath}/ayudantes"> Ir a zona de ayudantes</a>
			</p>
		</sec:authorize>

	 <form:form action="${pageContext.request.contextPath }/logout" method="POST">
	 	<input type="submit" value="Log Out">
 	</form:form>

</body>
</html>