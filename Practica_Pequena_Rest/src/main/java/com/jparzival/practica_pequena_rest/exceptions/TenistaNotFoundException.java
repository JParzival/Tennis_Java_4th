package com.jparzival.practica_pequena_rest.exceptions;

/**
 *
 * @author jorge
 */
public class TenistaNotFoundException extends PP_Exception
{

    public TenistaNotFoundException()
    {
    }

    public TenistaNotFoundException(String message)
    {
        super(message);
    }

    public TenistaNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public TenistaNotFoundException(Throwable cause)
    {
        super(cause);
    }

    public TenistaNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    
}
