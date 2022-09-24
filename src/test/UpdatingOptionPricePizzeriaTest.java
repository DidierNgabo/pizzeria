/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package test;

public class UpdatingOptionPricePizzeriaTest extends PizzaTester
{
    public     UpdatingOptionPricePizzeriaTest()
    {
        super("Kamiko Cafe",3000,"Small","Eat in");
    }

    @Override
    public void executeTest()
    {
        System.out.println("\n=========== Testing updating Option Price Pizzeria "
                + " =============\n");
        getUpdateApi().updateOptionPrice("Diddy's Pizza","Veg Choice","Tomato",3000);
        getCreateApi().printPizzeria("Diddy's Pizza");
        
    }
}
