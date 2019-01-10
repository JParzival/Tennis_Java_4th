package com.jparzival.practica_pequena_rest.cdi.producer;

import com.jparzival.practica_pequena_rest.ejb.Logic;
import com.jparzival.practica_pequena_rest.model.Dao;
import com.jparzival.practica_pequena_rest.model.Dao_WTA;
import javax.ejb.EJB;
import javax.enterprise.inject.Produces;
import com.jparzival.practica_pequena_rest.cdi.qualifiers.CDIProduced;

/**
 *
 * @author jorge
 */

public class EJBProducer
{
    
    
    @EJB(name="ejb/logicBean")
    @Produces
    @CDIProduced
    private Dao dao;
    
    @EJB(name="ejb/logicBeanWTA")
    @Produces
    @CDIProduced
    private Dao_WTA daoWTA;
    
    @EJB(name="ejb/logic")
    @Produces
    @CDIProduced
    private Logic logic;
    
}
