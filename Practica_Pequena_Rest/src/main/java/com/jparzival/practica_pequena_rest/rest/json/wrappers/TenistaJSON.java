package com.jparzival.practica_pequena_rest.rest.json.wrappers;

import com.jparzival.practica_pequena_rest.model.beans.Tenista;
import com.jparzival.practica_pequena_rest.rest.json.binding.LinkJsonAdapter;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTypeAdapter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author jorge
 */
public class TenistaJSON
{
    private Tenista tenista;
    private UriInfo  uriInfo;
    

    private TenistaJSON(Tenista tenista, UriInfo uriInfo) {
        this.tenista = tenista;
        this.uriInfo = uriInfo;
    }
       

        
    @JsonbProperty("licencia")
    private String getLicencia()
    {
        return tenista.getLicencia();
    }
    
    @JsonbProperty("nombreApellidos")
    private String getNombreApellidos()
    {
        return tenista.getNombreApellidos();
    }
    
    @JsonbProperty("edad")
    private int getEdad()
    {
        return tenista.getEdad();
    }
    
    @JsonbProperty("altura")
    private double getAltura()
    {
        return tenista.getAltura();
    }
    
    @JsonbProperty("peso")
    private double getPeso()
    {
        return tenista.getPeso();
    }
    
    @JsonbProperty("paisOrigen")
    private String getPaisOrigen()
    {
        return tenista.getPaisOrigen();
    }
    
    @JsonbProperty("link")
    @JsonbTypeAdapter(LinkJsonAdapter.class)
    public Link getLink()
    {
        UriBuilder baseUriBuilder = uriInfo.getBaseUriBuilder();
        baseUriBuilder.path("tenistas")
                      .path( tenista.getLicencia());
        
        
        Link.Builder linkBuilder = Link.fromUriBuilder(baseUriBuilder);
        Link link = linkBuilder.rel( "item" )
                               .type( MediaType.APPLICATION_JSON )
                               .build();
        
        
        return link;
    }
    
    public static class Builder
    {
        @Context
        private UriInfo uriInfo;
        
        public TenistaJSON build(Tenista tenista)
        {
            return new TenistaJSON(tenista, uriInfo);
        }
        
    }
}
