package com.jparzival.practica_cliente.jax_rs.resources;

import com.jparzival.practica_cliente.cdi.qualifiers.ATP;
import com.jparzival.practica_cliente.exceptions.ClienteException;
import com.jparzival.practica_cliente.exceptions.TenistaNoEncontradoException;
import com.jparzival.practica_cliente.models.Dao;
import com.jparzival.practica_cliente.models.pojos.Tenista;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author jorge
 */

@Path("tenistas/ATP")
@RequestScoped
public class TenistasResource
{
    @Inject
    @ATP
    private Dao dao;
    
    @Inject 
    private Models models;
    
    @GET
    @Controller
    @Path("all")
    public String getTenistas()
    {
        List<Tenista> tenistas = dao.selectTenistas();
        models.put("tenistas", tenistas);
        
        return "/jsps/formsAndSpecific/ATP/tenistas.jsp";
    }
    
    @GET
    @Controller
    @Path("{licencia}")
    public String getTenista(@PathParam("licencia") String licencia) throws TenistaNoEncontradoException
    {
        Tenista tenista = dao.selectTenista(licencia);
        
        if(tenista == null)
        {
            throw new TenistaNoEncontradoException();
        }
        
        models.put("tenista", tenista);
        
        return "/jsps/tenista.jsp";
    }
    
    @POST
    @Controller
    @Path("insert")
    public String postTenista( @FormParam("licencia") String licencia, 
                               @FormParam("nombre") String nombre, 
                               @FormParam("altura") String altura, 
                               @FormParam("edad") String edad,
                               @FormParam("peso") String peso,
                               @FormParam("pais") String pais) throws ClienteException
    {
        Tenista tenista = dao.insertTenista(licencia, nombre, Integer.parseInt(edad), Double.parseDouble(altura), Double.parseDouble(peso), pais);
        
        models.put("tenista", tenista);
        return String.format("redirect:/tenistas/ATP/%s", tenista.getLicencia());
    }
    
    @POST
    @Controller
    @Path("delete")
    public String deleteTenista(@FormParam("licencia") String licencia) throws ClienteException
    {
        dao.deleteTenista(licencia);
        
        return getTenistas();
    }
    
    @POST
    @Controller
    @Path("update")
    public String updateTenista(@FormParam("licencia") String licencia, @FormParam("edad") String edad) throws ClienteException
    {
        Tenista tenista = dao.updateEdadTenista(licencia, Integer.parseInt(edad));
        
       return String.format("redirect:/tenistas/ATP/%s", tenista.getLicencia());
    }
    
    @POST
    @Controller
    @Path("search")
    public String buscarTenista(@FormParam("licencia") String licencia) throws ClienteException
    {
        Tenista tenista = dao.selectTenista(licencia);
        if(tenista == null)
        {
            throw new TenistaNoEncontradoException("Tenista con licencia " + licencia + " no encontrado");
        }
        return String.format("redirect:/tenistas/ATP/%s", tenista.getLicencia());
    }
}
