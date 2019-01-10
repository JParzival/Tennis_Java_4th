package com.jparzival.practica_pequena_rest.rest.json.wrappers;

import com.jparzival.practica_pequena_rest.model.beans.Tenista;
import com.jparzival.practica_pequena_rest.rest.json.Collection.Data;
import com.jparzival.practica_pequena_rest.rest.json.Collection.Item;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.core.UriBuilder;

/**
 *
 * @author jorge
 */
public class TenistaCJ implements Item
{
    private Tenista tenista;
    private UriBuilder uriBuilder;

    @Override
    public URI getHref() 
    {
        return uriBuilder.build( tenista.getLicencia());
    }

    private TenistaCJ(Tenista tenista, UriBuilder uriBuilder)
    {
        this.tenista = tenista;
        this.uriBuilder = uriBuilder;
    }
    
    

    @Override
    public List<Data> getData() 
    {
        return Arrays.asList( Data.newInstance("ref",    tenista.getLicencia()),
                              Data.newInstance("nombre", tenista.getNombreApellidos()),
                              Data.newInstance("altura", BigDecimal.valueOf( tenista.getAltura()).setScale(2, RoundingMode.HALF_UP).toString()  ),
                              Data.newInstance("peso",  BigDecimal.valueOf( tenista.getPeso()).setScale(2, RoundingMode.HALF_UP).toString()   ),
                              Data.newInstance("paisOrigen", tenista.getPaisOrigen())
                            );
    }
 
    public static Builder newBuilder(UriBuilder uriBuilder)
    {
        return new Builder(uriBuilder);
    }

    public static class Builder
    {
        private UriBuilder uriBuilder;
        

        private Builder(UriBuilder uriBuilder) {
            this.uriBuilder = uriBuilder;
        }
        
        public TenistaCJ build(Tenista tenista)
        {
            return new TenistaCJ(tenista, uriBuilder);
        }
    }
}
