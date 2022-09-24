
/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package test;

import model.PizzaConfig;
import wrapper.CreatePizzeria;
import wrapper.PizzaConfigAPI;
import wrapper.UpdatePizzeria;

public class AddingChoiceTest extends PizzaTester
{
    AddingChoiceTest()
    {
        super("Kamiko Cafe",3000,"Small","Eat in");
    }
  
    public void executeTest()
    {
        setLabel("==================== Adding choices test ================");
        System.out.println(getLabel());
        PizzaConfig c = getConfig();
        PizzaConfigAPI api= new PizzaConfigAPI();
//      
     CreatePizzeria cpr= api;
     UpdatePizzeria upr=api;
        c.addOptionSet("Meat Choice");
        c.addOption("Meat Choice", "Pepperoni", 2800);
        c.addOption("Meat Choice", "Beef", 2000);
        c.addOption("Meat Choice", "Ham", 2400);
        c.addOption("Meat Choice", "Pepperoni", 2800);
        c.addOption("Meat Choice", "Pepperoni", 2800);
        c.addOption("Meat Choice", "Pepperoni", 2800);
        c.addOption("Meat Choice", "Pepperoni", 2800);
        c.addOption("Meat Choice", "Pepperoni", 2800);
        cpr.createPizzeria("Diddy", c);
        cpr.createPizzeria("Diddy", c);
       
        cpr.printPizzeria(c.getName());
        upr.updateBasePrice(c.getName(), 5000);
        
        cpr.printPizzeria(c.getName());
        
        serialize();
        deserialize();
    }
}
