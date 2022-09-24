/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package test;

public class ConfigurePizzeriaTest extends PizzaTester
{
    public ConfigurePizzeriaTest()
    {
        super("Kamiko Cafe",3000,"Small","Eat in");
    }

    @Override
    public void executeTest()
    {
        System.out.println("=========== Testing configure Pizzeria =============");
        getCreateApi().configurePizzeria("C:\\Users\\Didier Ngabo\\eclipse-workspace\\pizzeria\\pizzaconf.txt");
       
        
    }
}




