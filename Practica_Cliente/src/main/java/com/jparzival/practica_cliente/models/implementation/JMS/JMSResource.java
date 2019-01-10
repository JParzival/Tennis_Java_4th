package com.jparzival.practica_cliente.models.implementation.JMS;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.View;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jorge
 */

@Path("JMS")
@RequestScoped
public class JMSResource
{
    @Inject
    private Event<String> event;
    
    @GET
    @Controller
    @View("/jsps/formsAndSpecific/JMS/formularioSendMessageServer.jsp")
    public void getFormularioAfterSent()
    {
    }

    @POST
    @Controller
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String enviarMensaje(@FormParam("mensaje") String mensaje)
    {
        event.fire(mensaje);
        return "redirect:/JMS";
        
    }
}

