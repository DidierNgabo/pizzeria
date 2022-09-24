/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/
package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import model.PizzaConfig;
import wrapper.CreatePizzeria;
import wrapper.PizzaConfigAPI;
import wrapper.UpdatePizzeria;

public abstract class PizzaTester implements Serializable
{
    private PizzaConfig config;
    private String label;
    private PizzaConfigAPI api = new PizzaConfigAPI();
    private CreatePizzeria createApi = api;
    private UpdatePizzeria updateApi = api;
    
    
      
    public CreatePizzeria getCreateApi()
    {
        return createApi;
    }

    public UpdatePizzeria getUpdateApi()
    {
        return updateApi;
    }

    public PizzaTester(String name,double price,String size,String delivery)
    {
        config = new PizzaConfig(name,price,size,delivery);
    }

    public PizzaConfig getConfig()
    {
        return config;
    }

    public void setConfig(PizzaConfig pizza)
    {
        config = pizza;
    }
    

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String classLabel)
    {
        label = classLabel;
    }

    public void serialize()
    {
        try
        {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("config.dat"));
            out.writeObject(config);
            out.close();
//            config.print();
        } catch (Exception e)
        {
            System.out.print("Error: " + e);
        }
    }
    
    public void deserialize()
    {
        try
        {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("config.dat"));
            PizzaConfig conf = (PizzaConfig) in.readObject();
            in.close();
            conf.print();
        } catch (Exception e)
        {
            System.out.print("Error: " + e);
        }
    }
    
    public abstract void executeTest();

   
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("PizzaTester").append(" ").append(config.getName());
        return builder.toString();
    }
    
    
    
}
