package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.DeliveryMode;
import model.PizzaConfig;
import model.Size;

public class PizzeriaDao
{
    Connection con = DbConnection.getConnection();
      
    public void createTable()
    {
        try 
        {
            Statement stmt = con.createStatement();
            
            stmt.executeQuery("CREATE TABLE IF NOT EXISTS Pizzerias("
                    + " id SERIAL PRIMARY KEY,"
                    + "name VARCHAR NOT NULL,"
                    + "basePrice DOUBLE PRECISION NOT NULL,"
                    + "size VARCHAR NOT NULL,"
                    + "delivery_mode VARCHAR NOT NULL);");
           System.out.println("Pizzeria table created");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
      
    }
    
    
    public Boolean create(PizzaConfig config)
    {
        try 
        {
            PreparedStatement p =  con.prepareStatement("INSERT INTO Pizzerias values(?,?,?,?,?)");
            p.setInt(1, 5);
            p.setString(2, config.getName());
            p.setDouble(3, config.getBasePrice());
            p.setString(4, config.getSize().name());
            p.setString(5, config.getDeliveryMode().name());
            int rows = p.executeUpdate();
            System.out.println(rows+" records affected");  
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public List<PizzaConfig> findAll()
    {
        try
        {
            List<PizzaConfig> pizzerias= new ArrayList<>();
            Statement st= con.createStatement();
            
            ResultSet rs = st.executeQuery("SELECT * FROM pizzerias");
            
            while(rs.next())
            {
                PizzaConfig  config = new PizzaConfig();
                config.setName(rs.getString(2));
                config.setBasePrice(rs.getDouble(3));
                config.setSize(rs.getString(4));
                config.setDeliveryMode(rs.getString(5));
                pizzerias.add(config);
            }
            
            return pizzerias;
            
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public PizzaConfig findOne(String name)
    {
        try
        {
         PizzaConfig config = new PizzaConfig();
         String sql = "SELECT * FROM pizzeria where name=?";   
         PreparedStatement pst = con.prepareStatement(sql);
         pst.setString(1, name);
         ResultSet rs = pst.executeQuery();
         while(rs.next())
         {
             config.setName(rs.getString(2));
             config.setBasePrice(rs.getDouble(3));
             config.setSize(rs.getString(3));
             config.setDeliveryMode(rs.getString(4));
             
         }
         return config;
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    
    public boolean delete(String name)
    {
        try
        {
         String sql = "DELETE FROM pizzeria where name=?";   
         PreparedStatement pst = con.prepareStatement(sql);
         pst.setString(1, name);
         int rows = pst.executeUpdate();
        
         if(rows > 1)
         {
             return true;
         }
         return false;
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean update(String name,double basePrice)
    {
        try
        {
         String sql = "UPDATE TABLE pizzeria SET baseprice=? where name=?";   
         PreparedStatement pst = con.prepareStatement(sql);
         pst.setDouble(1, basePrice);
         pst.setString(2, name);
         int rows = pst.executeUpdate();
        
         if(rows > 1)
         {
             return true;
         }
         return false;
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
