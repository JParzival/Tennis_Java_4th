package com.jparzival.practica_pequena_rest.rest.resources.JMS;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("send")
    public Response enviarMensaje(String mensaje)
    {
        event.fire(mensaje);
        return Response.accepted().build();        
    }
}
