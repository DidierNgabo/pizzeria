/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/
package test;

import model.PizzaConfig;

public class FindChoiceTest extends PizzaTester
{

    public FindChoiceTest()
    {
        super("House of Cakes",3000,"Medium","TA");
    }

    @Override
    public void executeTest()
    {
        this.setLabel("==================== Finding Choice Test ================");
        System.out.println(this.getLabel());
        PizzaConfig c = getConfig();
        c.addOptionSet("Meat Choice");
        c.addOption("Meat Choice", "Pepperoni", 2800);
        c.addOption("Meat Choice", "Beef", 2000);
        c.addOption("Meat Choice", "Ham", 2400);
        c.addOption("Meat Choice", "Rabbit", 2800);
        c.addOption("Meat Choice", "Duck", 2800);
        
        c.findOptionWithName("Meat Choice", "Duck");
      
        serialize();
        deserialize();
        
    }

}
