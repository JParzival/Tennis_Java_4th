/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jparzival.practica_pequena_rest.ejb.jms;

/**
 *
 * @author jorge
 */
public interface ObservadorDeEventos
{
    void observerEvent(String message);
}
