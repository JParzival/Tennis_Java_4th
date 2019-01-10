package com.jparzival.practica_cliente.models.implementation;

import com.jparzival.practica_cliente.cdi.qualifiers.ATP;
import com.jparzival.practica_cliente.exceptions.ClienteException;
import com.jparzival.practica_cliente.exceptions.TenistaNoEncontradoException;
import com.jparzival.practica_cliente.models.Dao;
import com.jparzival.practica_cliente.models.pojos.Tenista;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author jorge
 */

@ATP
public class ClienteOracleDao implements Dao
{
    private static final String URL_TENISTAS_ENDPOINT = "http://localhost:8090/Practica_Pequena_Rest/api/tenistas/ATP/all";
    private static final String URL_INSERT_TENISTA_ENDPOINT  = "http://localhost:8090/Practica_Pequena_Rest/api/tenistas/ATP/insert";
    private static final String URL_TENISTA_ENDPOINT = "http://localhost:8090/Practica_Pequena_Rest/api/tenistas/ATP/";
    private static final String URL_DELETE_TENISTA_ENDPOINT = "http://localhost:8090/Practica_Pequena_Rest/api/tenistas/ATP/delete";
    private static final String URL_UPDATE_TENISTA_ENDPOINT = "http://localhost:8090/Practica_Pequena_Rest/api/tenistas/ATP/update";
    
    private Client cliente = ClientBuilder.newClient();
    
    @Override
    public List<Tenista> selectTenistas()
    {
        WebTarget webTarget = cliente.target(URL_TENISTAS_ENDPOINT);        
        Invocation.Builder requestInvocation = webTarget.request();
        Response response = requestInvocation.accept( MediaType.APPLICATION_JSON ).get();

        List<Tenista> listTenistas = response.readEntity( new GenericType < List<Tenista> > () {} );
        return listTenistas;
    }
    
    @Override
    public Tenista selectTenista(String licencia) throws TenistaNoEncontradoException
    {
        StringBuilder sb = new StringBuilder();
        sb.append(URL_TENISTA_ENDPOINT);
        sb.append(licencia);
        String FINAL_URL_TENISTA_ENDPOINT = sb.toString();
        
        WebTarget webTarget = cliente.target(FINAL_URL_TENISTA_ENDPOINT);        
        Invocation.Builder requestInvocation = webTarget.request();
        Response response = requestInvocation.accept( MediaType.APPLICATION_JSON ).get();

        Tenista tenista = response.readEntity( new GenericType<Tenista> () {} );
    
        return tenista;
    }
    
    private Tenista consultaTenista(URI tenistaUri) 
    {
        return cliente.target( tenistaUri )
                     .request()
                     .get()
                     .readEntity( Tenista.class );
    }

    @Override
    public Tenista insertTenista(String licencia, String nombreApellidos, int edad, double altura, double peso, String paisOrigen) throws ClienteException
    {
        Form form = new Form();
        form.param("licencia", licencia);
        form.param("nombre", nombreApellidos);
        form.param("edad", String.valueOf(edad));
        form.param("altura", String.valueOf(altura));
        form.param("peso", String.valueOf(peso));
        form.param("pais", paisOrigen);
        
        Response response = cliente.target(URL_INSERT_TENISTA_ENDPOINT).request().post( Entity.form( form ) );

        switch ( response.getStatus() )
        {
            case 201: 
                        StringBuilder sb = new StringBuilder();
                        sb.append(URL_TENISTA_ENDPOINT);
                        sb.append(licencia);
                        
                        URI tenistaUri;
                        try
                        {
                            tenistaUri = new URI(sb.toString());
                        } 
                        catch (URISyntaxException ex)
                        {
                            Logger.getLogger(ClienteOracleDao.class.getName()).log(Level.SEVERE, null, ex);
                            tenistaUri = response.getLocation();
                        }
                        return consultaTenista(tenistaUri);
                     
            default: throw new ClienteException("Problemas en el Insert, código recibido distinto del 201");
            
        }
    }
    
    @Override
    public void deleteTenista(String licencia) throws ClienteException
    {
        Form form = new Form();
        form.param("licencia", licencia);
        
        Response response = cliente.target(URL_DELETE_TENISTA_ENDPOINT).request().post( Entity.form( form ) );

        switch ( response.getStatus() )
        {
            case 200:   
                        break;
                     
            default: throw new ClienteException("Problemas en el delete, código recibido distinto del 200 OK");
            
        }
    }

    @Override
    public Tenista updateEdadTenista(String licencia, int edad) throws ClienteException
    {
        Form form = new Form();
        form.param("licencia", licencia);
        form.param("edad", String.valueOf(edad));
        
        Response response = cliente.target(URL_UPDATE_TENISTA_ENDPOINT).request().post( Entity.form( form ) );

        switch ( response.getStatus() )
        {
            case 200:   
                        StringBuilder sb = new StringBuilder();
                        sb.append(URL_TENISTA_ENDPOINT);
                        sb.append(licencia);
                        
                        URI tenistaUri;
                        try
                        {
                            tenistaUri = new URI(sb.toString());
                        } 
                        catch (URISyntaxException ex)
                        {
                            Logger.getLogger(ClienteOracleDao.class.getName()).log(Level.SEVERE, null, ex);
                            tenistaUri = response.getLocation();
                        }
                        return consultaTenista(tenistaUri);
                     
            default: throw new ClienteException("Problemas en el update, código recibido distinto de 200 OK");
            
        }
    }
}
