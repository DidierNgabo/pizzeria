
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
        c.addOptionSet("Meat Choice");
        c.addOption("Meat Choice", "Pepperoni", 2800);
        c.addOption("Meat Choice", "Beef", 2000);
        c.addOption("Meat Choice", "Ham", 2400);
        c.addOption("Meat Choice", "Pepperoni", 2800);
        c.addOption("Meat Choice", "Pepperoni", 2800);
        c.addOption("Meat Choice", "Pepperoni", 2800);
        c.addOption("Meat Choice", "Pepperoni", 2800);
        c.addOption("Meat Choice", "Pepperoni", 2800);
        serialize();
        deserialize();
    }
}
