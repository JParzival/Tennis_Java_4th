package com.jparzival.practica_cliente.models;

import com.jparzival.practica_cliente.exceptions.ClienteException;
import com.jparzival.practica_cliente.exceptions.TenistaNoEncontradoException;
import com.jparzival.practica_cliente.models.pojos.Tenista;
import java.util.List;

/**
 *
 * @author jorge
 */
public interface Dao
{
     public List<Tenista> selectTenistas();
     public Tenista selectTenista(String licencia) throws TenistaNoEncontradoException;
     public Tenista insertTenista(String licencia, String nombreApellidos, int edad, double altura, double peso, String paisOrigen) throws ClienteException;
     public void deleteTenista(String licencia) throws ClienteException;
     public Tenista updateEdadTenista(String licencia, int edad) throws ClienteException;
}
