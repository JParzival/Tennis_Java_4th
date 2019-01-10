package com.jparzival.practica_pequena_rest.model.beans;

/**
 *
 * @author jorge
 */
public class Tenista
{
    private String licencia;
    private String nombreApellidos;
    private int edad;
    private double altura;
    private double peso;
    private String paisOrigen;

    public Tenista(String licencia, String nombreApellidos, int edad, double altura, double peso, String paisOrigen)
    {
        this.licencia = licencia;
        this.nombreApellidos = nombreApellidos;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
        this.paisOrigen = paisOrigen;
    }

    public Tenista()
    {
    }

    
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

    public int getEdad()
    {
        return edad;
    }

    public void setEdad(int edad)
    {
        this.edad = edad;
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
        return "Tenista{" + "licencia=" + licencia + ", nombreApellidos=" + nombreApellidos + ", edad=" + edad + ", altura=" + altura + ", peso=" + peso + ", paisOrigen=" + paisOrigen + '}';
    }
    
    
}
