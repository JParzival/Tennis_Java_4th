package com.jparzival.practica_pequena_rest.rest.json.Collection;

/**
 *
 * @author jorge
 */
public class Data
{
    private String name;
    private String value;

    public static Data newInstance(String name, String value)
    {
        return new Data(name, value);
    }

    private Data(String name, String value) 
    {
        this.name = name;
        this.value = value;
    }

    public String getName() 
    {
        return name;
    }

    public String getValue() 
    {
        return value;
    }
}
