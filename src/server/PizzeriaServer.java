/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package server;

import java.util.List;
import java.util.Properties;

import model.PizzaConfig;
import wrapper.CreatePizzeria;
import wrapper.PizzaConfigAPI;
import wrapper.UpdatePizzeria;

public class PizzeriaServer implements PizzeriaInterface
{
    
   
   CreatePizzeria createApi = null; 
    
   UpdatePizzeria updateApi = null;
    
    public PizzeriaServer(PizzaConfigAPI _api)
    {
        createApi = _api;
        updateApi = _api;
    }

    
  

    @Override
    public Boolean loadProperties(Properties p)
    {
      return createApi.parseProperties(p);
        
    }

    @Override
    public List<String> getAllPizzerias()
    {
        return createApi.getAllPizzeria();
    }

    @Override
    public PizzaConfig printPizzeria(String name)
    {
       
        return createApi.getPizzeria(name);
    }

    @Override
    public String deletePizzeria(String name)
    {
        
        return createApi.deletePizzeria(name);
    }

    @Override
    public String addOption(String pizzeriaName, String optionSetName, String option, double price)
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

}
