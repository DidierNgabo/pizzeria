/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package test;

public class CreatingPizzeriaTest extends PizzaTester
{
    
    
    public CreatingPizzeriaTest()
    {
        super("Kamiko Cafe",3000,"Small","Eat in");
    }

    @Override
    public void executeTest()
    {
        System.out.println("=========== Testing creating Pizzeria =============");
        getCreateApi().createPizzeria("Diddy's Pizza", getConfig());
        getCreateApi().printPizzeria("Diddy's Pizza");
        
    }

}
