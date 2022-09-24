/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/
package test;

import model.PizzaConfig;

public class UpdateChoiceTest extends PizzaTester
{

    public UpdateChoiceTest()
    {
        super("Domino's pizza", 6500, "medium", "TA");
    }
    public void executeTest()
    {
        this.setLabel("==================== Update Choice Test ================");
        System.out.println(this.getLabel());
        PizzaConfig c = getConfig();
        c.addOptionSet("Meat Choice");
        c.addOption("Meat Choice", "Pepperoni", 2800);
        
        c.updateOption("Meat Choice","Pepperoni","pepper",2500);
       
        serialize();
        deserialize();
    }

}
