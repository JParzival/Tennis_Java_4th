<%-- 
    Document   : tenistas
    Author     : jorge
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de Todos los Tenistas</h1>
        <table>
            
            
            <tbody>
                <c:forEach var="tenista" items="${tenistas}">
                    
                    <tr>
                        <td><b>Nombre:</b><a href="http://localhost:8090/Practica_Cliente/api/tenistas/ATP/${tenista.licencia}"> ${tenista.nombreApellidos}</a></td>
                        <td><b>Edad:  </b>${tenista.edad}</td>
                        <td><b>Peso:  </b>${tenista.peso} kg</td>
                        <td><b>Altura:</b>${tenista.altura} m</td>
                        <td><b>País:  </b>${tenista.paisOrigen}</td>
                    </tr>
                
                </c:forEach>
            </tbody>
        </table>
        
        <br>
        <a href="http://localhost:8090/Practica_Cliente/">Volver a la main page</a>
    </body>
</html>
