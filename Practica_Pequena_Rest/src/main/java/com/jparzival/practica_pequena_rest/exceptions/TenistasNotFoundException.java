package com.jparzival.practica_pequena_rest.exceptions;

/**
 *
 * @author jorge
 */
public class TenistasNotFoundException extends PP_Exception
{

    public TenistasNotFoundException()
    {
    }

    public TenistasNotFoundException(String message)
    {
        super(message);
    }

    public TenistasNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public TenistasNotFoundException(Throwable cause)
    {
        super(cause);
    }

    public TenistasNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
