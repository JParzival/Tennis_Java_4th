package com.jparzival.practica_pequena_rest.ejb;

import com.jparzival.practica_pequena_rest.exceptions.NoIntroducidoException;
import com.jparzival.practica_pequena_rest.exceptions.ProblemaEnDeleteException;
import com.jparzival.practica_pequena_rest.exceptions.ProblemaEnUpdateException;
import com.jparzival.practica_pequena_rest.model.Dao;
import com.jparzival.practica_pequena_rest.model.Dao_WTA;
import com.jparzival.practica_pequena_rest.model.beans.Tenista;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jorge
 */

@Stateless
public class LogicBean implements Logic
{
    
    @EJB
    private Dao dao;
    
    @EJB
    private Dao_WTA daoWTA;
    
    @Override
    public List<Tenista> selectTenistas()
    {
        return dao.selectTenistas();
    }

    @Override
    public Tenista selectTenista(String licencia)
    {
        return dao.selectTenista(licencia);
    }

    @Override
    public Tenista insertTenista(String licencia, String nombreApellidos, int edad, Double altura, Double peso, String paisOrigen) throws NoIntroducidoException
    {
        return dao.insertTenista(licencia, nombreApellidos, edad, altura, peso, paisOrigen);
    }

    @Override
    public void deleteTenista(String licencia) throws ProblemaEnDeleteException
    {
        dao.deleteTenista(licencia);
    }

    @Override
    public void updateEdadTenista(String licencia, int edad) throws ProblemaEnUpdateException
    {
        dao.updateEdadTenista(licencia, edad);
    }
    
    
    
    
    
    

    @Override
    public List<Tenista> selectTenistasWTA()
    {
        return daoWTA.selectTenistasWTA();
    }

    @Override
    public Tenista selectTenistaWTA(String licencia)
    {
         return daoWTA.selectTenistaWTA(licencia);
    }

    @Override
    public Tenista insertTenistaWTA(String licencia, String nombreApellidos, int edad, Double altura, Double peso, String paisOrigen) throws NoIntroducidoException
    {
        return daoWTA.insertTenistaWTA(licencia, nombreApellidos, edad, altura, peso, paisOrigen);
    }

    @Override
    public void deleteTenistaWTA(String licencia) throws ProblemaEnDeleteException
    {
        daoWTA.deleteTenistaWTA(licencia);
    }

    @Override
    public void updateEdadTenistaWTA(String licencia, int edad) throws ProblemaEnUpdateException
    {
        daoWTA.updateEdadTenistaWTA(licencia, edad);
    }


    
    
}
