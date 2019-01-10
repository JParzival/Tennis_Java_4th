<%-- 
    Document   : formularioUpdateEdadTenista
    Author     : jorge
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Actualizar Tenista</title>
    </head>
    <body>
        <h1>Inserte Datos Tenista Actualizar</h1>
        <c:url var="urlUpdateTenista" value="/api/tenistas/WTA/update"/>
        
        <form action="${urlUpdateTenista}" method="POST" enctype="application/x-www-form-urlencoded">
            
            <b>Licencia del Tenista:</b> <input type="text"  name="licencia" value=""/>
            <br/>
            <b>Nueva Edad:</b> <input type="number" name="edad" value=""/>
            <br/>
            <br/>
            <input  type="submit" name="action" value="Actualizar"/>     
            
        </form>
    </body>
</html>