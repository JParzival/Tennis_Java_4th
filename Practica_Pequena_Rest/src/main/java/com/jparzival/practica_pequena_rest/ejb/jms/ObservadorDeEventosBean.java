package com.jparzival.practica_pequena_rest.ejb.jms;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 *
 * @author jorge
 */

@Stateless
@Local(ObservadorDeEventos.class)
public class ObservadorDeEventosBean implements ObservadorDeEventos
{
    
    @Resource(name="jms/queue")
    private Queue queue;
    
    @Resource(name = "jms/cf")
    private ConnectionFactory cf;
    
    @Resource(name = "jms/topic")
    private Topic topic;

    @Override
    public void observerEvent(@Observes String message) 
    {
        try ( JMSContext jmsContext = cf.createContext() )
        {            
            jmsContext.createProducer().send(queue, message);
        }
    }
 
    
}
