/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package test;

public class CreateNameMissingPizzeriaTest extends PizzaTester
{
    public  CreateNameMissingPizzeriaTest()
    {
        super("Kamiko Cafe",3000,"Small","Eat in");
    }

    @Override
    public void executeTest()
    {
        System.out.println("=========== Testing creating Pizzeria When the name is missing =============");
        getCreateApi().createPizzeria("", getConfig());
        getCreateApi().printPizzeria("xxxxx");
        
    }
}
