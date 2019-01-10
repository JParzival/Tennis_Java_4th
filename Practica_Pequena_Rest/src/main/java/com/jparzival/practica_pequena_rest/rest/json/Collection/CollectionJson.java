package com.jparzival.practica_pequena_rest.rest.json.Collection;

import java.net.URI;
import java.util.List;

/**
 *
 * @author Jorge
 */

public class CollectionJson<T extends Item>
{
    private final Collection<T> collection;
    
    public static <I extends Item> CollectionJson newInstance(URI uri, List<I> items)
    {
        Collection<I> collection = new Collection <>(uri, items);
        return new CollectionJson(collection);
    }
    
    private CollectionJson(Collection<T> collection) 
    {
        this.collection = collection;
    }

    public Collection<? extends Item> getCollection()
    {
        return collection;
    }
}
