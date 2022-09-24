package test;
/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

import model.PizzaConfig;

public class DeleteOptionTest extends PizzaTester
{
   DeleteOptionTest()
    {
        super("Burger King",1000,"Small","Eat in");
    }
  
    public void executeTest()
    {
        this.setLabel("======== Deleting Option test ==========");
        System.out.println(this.getLabel());
        PizzaConfig c = getConfig();
        c.addOptionSet("Meat Choice");
        c.addOptionSet("Veg Choice");
        c.addOption("Meat Choice", "Pepperoni", 2800);
        c.deleteOneOptionSet("Meat Choice");
       
        serialize();
        deserialize();
    }
}
