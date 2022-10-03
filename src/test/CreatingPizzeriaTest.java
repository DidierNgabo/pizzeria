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
        getCreateApi().configurePizzeria("pizzaconf.txt");
        getCreateApi().configurePizzeria("pizzaconf.txt");
        getCreateApi().configurePizzeria("pizzaconf.txt");
        getCreateApi().configurePizzeria("pizzaconf.txt");
        getCreateApi().configurePizzeria("pizzaconf.txt");
        getCreateApi().configurePizzeria("pizzaconf.txt");
        //getCreateApi().printPizzeria("Diddy's Pizza");
//        getCreateApi().deletePizzeria("Diddy's Pizza");
        System.out.println("=========== printing Pizzeria =============");
        getCreateApi().printPizzerias();
        
    }

}
