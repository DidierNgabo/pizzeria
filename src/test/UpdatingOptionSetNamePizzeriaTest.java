/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package test;

public class UpdatingOptionSetNamePizzeriaTest extends PizzaTester
{
    public    UpdatingOptionSetNamePizzeriaTest()
    {
        super("Kamiko Cafe",3000,"Small","Eat in");
    }

    @Override
    public void executeTest()
    {
        System.out.println("\n=========== Testing updating Option Set Name =============\n");
        getUpdateApi().updateOptionSetName("Diddy's Pizza","first","Veg Choice");
        getCreateApi().printPizzeria("Diddy's Pizza");
        
    }
}
