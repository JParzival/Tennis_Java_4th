package com.jparzival.practica_pequena_rest.ejb.jms;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author jorge
 */
@MessageDriven(activationConfig = {@ActivationConfigProperty(propertyName = "destinationLookup",       propertyValue = "jms/practicaQueue"),
                                   @ActivationConfigProperty(propertyName = "destinationType",         propertyValue = "javax.jms.Queue"),
                                   @ActivationConfigProperty(propertyName = "connectionFactoryLookup", propertyValue = "jms/practicaConnectionFactory")
                                  })

public class MessageBean implements MessageListener
{
    
    @Override
    public void onMessage(Message message) 
    {
        try 
        {
            String messageBody = message.getBody( String.class );
            
            Logger.getGlobal().log(Level.INFO, messageBody);
              
        } 
        catch (JMSException jmsException) 
        {
            Logger.getLogger(MessageBean.class.getName()).log(Level.SEVERE, null, jmsException);
        }
        
    }
    
}

