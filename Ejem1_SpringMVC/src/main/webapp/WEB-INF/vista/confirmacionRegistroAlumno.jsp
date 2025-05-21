<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmacion de Registro</title>
</head>
<body>

	<p>El Alumno  con nombre : <strong> ${Alumno.nombre} </strong> </p>
	<p> Y Apellido : <strong> ${Alumno.apellido} </strong> </p>
	<p>Con Edad : <strong> ${Alumno.edad} </strong> </p>
	<p> E-Mail : <strong> ${Alumno.email} </strong> </p>
	<p> Codigo Postal : <strong> ${Alumno.codigoPostal} </strong> </p>
	<p> La Asignatura selecionada es:  <strong> ${Alumno.optativa} </strong> </p>
	<br> <br>
	<p>La provincia donde inciaria los estudios es : <strong> ${Alumno.ciudadEstudios} </strong> </p>
		<br> <br>
	<p>Los idiomas escogidos por el alumno son:  : <strong> ${Alumno.idiomasAlumno} </strong> </p>	
		<br> <br>
	<h2> SE REGISTRO CON EXITO </h2>

</body>
</html>