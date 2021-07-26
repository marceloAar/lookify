<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Nueva Cancion</title>
</head>
<body>

<a href="/dashboard" style="text-align: right; display: block"> Dashboard </a>

<h1>Ingresar Nueva Cancion</h1><hr>

 
<form:form action="/songs/new" method="POST" modelAttribute="cancion">
    
    <p>
        <form:label path="titulo">Titulo :</form:label>
        <form:errors path="titulo"/>
        <form:input type="text" path="titulo"/>
    </p>
    
    <p>
        <form:label path="artista">Artista :</form:label>
        <form:errors path="artista"/>
        <form:input type="text" path="artista"/>
    </p>    
    <p>Clasificacion :    
        <select name="clasificacion">
			<option selected>1</option>
			<option>2</option>
			<option>3</option>
			<option>4</option>
			<option>5</option>
			<option>6</option>
			<option>7</option>
			<option>8</option>
			<option>9</option>
			<option>10</option>
		</select>          
    </p><hr>
     
    <input type="submit" value="Crear Nuevo"/>      
    
</form:form> 

</body>
</html>