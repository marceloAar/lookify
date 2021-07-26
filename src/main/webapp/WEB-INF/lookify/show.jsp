<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Informacion de cancion</title>
</head>
<body>

<a href="/dashboard" style="text-align: right; display: block"> Dashboard </a>

	<h1>Titulo : <c:out value="${cancion.titulo}"/></h1>
	<h3>Artista : <c:out value="${cancion.artista}"/></h3>
	<h3>Clasificacion : <c:out value="${cancion.clasificacion}"/></h3><hr><br> 
	
	<a href="/songs/delete/${cancion.id}"> Eliminar </a>  
		

</body>
</html>