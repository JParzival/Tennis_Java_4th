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
public class ProblemaEnUpdateException extends PP_Exception
{

    public ProblemaEnUpdateException()
    {
    }

    public ProblemaEnUpdateException(String message)
    {
        super(message);
    }

    public ProblemaEnUpdateException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public ProblemaEnUpdateException(Throwable cause)
    {
        super(cause);
    }

    public ProblemaEnUpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
