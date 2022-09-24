/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/
package test;

import model.PizzaConfig;

public class AddingOptionTest extends PizzaTester
{
    AddingOptionTest()
    {
        super("KFC",5000,"Medium","Eat in");
    }
  
    public void executeTest()
    {
        this.setLabel("===========Adding option test===========");
        System.out.println(this.getLabel());
        PizzaConfig c = getConfig();
        c.addOptionSet("Meat Choice");
        c.addOptionSet("Veg Choice");
        c.addOptionSet("Cheese Choice");
//        c.addOption("Meat Choice", "Pepperoni", 2800);
        serialize();
        deserialize();
    }
  
}
