package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection
{
    public static Connection getConnection()
    {
        try
        {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pizzeria_db","postgres","root");
            
            return conn;
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
}


