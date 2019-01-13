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
public interface Dao_WTA
{
    public List<Tenista> selectTenistasWTA();
    public Tenista selectTenistaWTA(String licencia);
    public Tenista insertTenistaWTA(String licencia, String nombreApellidos, int edad, Double altura, Double peso, String paisOrigen) throws NoIntroducidoException;
    public void deleteTenistaWTA(String licencia) throws ProblemaEnDeleteException;;
    public void updateEdadTenistaWTA(String licencia, int edad) throws ProblemaEnUpdateException;
}
