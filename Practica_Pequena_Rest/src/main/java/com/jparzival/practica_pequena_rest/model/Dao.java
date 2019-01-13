package com.jparzival.practica_pequena_rest.model;

import com.jparzival.practica_pequena_rest.exceptions.NoIntroducidoException;
import com.jparzival.practica_pequena_rest.exceptions.ProblemaEnDeleteException;
import com.jparzival.practica_pequena_rest.exceptions.ProblemaEnUpdateException;
import com.jparzival.practica_pequena_rest.model.beans.Tenista;
import java.util.List;

/**
 *
 * @author jorge
 */
public interface Dao
{
    public List<Tenista> selectTenistas();
    public Tenista selectTenista(String licencia);
    public Tenista insertTenista(String licencia, String nombreApellidos, int edad, Double altura, Double peso, String paisOrigen) throws NoIntroducidoException;
    public void deleteTenista(String licencia) throws ProblemaEnDeleteException;
    public void updateEdadTenista(String licencia, int edad) throws ProblemaEnUpdateException;
}
