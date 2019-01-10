package com.jparzival.practica_cliente.models.pojos;

import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jorge
 */

public class Tenista
{
    @JsonbProperty("licencia")
    @NotNull
    private String licencia;

    @JsonbProperty("nombreApellidos")
    @NotNull
    private String nombreApellidos;

    @JsonbProperty("altura")
    @Max(3)
    @Min(1)
    private double altura;

    @JsonbProperty("peso")
    @Max(999)
    private double peso;
    
    @JsonbProperty("edad")
    @Max(99)
    @Min(1)
    private int edad;
    
    @JsonbProperty("paisOrigen")
    private String paisOrigen;

    public String getLicencia()
    {
        return licencia;
    }

    public void setLicencia(String licencia)
    {
        this.licencia = licencia;
    }

    public String getNombreApellidos()
    {
        return nombreApellidos;
    }

    public void setNombreApellidos(String nombreApellidos)
    {
        this.nombreApellidos = nombreApellidos;
    }

    public double getAltura()
    {
        return altura;
    }

    public void setAltura(double altura)
    {
        this.altura = altura;
    }

    public double getPeso()
    {
        return peso;
    }

    public void setPeso(double peso)
    {
        this.peso = peso;
    }

    public int getEdad()
    {
        return edad;
    }

    public void setEdad(int edad)
    {
        this.edad = edad;
    }

    public String getPaisOrigen()
    {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen)
    {
        this.paisOrigen = paisOrigen;
    }

    @Override
    public String toString()
    {
        return "Tenista{" + "licencia=" + licencia + ", nombreApellidos=" + nombreApellidos + ", altura=" + altura + ", peso=" + peso + ", edad=" + edad + ", paisOrigen=" + paisOrigen + '}';
    }
    
    
}
