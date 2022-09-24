/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package test;

public class AddingOptionSetPizzeriaTest extends PizzaTester
{
    public   AddingOptionSetPizzeriaTest()
    {
        super("Kamiko Cafe",3000,"Small","Eat in");
    }

    @Override
    public void executeTest()
    {
        System.out.println("\n=========== Testing creating Option Set =============\n");
        getCreateApi().createOptionSet("Diddy's Pizza", "first");
        getCreateApi().printPizzeria("Diddy's Pizza");
        
    }
}
