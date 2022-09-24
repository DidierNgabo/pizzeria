/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package test;

public class DuplicatingOptionPizzeriaTest extends PizzaTester
{
    public  DuplicatingOptionPizzeriaTest()
    {
        super("Kamiko Cafe",3000,"Small","Eat in");
    }

    @Override
    public void executeTest()
    {
        System.out.println("\n=========== Testing creating Duplicate Option  =============\n");
        getCreateApi().createOption("Diddy's Pizza","first", "Tomato", 5000);
        getCreateApi().printPizzeria("Diddy's Pizza");
        
    }
}
