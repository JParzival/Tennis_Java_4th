package com.jparzival.practica_pequena_rest.model.implementation;

import com.jparzival.practica_pequena_rest.cdi.qualifiers.WTA;
import com.jparzival.practica_pequena_rest.exceptions.NoIntroducidoException;
import com.jparzival.practica_pequena_rest.exceptions.ProblemaEnDeleteException;
import com.jparzival.practica_pequena_rest.exceptions.ProblemaEnUpdateException;
import com.jparzival.practica_pequena_rest.exceptions.TenistaNotFoundException;
import com.jparzival.practica_pequena_rest.exceptions.TenistasNotFoundException;
import com.jparzival.practica_pequena_rest.model.Dao_WTA;
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

@WTA
@Resource(name = "jdbc/db", type = DataSource.class, lookup = "jdbc/datasourcePractica") //Aquí definimos nuestros recursos, por si tenemos más de una BD
@Stateless
@Local(Dao_WTA.class)
public class OracleDaoWTA implements Dao_WTA
{
    
    @Resource(name="jdbc/db")
    private DataSource datasource;  //Introduzco el datasource, para poder hacer las llamadas a la base de datos.

    @Override
    public List<Tenista> selectTenistasWTA()
    {
        final String query = "SELECT * FROM TENISTAS_WTA ORDER BY LICENCIA ASC";
        
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
    public Tenista selectTenistaWTA(String licencia)           // en caso de querer seleccionar solo 1 tenista...
    {
        final String sqlQuery = "SELECT * FROM TENISTAS_WTA WHERE LICENCIA = ?";
        
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
    public Tenista insertTenistaWTA(String licencia, String nombreApellidos, int edad, Double altura, Double peso, String paisOrigen) throws NoIntroducidoException //en caso de querer insertar un tenista...
    {
        final String SQL = "INSERT INTO TENISTAS_WTA (LICENCIA, NOMBREAPELLIDOS, EDAD, ALTURA, PESO, PAISORIGEN)"
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
            throw new NoIntroducidoException("La tenista no ha podido ser introducida");
        }
    }
    
    @Override
    public void deleteTenistaWTA(String licencia) throws ProblemaEnDeleteException
    {
        final String SQL_DELETE = "DELETE FROM TENISTAS_WTA WHERE LICENCIA = ?";
        
        try(Connection connection = datasource.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_DELETE))
        {
            ps.setString(1, licencia);
            
            ps.executeUpdate();
        } 
        catch (SQLException ex)
        {
           throw new ProblemaEnDeleteException("La tenista ha tenido un problema en el delete");
        }
    }
    
    @Override
    public void updateEdadTenistaWTA(String licencia, int edad) throws ProblemaEnUpdateException
    {
        final String SQL = "UPDATE TENISTAS_WTA SET EDAD = ? WHERE LICENCIA = ?";
        
        try(Connection connection = datasource.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL))
        {
            ps.setInt(1, edad);
            ps.setString(2, licencia);
            
            ps.executeUpdate();
        } 
        catch (SQLException ex)
        {
            throw new ProblemaEnUpdateException("Ha habido un problema haciendo update");
        }
    }
    
}
