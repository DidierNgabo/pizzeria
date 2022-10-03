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
import java.util.Objects;
class OptionSet implements Serializable
{
   private String name;
   private ArrayList<Option> choices;
    OptionSet()
    {
      choices=new ArrayList<>();
    }
    OptionSet(String optionSetName)
    {
       
        name = optionSetName;
        choices =new ArrayList<>();
    }
    protected String getName()
    {
        return name;
    }
    
    protected void setName(String name)
    {
        this.name = name;
    }
    //crud methods for choices
    protected void addChoice(String name,double price)
    {
        try 
        {
                Option opt=new Option(name, price);
                choices.add(opt);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    protected int findChoice(String name)
    {
        for (Option choice:choices)
        {
            if(choice.getName().equalsIgnoreCase(name))
            {
                return choices.indexOf(choice);
            }
        }
        return -1;
    }
    protected void updateChoice(String choiceName,String newName,double price)
    {
       int idx=findChoice(choiceName);
       if(idx>-1)
       {
           choices.get(idx).setName(newName);
           choices.get(idx).setPrice(price);
       }
    }
    protected void updatePrice(String choiceName,double price)
    {
       int idx=findChoice(choiceName);
       if(idx>-1)
       {
           choices.get(idx).setPrice(price);
       }
    }
    protected void deleteChoice(String name)
    {   
        int idx=findChoice(name);
        if(idx>-1)
        {
            choices.remove(idx);
        }
    }
    
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Option set with name ").append(name)
        .append(" has ").append(choices.size()).append(" choices");
        return builder.toString();
    }
    protected void print()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("OptionSet Details\n")
        .append("name: ").append(name).append("\n")
        .append("Choices are: \n");
        for(Option choice:choices)
        {
            builder.append(choice);
        }
        System.out.println(builder.toString());
    }

    class Option implements Serializable{
       private String name;
       private double price;
        protected String getName()
        {
            return name;
        }
        protected void setName(String optionName)
        {
            name = optionName;
        }
        protected Option(String name, double price)
        {
            super();
            this.name = name;
            this.price = price;
        }
        protected double getPrice()
        {
            return price;
        }
        protected void setPrice(double optionPrice)
        {
            price = optionPrice;
        }
        public String toString()
        {
            StringBuilder builder = new StringBuilder("Option name: ");
            builder.append(name).append(" and the price: ").append(price);
            return builder.toString();
        }
        protected void print()
        {
            StringBuilder builder = new StringBuilder(" Choice name is ").append(name)
                    .append(" the price is ").append(price);
            System.out.println( builder.toString());
        }
    }
}
