/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package wrapper;


import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Objects;

import exceptions.CustomException;
import exceptions.ExceptionFactory;
import io.FileHandler;
import model.PizzaConfig;

public abstract class ProxyPizzeria
{
    private static LinkedHashMap<String,PizzaConfig> configs=new LinkedHashMap<String,PizzaConfig>();
    
    
    private void createPizzeria(String pizzeriaName,PizzaConfig pizzaConfig) 
    {
        try 
        {
            if(pizzeriaName.isBlank())
            {
              
                throw  ExceptionFactory.createException("nameMissing",pizzaConfig,true);
            }
            
            if(configs.size() == 0)
            {
                configs.put(pizzeriaName, pizzaConfig);
            }
            else
            {
                if(checkExists(pizzeriaName))
                {
                    throw  ExceptionFactory.createException("pizzeriaAlreadyExists",pizzaConfig,true);
                }
                configs.put(pizzeriaName, pizzaConfig);
            } 
           
        }
        catch(CustomException e)
        {
            e.setName(pizzeriaName);
            e.fix();
           configs.put(e.getName(), pizzaConfig);
        }
    }
    
    public void createOptionSet(String pizzeriaName,String name)
    {
        PizzaConfig config= configs.get(pizzeriaName);
        try
        {
            
            if(!Objects.isNull(config))
            {
               int idx= config.findOptionSet(name);
               
               if(idx != -1)
               {
                   throw  ExceptionFactory.createException("OptionSetExists",config,true);
               }
               
               config.addOptionSet(name);
            }
        }
        catch(CustomException e)
        {
            e.setName(name);
            e.fix();
            config.addOptionSet(e.getName());
        }
        
    }
    
    public void createOption(String pizzeriaName,String optionSetName,String option,double price)
    {
        PizzaConfig config= configs.get(pizzeriaName);
        try
        {
           
            
            if(!Objects.isNull(config))
            {
               int idx= config.findOptionWithName(optionSetName,option);
               
               if(idx != -1)
               {
                   throw  ExceptionFactory.createException("OptionExists",config,true);
               }
               
               config.addOption(optionSetName,option, price);
            }
        }
        catch(CustomException e)
        {
            e.setName(option);
            e.fix();
            config.addOption(optionSetName, e.getName(), price);
        }
        
    }
    
    private boolean checkExists(String name)
    {
        Iterator i= configs.keySet().iterator();
        while (i.hasNext())
        {
         
            if(i.next().equals(name))
            {
                return true;
            }
            
        }
        
        return false;
    }
    
    // check the pizzeria print well
    public void printPizzeria(String name)
    {
        Iterator<Entry<String,PizzaConfig>> iterator = configs.entrySet().iterator();
        while(iterator.hasNext())
        {
            Entry<String,PizzaConfig> entry=iterator.next();
            
            if(name.equalsIgnoreCase(entry.getKey()))
            {
                System.out.println(entry.getKey());
                entry.getValue().print();
            }
           
        }
    }
    
    // leave this as it is 
    public void configurePizzeria(String name)
    {
        PizzaConfig config = FileHandler.buildPizzaConfig(name);
        if(config !=null)
         createPizzeria(config.getName(), config);
    }
    
    //
    public void updateBasePrice(String pizzeriaName,double newPrice)
    {
        PizzaConfig config= configs.get(pizzeriaName);
        try
        {
            
            if(newPrice == 0)
            {
                throw  ExceptionFactory.createException("basePriceMissing",config,true);
            }
            
            Iterator<Entry<String,PizzaConfig>> iterator = configs.entrySet().iterator();
            while(iterator.hasNext())
            {
                Entry<String,PizzaConfig> entry=iterator.next();
                
                if(pizzeriaName.equalsIgnoreCase(entry.getKey()))
                {
                    entry.getValue().updateBasePrice(newPrice);
                }
            }
        } catch (CustomException e)
        {
           e.fix();
           Iterator<Entry<String,PizzaConfig>> iterator = configs.entrySet().iterator();
           while(iterator.hasNext())
           {
               Entry<String,PizzaConfig> entry=iterator.next();
               
               if(pizzeriaName.equalsIgnoreCase(entry.getKey()))
               {
                   entry.getValue().updateBasePrice(config.getBasePrice());
               }
              
           }
           
        }
       
       
    }
    public void updateOptionSetName(String name,String optionSetName,String newName)
    {
        PizzaConfig config= configs.get(name);
        try
        {
            if(newName.isBlank())
            {
                throw ExceptionFactory.createException("nameMissing",config,true);
            }
            Iterator<Entry<String,PizzaConfig>> iterator = configs.entrySet().iterator();
            while(iterator.hasNext())
            {
                Entry<String,PizzaConfig> entry=iterator.next();
                
                if(name.equalsIgnoreCase(entry.getKey()))
                {
                   int idx = entry.getValue().findOptionSet(optionSetName);
                   
                   if( idx != -1)
                   {
                       configs.get(name).updateOptionSet(optionSetName, newName);
                   }
                }
            }
        } catch (CustomException e)
        {
           e.fix();
           Iterator<Entry<String,PizzaConfig>> iterator = configs.entrySet().iterator();
           while(iterator.hasNext())
           {
               Entry<String,PizzaConfig> entry=iterator.next();
               
               if(name.equalsIgnoreCase(entry.getKey()))
               {
                   int idx = entry.getValue().findOptionSet(optionSetName);
                   
                   if( idx != -1)
                   {
                       configs.get(name).updateOptionSet(optionSetName, newName);
                   }
               }
              
           }
           
        }
    }
    public void updateOptionPrice(String pizzeriaName,String optionName,String option,double newPrice)
    {
        PizzaConfig config= configs.get(pizzeriaName);
        try
        {
            if(newPrice == 0)
            {
                throw ExceptionFactory.createException("basePriceMissing",config,true);
            }
            Iterator<Entry<String,PizzaConfig>> iterator = configs.entrySet().iterator();
            while(iterator.hasNext())
            {
                Entry<String,PizzaConfig> entry=iterator.next();
                
                if(pizzeriaName.equalsIgnoreCase(entry.getKey()))
                {
                   int idx = entry.getValue().findOptionWithName(optionName,option);
                   
                   if( idx != -1)
                   {
                       configs.get(pizzeriaName).updateOptionPrice(optionName,option,newPrice);
                   }
                }
            }
        } catch (CustomException e)
        {
           e.fix();
           Iterator<Entry<String,PizzaConfig>> iterator = configs.entrySet().iterator();
           while(iterator.hasNext())
           {
               Entry<String,PizzaConfig> entry=iterator.next();
               
               if(pizzeriaName.equalsIgnoreCase(entry.getKey()))
               {
                  int idx = entry.getValue().findOptionWithName(optionName,option);
                  
                  if( idx != -1)
                  {
                      configs.get(pizzeriaName).updateOptionPrice(optionName,option,config.getBasePrice());
                  }
               }
              
           }
           
        }
    }
    
    public void deletePizzeria(String pizzeriaName)
    {
        
    }
    
    public String toString()
    {
        StringBuilder builder= new StringBuilder("pizzeria contains");
        return builder.append(configs.size()).append("configs").toString();
    }
    
    public void printPizzerias()
    {
       StringBuilder builder = new StringBuilder("The Pizzeria is ");
       configs.forEach((key,value)->{
           builder.append(key).append("\n");
           builder.append(value);
       });
       System.out.println(builder.toString());
    }
    
    
}
    
