<%-- 
    Document   : tenista
    Author     : jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tenista</title>
    </head>
    <body>
        <h1>Datos Tenista</h1>
        
        <table>
            <tbody>
                <tr>
                    <th>Licencia:</th>
                    <td>${tenista.licencia}</td>
                </tr>
                <tr>
                    <th>Nombre:</th>
                    <td>${tenista.nombreApellidos}</td>
                </tr>
                <tr>
                    <th>Edad:</th>
                    <td>${tenista.edad}</td>
                </tr>
                <tr>
                    <th>Peso:</th>
                    <td>${tenista.peso}</td>
                </tr>
                <tr>
                    <th>Altura:</th>
                    <td>${tenista.altura}</td>
                </tr>
                <tr>
                    <th>País de Origen:</th>
                    <td>${tenista.paisOrigen}</td>
                </tr>
            </tbody>
        </table>
                
                <br>
                
                <a href="http://localhost:8090/Practica_Cliente/api/tenistas/ATP/all">Ver Todos los Tenistas de la ATP</a>
                
                
                <br>
                
                <a href="http://localhost:8090/Practica_Cliente/api/tenistas/WTA/all">Ver Todos los Tenistas de la WTA</a>
                
    </body>
</html>
