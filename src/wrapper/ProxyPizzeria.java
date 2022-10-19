/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package wrapper;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Properties;

import exceptions.CustomException;
import exceptions.ExceptionFactory;
import helpers.ExceptionMapper;
import io.FileHandler;
import model.PizzaConfig;

public abstract class ProxyPizzeria
{
    private static LinkedHashMap<String,PizzaConfig> configs=new LinkedHashMap<String,PizzaConfig>();
    
    private synchronized void createPizzeria(String pizzeriaName,PizzaConfig pizzaConfig) 
    {
        try 
        {
            if(pizzeriaName.isBlank())
            {
              
                throw  ExceptionFactory.createException(ExceptionMapper.NAMEMISSING,pizzaConfig,true);
            }
            
            if(configs.size() == 0)
            {
                configs.put(pizzeriaName, pizzaConfig);
            }
            else
            {
                if(checkExists(pizzeriaName))
                {
                    throw  ExceptionFactory.createException(ExceptionMapper.PIZZERIAEXISTS,pizzaConfig,true);
                }
                configs.put(pizzeriaName, pizzaConfig);
            } 
           
        }
        catch(CustomException e)
        {
            e.fix();
           configs.put(pizzaConfig.getName(), pizzaConfig);
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
                   throw  ExceptionFactory.createException(ExceptionMapper.OPTIONSETEXISTS,config,true);
               }
               
               config.addOptionSet(name);
            }
            else
            {
                throw  ExceptionFactory.createException(ExceptionMapper.NOTFOUND, pizzeriaName, true);
            }
        }
        catch(CustomException e)
        {
            e.setName(name);
            e.fix();
            config.addOptionSet(e.getName());
        }
        
    }
    
    public String createOption(String pizzeriaName,String optionSetName,String option,double price)
    {
        PizzaConfig config= configs.get(pizzeriaName);
        try
        {
           
            
            if(!Objects.isNull(config))
            {
               int idx= config.findOptionWithName(optionSetName,option);
               
               if(idx != -1)
               {
                   throw  ExceptionFactory.createException(ExceptionMapper.OPTIONEXISTS,config,true);
               }
               
               config.addOption(optionSetName,option, price);
               configs.put(pizzeriaName, config);
               return "Option added successfully";
            }
            else
            {
                throw  ExceptionFactory.createException(ExceptionMapper.NOTFOUND, pizzeriaName, true);
            }
        }
        catch(CustomException e)
        {
            e.setName(option);
            e.fix();
            config.addOption(optionSetName, e.getName(), price);
            configs.put(pizzeriaName, config);
            return "Option added successfully";
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
    
    // remove one of the following two methods
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
    
    public PizzaConfig getPizzeria(String name)
    {
        Iterator<Entry<String,PizzaConfig>> iterator = configs.entrySet().iterator();
        while(iterator.hasNext())
        {
            Entry<String,PizzaConfig> entry=iterator.next();
            
            if(name.equalsIgnoreCase(entry.getKey()))
            {
                System.out.println(entry.getKey());
               return  entry.getValue();
            }
           
        }
        return null;
    }
    
    public boolean parseProperties(Properties props)
    {
       PizzaConfig config = new PizzaConfig();
      
       String p = props.getProperty("Pizzeria");
       if(!p.equals(null))
       {
           String price = props.getProperty("BasePrice");
           String option1 = props.getProperty("Option1");
           String option2 = props.getProperty("Option2");
           String optionValue1a = props.getProperty("OptionValue1a");
           String optionValue1b = props.getProperty("OptionValue1b");
           String optionValue2a = props.getProperty("OptionValue2a");
           String optionValue2b = props.getProperty("OptionValue2b");
           
           config.setName(p);
           config.setBasePrice(Double.parseDouble(price));
           config.addOptionSet(option1);
           config.addOptionSet(option2);
           config.addOption(option1, optionValue1a, 500);
           config.addOption(option1, optionValue1b, 400);
           config.addOption(option2, optionValue2a, 300);
           config.addOption(option2, optionValue2b, 200);
           
           this.createPizzeria(p, config); 
           return true;
       }
       
       return false;
    }
    
    public void configurePizzeria(String name)
    {
        FileHandler handler = new FileHandler();
        PizzaConfig config = null;
        try
        {
           
            try 
            {
                if(name.contains(" "))
                {
                    throw ExceptionFactory.createException(ExceptionMapper.BADFILENAME, name, true);
                }
                config = handler.buildPizzaConfig(name);
                if(config !=null)
                {
                    synchronized (config)
                    {
                        createPizzeria(config.getName(), config);
                    }
                }
                    
                   
            }
            catch(IOException e)
            {
                if(e.getClass().getName().contains("FileNotFoundException"))
                  throw ExceptionFactory.createException(ExceptionMapper.FILENOTFOUND, name, true);
            }
        } 
        catch (CustomException e)
        {
            e.fix();
            try
            {
               config= handler.buildPizzaConfig(e.getName());
               createPizzeria(name, config);
            } catch (IOException ex)
            {
               System.out.println(ex.getMessage());
            }
        }
        
       
    }
    
    // change this method to use status codes
    public String updateBasePrice(String pizzeriaName,double newPrice)
    {
        PizzaConfig config= configs.get(pizzeriaName);
        try
        {
            
            if(newPrice == 0)
            {
                throw  ExceptionFactory.createException(ExceptionMapper.PRICEMISSING,config,true);
            }
            
            Iterator<Entry<String,PizzaConfig>> iterator = configs.entrySet().iterator();
            while(iterator.hasNext())
            {
                Entry<String,PizzaConfig> entry=iterator.next();
                
                if(pizzeriaName.equalsIgnoreCase(entry.getKey()))
                {
                    entry.getValue().updateBasePrice(newPrice);
                    configs.put(pizzeriaName, entry.getValue());
                    return "Baseprice successfully updated";
                }
            }
            return null;
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
                   configs.put(pizzeriaName, entry.getValue());
                   return "Baseprice successfully updated";
               }
              
           }
           return null;
           
        }
       
       
    }
    public void updateOptionSetName(String name,String optionSetName,String newName)
    {
        PizzaConfig config= configs.get(name);
        try
        {
            if(newName.isBlank())
            {
                throw ExceptionFactory.createException(ExceptionMapper.NAMEMISSING,config,true);
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
                throw ExceptionFactory.createException(ExceptionMapper.PRICEMISSING,config,true);
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
    
    public synchronized String deletePizzeria(String pizzeriaName)
    {
        if (checkExists(pizzeriaName))
        {
            configs.remove(pizzeriaName);
            return "Pizzera deleted successfully";
        }
        return null;
    }
    
    public String toString()
    {
        StringBuilder builder= new StringBuilder("pizzeria contains");
        return builder.append(configs.size()).append("configs").toString();
    }
    
    public synchronized void printPizzerias()
    {
      for(PizzaConfig config:configs.values())
      {
          config.print();
      }
    }
    
    public List<String> getAllPizzeria()
    {
       List<String> pizzeriasName = new ArrayList(configs.keySet()); 
       
       return pizzeriasName;
    }
}
    
