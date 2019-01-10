package com.jparzival.practica_pequena_rest.rest;

import com.jparzival.practica_pequena_rest.ejb.Logic;
import com.jparzival.practica_pequena_rest.model.Dao;
import com.jparzival.practica_pequena_rest.model.Dao_WTA;
import java.util.Set;
import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.ejb.EJB;
import javax.ejb.EJBs;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.ws.rs.core.Application;


/**
 *
 * @author jorge
 */

@EJBs(
        {
            @EJB(name = "ejb/logic",        beanInterface = Logic.class,    lookup = "java:module/LogicBean!com.jparzival.practica_pequena_rest.ejb.Logic"),
            @EJB(name = "ejb/logicBean",    beanInterface = Dao.class,      lookup = "java:module/OracleDao!com.jparzival.practica_pequena_rest.model.Dao"),
            @EJB(name = "ejb/logicBeanWTA", beanInterface = Dao_WTA.class,  lookup = "java:module/OracleDaoWTA!com.jparzival.practica_pequena_rest.model.Dao_WTA")
        }
     )

@Resources  ( 
                {
                    @Resource(name="jms/cf",    type=ConnectionFactory.class, lookup="jms/practicaConnectionFactory"),
                    @Resource(name="jms/queue", type=Queue.class,             lookup="jms/practicaQueue"),
                    @Resource(name="jms/topic", type=Topic.class,             lookup="jms/practicaTopic")
                }
            )


@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application
{

    @Override
    public Set<Class<?>> getClasses()
    {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    
    private void addRestResourceClasses(Set<Class<?>> resources)
    {
        resources.add(com.jparzival.practica_pequena_rest.rest.resources.JMS.JMSResource.class);
        resources.add(com.jparzival.practica_pequena_rest.rest.resources.TenistasResource.class);
        resources.add(com.jparzival.practica_pequena_rest.rest.resources.TenistasWTAResource.class);
        resources.add(org.mvcspec.ozark.bootstrap.OzarkCoreFeature.class);
    }
    
}
