/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jparzival.practica_pequena_rest.exceptions;

/**
 *
 * @author jorge
 */
public class ProblemaEnDeleteException extends PP_Exception
{

    public ProblemaEnDeleteException()
    {
    }

    public ProblemaEnDeleteException(String message)
    {
        super(message);
    }

    public ProblemaEnDeleteException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public ProblemaEnDeleteException(Throwable cause)
    {
        super(cause);
    }

    public ProblemaEnDeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    
}
