package com.jparzival.practica_pequena_rest.rest.json.Collection;

import java.net.URI;
import java.util.List;

/**
 *
 * @author jorge
 */
public interface Item
{
    public URI getHref();
    public List<Data> getData();      
}
