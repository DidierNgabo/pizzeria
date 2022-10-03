package client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;

import model.PizzaConfig;
import wrapper.CreatePizzeria;
import wrapper.PizzaConfigAPI;
import wrapper.UpdatePizzeria;

public class TestClient implements PizzeriaClient
{
    PizzaConfigAPI api = new PizzaConfigAPI();
    
    CreatePizzeria createApi = api;
    
    UpdatePizzeria updateApi = api;

    @Override
    public void loadProperties(String filename) 
    {
        try
        {
            Properties props= new Properties();
            FileInputStream in = new FileInputStream(filename);
            props.load(in);  
        } catch (Exception e)
        {
           System.out.println(e.getMessage());
        }
                                     
                                                        
    }

    @Override
    public List<String> getAllPizzerias()
    {
        return createApi.getAllPizzeria();
    }

    @Override
    public String deletePizzeria(String name)
    {
        return createApi.deletePizzeria(name);
        
    }

    @Override
    public String addOption(String pizzeriaName,String optionSetName,String option,double price)
    {
        return createApi.createOption(pizzeriaName, optionSetName, option, price);
        
    }

    @Override
    public String updateBasePrice(String name, double newPrice)
    {
        
        return updateApi.updateBasePrice(name, newPrice);
        
    }

    @Override
    public PizzaConfig getPizzeria(String name)
    {
       
        return createApi.getPizzeria(name);
    }

    @Override
    public void printPizzeria(String name)
    {
        PizzaConfig config = createApi.getPizzeria(name);
        config.print();
        
    }

}
