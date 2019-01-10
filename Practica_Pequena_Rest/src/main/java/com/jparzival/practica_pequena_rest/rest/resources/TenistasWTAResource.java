package com.jparzival.practica_pequena_rest.rest.resources;

import com.jparzival.practica_pequena_rest.cdi.qualifiers.ATP;
import com.jparzival.practica_pequena_rest.cdi.qualifiers.WTA;
import com.jparzival.practica_pequena_rest.ejb.Logic;
import com.jparzival.practica_pequena_rest.exceptions.PP_Exception;
import com.jparzival.practica_pequena_rest.model.Dao;
import com.jparzival.practica_pequena_rest.model.beans.Tenista;
import com.jparzival.practica_pequena_rest.rest.json.Collection.CollectionJson;
import com.jparzival.practica_pequena_rest.rest.json.wrappers.TenistaCJ;
import com.jparzival.practica_pequena_rest.rest.json.wrappers.TenistaJSON;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import com.jparzival.practica_pequena_rest.cdi.qualifiers.CDIProduced;

/**
 *
 * @author jorge
 */
@Path("tenistas/WTA")
public class TenistasWTAResource
{
    
    /*@Inject
    @WTA
    private Dao dao;*/  //-> Ahora no lo estamos usando, tenemos la lógica
    
    @Inject
    @CDIProduced
    private Logic logic;
    
    @Context
    private UriInfo uriInfo;
    
    @Inject
    private TenistaJSON.Builder builder;
    
    
    
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTenistasWTA()
    {
        List<Tenista> tenistas = logic.selectTenistasWTA();
        
        if(tenistas == null)
        {
            return Response.noContent().build();
        }
        
        return Response.ok().entity(tenistas).build();
    }
    
    @GET
    @Produces("application/vnd.collection+json")
    @Path("all/collection")
    public Response  getTenistasAsJsonWTA(@Context UriInfo uriInfo) throws PP_Exception
    {
        List<Tenista> tenistas = logic.selectTenistasWTA();        

        TenistaCJ.Builder tenistaCJBuilder = TenistaCJ.newBuilder( uriInfo.getBaseUriBuilder().path("tenistas").path("WTA").path("{licencia}") );

        List<TenistaCJ> tenistasCJ = new LinkedList<>();
        
        for(Tenista tenista: tenistas)
        {
            tenistasCJ.add( tenistaCJBuilder.build(tenista) );
        }        
        
        CollectionJson collectionJson = CollectionJson.newInstance(uriInfo.getRequestUriBuilder().build(), tenistasCJ);

        
        return Response.ok().entity(collectionJson).build();
    }

    
    @GET
    @Path("{licencia}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTenistaWTA(@PathParam("licencia") String licencia)
    {
        Tenista tenista = logic.selectTenistaWTA(licencia);
        
        if(tenista == null)
        {
            return Response.noContent().build();
        }
        
        return Response.ok().entity(tenista).build();
    }
    
    @GET
    @Path("{licencia}/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTenistaAsJsonWTA(@PathParam("licencia") String licencia) throws WebApplicationException
    {
        
        Tenista tenista = logic.selectTenistaWTA(licencia);
        
        return Response.ok()
                .entity( builder.build(tenista) )
                .build();
    }
    
    @POST
    @Path("insert")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response insertTenistaWTA(@FormParam("licencia") String licencia,
                                   @FormParam("nombre")  String nombre,
                                   @FormParam("edad") String edad,
                                   @FormParam("altura")  String altura,
                                   @FormParam("peso")    String peso,
                                   @FormParam("pais") String pais) throws PP_Exception
    {
        Tenista tenista = logic.insertTenistaWTA(licencia, nombre, Integer.parseInt(edad), Double.parseDouble(altura), Double.parseDouble(peso), pais);
        
        URI tenistaLocation = uriInfo.getBaseUriBuilder()
                                      .path( TenistasWTAResource.class )
                                      .path( TenistasWTAResource.class, "getTenistaAsJsonWTA" )
                                      .build( tenista.getLicencia() );
        
        
        
        return Response.created( tenistaLocation ).build();                
    }
    
    @POST
    @Path("delete")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response deleteTenistaWTA(@FormParam("licencia") String licencia)
    {
        logic.deleteTenistaWTA(licencia);
        
        URI tenistaLocation = uriInfo.getBaseUriBuilder()
                                      .path( TenistasWTAResource.class )
                                      .path( TenistasWTAResource.class, "getTenistaAsJsonWTA" )
                                      .build( licencia );
        
        
        return Response.ok( tenistaLocation ).build(); 
    }
    
    @POST
    @Path("update")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response updateEdadTenistaWTA(@FormParam("licencia") String licencia,
                                      @FormParam("edad") String edad)
    {
        logic.updateEdadTenistaWTA(licencia, Integer.parseInt(edad));
        
        URI tenistaLocation = uriInfo.getBaseUriBuilder()
                                      .path( TenistasWTAResource.class )
                                      .path( TenistasWTAResource.class, "getTenistaAsJsonWTA" )
                                      .build( licencia );
        
        
        return Response.ok( tenistaLocation ).build(); 
    }
    
}
