<%-- 
    Document   : formularioInsertTenista
    Author     : jorge
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Insertar Tenista</title>
    </head>
    <body>
        <h1>Inserte Datos del Nuevo Tenista</h1>
        <c:url var="urlPostTenista" value="/api/tenistas/ATP/insert"/>
        
        <form action="${urlPostTenista}" method="POST" enctype="application/x-www-form-urlencoded">
            
            <b>Licencia:</b> <input type="text"  name="licencia" value=""/>
            <br/>
            <b>Nombre y Apellidos:</b> <input  type="text" name="nombre" value=""/>
            <br/>
            <b>Edad:</b> <input type="number" name="edad" value=""/>
            <br/>
            <b>Altura:</b> <input  type="number" step="0.01" name="altura" value=""/>
            <br/>
            <b>Peso:<b/> <input  type="number" step="0.01" name="peso" value=""/>
            <br/>
            <b>País de Origen:</b> <input  type="text" name="pais" value=""/>
            <br/>
            <input  type="submit" name="action" value="Insertar"/>     
            
        </form>
    </body>
</html>
