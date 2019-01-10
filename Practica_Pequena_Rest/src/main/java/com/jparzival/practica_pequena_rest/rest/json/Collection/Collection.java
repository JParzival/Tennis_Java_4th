package com.jparzival.practica_pequena_rest.rest.json.Collection;

import java.net.URI;
import java.util.List;

/**
 *
 * @author Administrador
 */

public class Collection <T extends Item>
{
    private String version = "1.0";
    private URI href;
    private List<T> items ;

    protected Collection(URI href, List<T> items)
    {
        this.href = href;
        this.items = items;
    }

    public String getVersion()
    {
        return version;
    }

    public URI getHref() 
    {
        return href;
    }

    public List<T> getItems()
    {
        return items;
    }            
}
