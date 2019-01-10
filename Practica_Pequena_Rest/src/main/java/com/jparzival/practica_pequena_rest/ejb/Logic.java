package com.jparzival.practica_pequena_rest.ejb;

import com.jparzival.practica_pequena_rest.model.beans.Tenista;
import java.util.List;

/**
 *
 * @author jorge
 */
public interface Logic
{
    
    public List<Tenista> selectTenistas();
    public Tenista selectTenista(String licencia);
    public Tenista insertTenista(String licencia, String nombreApellidos, int edad, Double altura, Double peso, String paisOrigen);
    public void deleteTenista(String licencia);
    public void updateEdadTenista(String licencia, int edad);
    
   
    public List<Tenista> selectTenistasWTA();
    public Tenista selectTenistaWTA(String licencia);
    public Tenista insertTenistaWTA(String licencia, String nombreApellidos, int edad, Double altura, Double peso, String paisOrigen);
    public void deleteTenistaWTA(String licencia);
    public void updateEdadTenistaWTA(String licencia, int edad);
    
}
