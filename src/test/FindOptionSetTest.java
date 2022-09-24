/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/
package test;

import model.PizzaConfig;

public class FindOptionSetTest extends PizzaTester
{

    public FindOptionSetTest()
    {
        super("Tally Bakery",2499,"Small","Eat in");
       
    }

    public void executeTest()
    {
        this.setLabel("========== Finding Option Set test ===========");
        PizzaConfig c = getConfig();
        c.addOptionSet("Meat Choice");
        c.addOption("Meat Choice", "Pepperoni", 2800);
        if(c.findOptionSet("Meat Choice") > -1)
        {
            System.out.println("Option Set Found!!!");
        }
        else
        {
            System.out.println("Option Set Not Found");
        }
        serialize();
        deserialize();
        
    }
    
    

}
