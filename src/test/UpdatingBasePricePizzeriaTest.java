/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package test;

public class UpdatingBasePricePizzeriaTest extends PizzaTester
{
    public   UpdatingBasePricePizzeriaTest()
    {
        super("Kamiko Cafe",3000,"Small","Eat in");
    }

    @Override
    public void executeTest()
    {
        System.out.println("\n=========== Testing updating price =============\n");
        getUpdateApi().updateBasePrice("Diddy's Pizza", 4000);
        getCreateApi().printPizzeria("Diddy's Pizza");
        
    }
}
