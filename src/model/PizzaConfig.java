/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/
package model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;


public class PizzaConfig implements Serializable
{   
   private String name;
   private double basePrice;
   private Size size;
   private DeliveryMode deliveryMode;
   private ArrayList<OptionSet> optionSets;
//    constructors
    public PizzaConfig()
    {
        name = "Base Config";
        basePrice = 2000;
        size = Size.SMALL;
        deliveryMode = DeliveryMode.EATIN;
        optionSets = new ArrayList<>();
    }
    public PizzaConfig(String configName)
    {
        name = configName;
        optionSets =new ArrayList<>();
        basePrice = 2000;
        size = Size.SMALL;
        deliveryMode = DeliveryMode.EATIN;
        
    }
    public PizzaConfig(String configName,double price)
    {
        name = configName;
        optionSets =new ArrayList<>();
        basePrice = 2000;
        size = Size.SMALL;
        deliveryMode = DeliveryMode.EATIN;
        
    }
    public PizzaConfig(double base)
    {
        basePrice= base;
        optionSets =new ArrayList<>();
        size = Size.SMALL;
        deliveryMode = DeliveryMode.EATIN;
    }
    public PizzaConfig(String configName, double price, String pizzaSize, String mode)
    {
        name = configName;
        basePrice =price;
        size = Size.fromString(pizzaSize);
        deliveryMode = DeliveryMode.fromString(mode);
        optionSets =new ArrayList<>();
    }
//    getters and setters
    public String getName()
    {
        return name;
    }
    public void setName(String pizzaName)
    {
        name = pizzaName;
    }
    public double getBasePrice()
    {
        return basePrice;
    }
    public void setBasePrice(double base)
    {
        basePrice = base;
    }
    public Size getSize()
    {
        return size;
    }
    public void setSize(String pizzaSize)
    {   
        size = Size.fromString(pizzaSize);
    }
    public DeliveryMode getDeliveryMode()
    {
        return deliveryMode;
    }
    public void setDeliveryMode(String mode)
    {
        deliveryMode = DeliveryMode.fromString(mode);
    }
//    operations for pizza config
    
    public boolean updateBasePrice(double amount)
    {
        if(amount> 0)
        {
            setBasePrice(amount);
            return true;
        }
        return false;
    }
    public boolean updatePizzaConfig(String name,double amount)
    {
        if(amount > 0 && !name.isEmpty())
        {   
            setName(name);
            setBasePrice(amount);
            return true;
        }
        else
        {
            return false;
        }
    }
//    crud methods for OptionSet
    public boolean addOptionSet(String name)
    {
        try 
        {
       
            OptionSet s=new OptionSet(name);
            optionSets.add(s);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    public int findOptionSet(String name)
    {
        for (OptionSet option:optionSets)
        {
            if(option.getName().equalsIgnoreCase(name))
            {
                return optionSets.indexOf(option);
            }
        }
        return -1;
    }
    
    public void deleteAllOptionSets()
    {
        optionSets.clear();
    }
    public void deleteOneOptionSet(String name)
    {
       
       int idx = findOptionSet(name);
       
       if(idx >-1 )
       {
           optionSets.remove(idx);
       }
       
    }
    public void updateOptionSet(String option,String newName)
    {
        int idx= findOptionSet(option);
        if(idx>-1)
        {
            optionSets.get(idx).setName(newName);
        }
    }
//    crud operations for choices in context of option set
    public void addOption(String optionSetName,String name,double price)
    {
        int idx = findOptionSet(optionSetName);
        if(idx > -1)
            optionSets.get(idx).addChoice(name,price);
    }
    public int findOptionWithName(String optionName,String choice)
    {
        int idx = findOptionSet(optionName);
        if(idx>-1 )
        {
            return optionSets.get(idx).findChoice(choice);
        }
            
      return -1;
    }
    public void deleteOption(String option,String choice)
    {
        int idx = findOptionSet(option);
        
        if(idx>-1)
        {
             optionSets.get(idx).deleteChoice(choice);
          
        }
    }
    public void updateOptionPrice(String option,String optionName,double price)
    {
        int idx= findOptionSet(option);
        
        if(idx>-1)
        
           optionSets.get(idx).updatePrice(optionName, price);
        
    }
    public void updateOption(String option,String optionName,String updated,double price)
    {
        int idx= findOptionSet(option);
        
        if(idx>-1)
        
           optionSets.get(idx).updateChoice(optionName, updated, price);
        
    }
//    print and toString methods
    public void print()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Pizza config \n")
        .append("name: "+name+"\n")
        .append("base Price: "+basePrice+"\n");
        System.out.println(builder.toString());
        for(OptionSet option:optionSets)
        {
            option.print();
            System.out.println("\n");
        }   
    }
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Pizza Config name is ").append(name).append(" the baseprice is ").append(basePrice);
        return builder.toString();
    }   
}
