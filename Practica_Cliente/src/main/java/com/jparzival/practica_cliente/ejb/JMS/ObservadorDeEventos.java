package com.jparzival.practica_cliente.ejb.JMS;

/**
 *
 * @author jorge
 */
public interface ObservadorDeEventos
{
    void observerEvent(String message);
}
