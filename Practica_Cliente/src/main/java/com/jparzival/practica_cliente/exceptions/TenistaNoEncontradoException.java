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
public class TenistaNoEncontradoException extends ClienteException
{

    public TenistaNoEncontradoException()
    {
    }

    public TenistaNoEncontradoException(String message)
    {
        super(message);
    }

    public TenistaNoEncontradoException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public TenistaNoEncontradoException(Throwable cause)
    {
        super(cause);
    }

    public TenistaNoEncontradoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    
}
