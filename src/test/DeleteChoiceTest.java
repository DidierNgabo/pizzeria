/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/
package test;

import model.PizzaConfig;

public class DeleteChoiceTest extends PizzaTester
{
    
    DeleteChoiceTest()
    {
        super("Simba",3000,"Small","Eat in");
    }

    public void executeTest()
    {
        this.setLabel("====== Deleting Choice Test ============");
        System.out.println(this.getLabel());
        PizzaConfig c = getConfig();
        c.addOptionSet("Meat Choice");
        c.addOption("Meat Choice", "Pepperoni", 2800);
        c.addOption("Meat Choice", "Beef", 4800);
        c.addOption("Meat Choice", "Ham", 4800);
        c.deleteOption("Meat Choice","Pepperoni");
        serialize();
        deserialize();
    }
    
}
