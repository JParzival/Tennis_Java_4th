package com.jparzival.practica_pequena_rest.rest.json.binding;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.bind.adapter.JsonbAdapter;
import javax.ws.rs.core.Link;

/**
 *
 * @author jorge
 */
public class LinkJsonAdapter implements JsonbAdapter<Link, JsonObject>
{

    @Override
    public JsonObject adaptToJson(Link link) throws Exception 
    {
        return Json.createObjectBuilder()
                   .add("href", link.getUri().toString())
                   .add("rel",  link.getRel()           )
                   .add("type", link.getType()          )
                   .build();

    }

    @Override
    public Link adaptFromJson(JsonObject jsonObject) throws Exception 
    {
       return null;
    }
    
}
