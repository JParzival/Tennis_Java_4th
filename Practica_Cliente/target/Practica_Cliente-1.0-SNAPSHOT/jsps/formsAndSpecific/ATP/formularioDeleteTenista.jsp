<%-- 
    Document   : formularioDeleteTenista
    Author     : jorge
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Delete Tenista</title>
    </head>
    <body>
        <h1>Inserte Licencia del Tenista a Borrar</h1>
        <c:url var="urlDeleteTenista" value="/api/tenistas/ATP/delete"/>
        
        <form action="${urlDeleteTenista}" method="POST" enctype="application/x-www-form-urlencoded">
            
            <b>Licencia:</b> <input type="text"  name="licencia" value=""/>
            <br/>
            <br/>
            <input  type="submit" name="action" value="Eliminar"/>     
            
        </form>
    </body>
</html>
