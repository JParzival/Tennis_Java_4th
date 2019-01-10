<%-- 
    Document   : formularioEnvioMensajeJMS
    Author     : jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensaje JMS</title>
    </head>
    <body>
            <h1>Envíe su mensaje hacia el servidor</h1>

         <c:url var="urlEnviarMensaje" value="/api/JMS"/>
        
        <form action="${urlEnviarMensaje}" method="POST" enctype="application/x-www-form-urlencoded">
            
            <br>
            <b>Mensaje:</b> <input type="text" name="mensaje" value=""/>
            <br/>
            <br/>
            <input type="submit" name="action" value="Enviar"/>   
            
        </form>
        
        <br>
        
        <a href="http://localhost:8090/Practica_Cliente/">Volver al Menú Principal </a>
    </body>
</html>
