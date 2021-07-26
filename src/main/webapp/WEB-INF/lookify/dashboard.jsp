<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Dashboard</title>
</head>
<body>

<a href="/songs/new">Agregar Nuevo</a>

<h1>Lista de Canciones</h1><hr>

<table border=1>
    <thead>
        <tr>
            <th>Nº</th>
            <th>Titulo</th>
            <th>Artista</th>
            <th>Clasificacion</th>
            <th>Accion</th>	         
        </tr>
        
    </thead>
    <tbody>
        <c:forEach items="${canciones}" var="cancion">
        <tr>
            <td><c:out value="${cancion.id}"/></td>
            <td><a href="/songs/${cancion.id}"><c:out value="${cancion.titulo}"/></a></td>
            <td><c:out value="${cancion.artista}"/></td>
            <td><c:out value="${cancion.clasificacion}"/></td>         
         	<td><a href="/songs/delete/${cancion.id}"> Eliminar </a></td>    
        </tr>
        </c:forEach>       
    </tbody>
</table>

</body>
</html>