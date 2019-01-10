/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jparzival.practica_cliente.exceptions;

/**
 *
 * @author jorge
 */
public class ClienteException extends Exception
{

    public ClienteException()
    {
    }

    public ClienteException(String message)
    {
        super(message);
    }

    public ClienteException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public ClienteException(Throwable cause)
    {
        super(cause);
    }

    public ClienteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
