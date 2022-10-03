/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package test;

public class DuplicatingPizzeriaTest extends PizzaTester
{
    public DuplicatingPizzeriaTest()
    {
        super("Kamiko Cafe",3000,"Small","Eat in");
    }

    @Override
    public void executeTest()
    {
        System.out.println("=========== Testing Duplicating Pizzeria =============");
        getCreateApi().configurePizzeria("pizzaconf.txt");
        getCreateApi().printPizzeria("Diddy's Pizza");
    }
}
