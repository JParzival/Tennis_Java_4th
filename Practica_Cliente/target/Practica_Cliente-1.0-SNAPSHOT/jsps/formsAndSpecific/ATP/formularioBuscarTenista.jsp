<%-- 
    Document   : formularioBuscarTenista
    Author     : jorge
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Buscar Tenista</title>
    </head>
    <body>
        <h1>Inserte Datos Tenista Buscar</h1>
        <c:url var="urlSearchTenista" value="/api/tenistas/ATP/search"/>
        
        <form action="${urlSearchTenista}" method="POST" enctype="application/x-www-form-urlencoded">
            
            <b>Licencia del Tenista:</b> <input type="text"  name="licencia" value=""/>
            <br/>
     
            <input  type="submit" name="action" value="Buscar"/>     
            
        </form>
    </body>
</html>