package com.jparzival.practica_cliente.jax_rs.resources;

import javax.mvc.Controller;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author jorge
 */
@Path("forms")
public class FormulariosResource
{
    
    //ATP
    
    @GET
    @Path("ATP/insert")
    @Controller
    @View("/jsps/formsAndSpecific/ATP/formularioInsertTenista.jsp")
    public void introducirTenista()
    {  
    }
    
    @GET
    @Path("ATP/delete")
    @Controller
    @View("/jsps/formsAndSpecific/ATP/formularioDeleteTenista.jsp")
    public void getFormularioDeleteTenista()
    {       
    }
    
    @GET
    @Path("ATP/update")
    @Controller
    @View("/jsps/formsAndSpecific/ATP/formularioUpdateEdadTenista.jsp")
    public void getFormularioUpdateEdadTenista()
    {
    }
    
    @GET
    @Path("ATP/search")
    @Controller
    @View("/jsps/formsAndSpecific/ATP/formularioBuscarTenista.jsp")
    public void getFormularioBuscarTenista()
    {
    }
    
    
    //WTA
    
    @GET
    @Path("WTA/insert")
    @Controller
    @View("/jsps/formsAndSpecific/WTA/formularioInsertTenista.jsp")
    public void introducirTenistaWTA()
    {  
    }
    
    @GET
    @Path("WTA/delete")
    @Controller
    @View("/jsps/formsAndSpecific/WTA/formularioDeleteTenista.jsp")
    public void getFormularioDeleteTenistaWTA()
    {       
    }
    
    @GET
    @Path("WTA/update")
    @Controller
    @View("/jsps/formsAndSpecific/WTA/formularioUpdateEdadTenista.jsp")
    public void getFormularioUpdateEdadTenistaWTA()
    {
    }
    
    @GET
    @Path("JMS")
    @Controller
    @View("/jsps/formsAndSpecific/JMS/formularioSendMessageServer.jsp")
    public void getFormularioSendMessageServer()
    {
    }
    @GET
    @Path("WTA/search")
    @Controller
    @View("/jsps/formsAndSpecific/WTA/formularioBuscarTenista.jsp")
    public void getFormularioBuscarTenistaWTA()
    {
    }
    
}
