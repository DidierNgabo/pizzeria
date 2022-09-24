/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package test;

public class DuplicatingOptionSetPizzeriaTest extends  PizzaTester
{
    public  DuplicatingOptionSetPizzeriaTest()
    {
        super("Kamiko Cafe",3000,"Small","Eat in");
    }

    @Override
    public void executeTest()
    {
        System.out.println("\n=========== Testing Duplicating Option Set in Pizzeria =============\n");
        getCreateApi().createOptionSet("Diddy's Pizza", "first");
        getCreateApi().createOptionSet("Diddy's Pizza", "first");
        getCreateApi().printPizzeria("Diddy's Pizza");
        
    }
}
