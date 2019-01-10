package com.jparzival.practica_cliente.jax_rs.resources;

import java.util.Set;
import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.ws.rs.core.Application;

/**
 *
 * @author jorge
 */


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
        resources.add(com.jparzival.practica_cliente.jax_rs.resources.FormulariosResource.class);
        resources.add(com.jparzival.practica_cliente.jax_rs.resources.TenistasResource.class);
        resources.add(com.jparzival.practica_cliente.jax_rs.resources.TenistasWTAResource.class);
        resources.add(com.jparzival.practica_cliente.models.implementation.JMS.JMSResource.class);
        resources.add(org.mvcspec.ozark.bootstrap.OzarkCoreFeature.class);
        
    }
    
}
