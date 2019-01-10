package com.jparzival.practica_pequena_rest.exceptions;

/**
 *
 * @author jorge
 */
public class PP_Exception extends Exception
{

    public PP_Exception()
    {
    }

    public PP_Exception(String message)
    {
        super(message);
    }

    public PP_Exception(String message, Throwable cause)
    {
        super(message, cause);
    }

    public PP_Exception(Throwable cause)
    {
        super(cause);
    }

    public PP_Exception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
