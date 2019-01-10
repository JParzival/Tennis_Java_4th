package com.jparzival.practica_pequena_rest.model.implementation;

import com.jparzival.practica_pequena_rest.cdi.qualifiers.ATP;
import com.jparzival.practica_pequena_rest.exceptions.TenistaNotFoundException;
import com.jparzival.practica_pequena_rest.exceptions.TenistasNotFoundException;
import com.jparzival.practica_pequena_rest.model.Dao;
import com.jparzival.practica_pequena_rest.model.beans.Tenista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author jorge
 */

@ATP
@Resource(name = "jdbc/db", type = DataSource.class, lookup = "jdbc/datasourcePractica") //Aquí definimos nuestros recursos, por si tenemos más de una BD
@Stateless
@Local(Dao.class)
public class OracleDao implements Dao
{
    
    @Resource(name="jdbc/db")
    private DataSource datasource;  //Introduzco el datasource, para poder hacer las llamadas a la base de datos.

    @Override
    public List<Tenista> selectTenistas()
    {
        final String query = "SELECT * FROM TENISTAS_ATP ORDER BY LICENCIA ASC";
        
        try(Connection connection = datasource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query))
        {
            List<Tenista> tenistas = new LinkedList<>();
            
            if(resultSet.next())
            {
                do
                {
                    Tenista tenista = new Tenista();
                    tenista.setLicencia(resultSet.getString(1));
                    tenista.setNombreApellidos(resultSet.getString(2));
                    tenista.setEdad(resultSet.getInt(3));
                    tenista.setAltura(resultSet.getDouble(4));
                    tenista.setPeso(resultSet.getDouble(5));
                    tenista.setPaisOrigen(resultSet.getString(6));
                    
                    tenistas.add(tenista);
                    
                }while(resultSet.next());
            }
            return tenistas;
        } 
        catch (SQLException ex)
        {
            String message = ex.getMessage();
            try
            {
                throw new TenistasNotFoundException(message);
            } 
            catch (TenistasNotFoundException ex1)
            {
                System.out.println("Fatal Error: " + ex1);
            }
        }
        return null;
    }

    @Override
    public Tenista selectTenista(String licencia)           // en caso de querer seleccionar solo 1 tenista...
    {
        final String sqlQuery = "SELECT * FROM TENISTAS_ATP WHERE LICENCIA = ?";
        
        try(Connection connection = datasource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sqlQuery))
        {
            ps.setString(1, licencia);
            
            try(ResultSet resultSet = ps.executeQuery())
            {
                if( resultSet.next() )
                {
                    Tenista tenista = new Tenista();
                    tenista.setLicencia(resultSet.getString(1));
                    tenista.setNombreApellidos(resultSet.getString(2));
                    tenista.setEdad(resultSet.getInt(3));
                    tenista.setAltura(resultSet.getDouble(4));
                    tenista.setPeso(resultSet.getDouble(5));
                    tenista.setPaisOrigen(resultSet.getString(6));
                    
                    return tenista;
                }
                else
                {
                    throw new TenistaNotFoundException();
                }
            } catch (TenistaNotFoundException ex)
            {
                Logger.getLogger(OracleDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        } 
        catch (SQLException ex)
        {
            System.out.println("Exception SQL");
            return null;
        }
        
    }
    
    @Override
    public Tenista insertTenista(String licencia, String nombreApellidos, int edad, Double altura, Double peso, String paisOrigen)  //en caso de querer insertar un tenista...
    {
        final String SQL = "INSERT INTO TENISTAS_ATP (LICENCIA, NOMBREAPELLIDOS, EDAD, ALTURA, PESO, PAISORIGEN)"
                +          " VALUES (?, ?, ?, ?, ?, ?)";
        
        try(Connection connection = datasource.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL))
        {
            ps.setString(1, licencia);
            ps.setString(2, nombreApellidos);
            ps.setInt(3, edad);
            ps.setDouble(4, altura);
            ps.setDouble(5, peso);
            ps.setString(6, paisOrigen);
            
            Tenista tenista = new Tenista(licencia, nombreApellidos, edad, altura, peso, paisOrigen);
            
            ps.executeUpdate();
            
            return tenista;
        } 
        catch (SQLException ex)
        {
            return null;
        }
    }

    @Override
    public void deleteTenista(String licencia)
    {
        final String SQL_DELETE = "DELETE FROM TENISTAS_ATP WHERE LICENCIA = ?";
        
        try(Connection connection = datasource.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_DELETE))
        {
            ps.setString(1, licencia);
            
            ps.executeUpdate();

        } 
        catch (SQLException ex)
        {
            
        }
    }

    @Override
    public void updateEdadTenista(String licencia, int edad)
    {
        final String SQL_Update = "UPDATE TENISTAS_ATP SET EDAD = ? WHERE LICENCIA = ?";
        
        try(Connection connection = datasource.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_Update))
        {
            ps.setInt(1, edad);
            ps.setString(2, licencia);
            
            ps.executeUpdate();
        } 
        catch (SQLException ex)
        {
            
        }
    }
    
}
