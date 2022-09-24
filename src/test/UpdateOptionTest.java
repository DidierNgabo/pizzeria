/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/
package test;

import model.PizzaConfig;

public class UpdateOptionTest extends PizzaTester
{

    UpdateOptionTest()
    {
        super("Lelo Restaurant",3000,"Small","Eat in");
    }
  
    public void executeTest()
    {
        this.setLabel("=================== Updating Option Test==================");
        System.out.println(this.getLabel());
        PizzaConfig c = getConfig();
        c.addOptionSet("Cheese Choice");
        
        c.updateOptionSet("Cheese Choice","Cheeses Choice");
       
        serialize();
        deserialize();
    }

}
