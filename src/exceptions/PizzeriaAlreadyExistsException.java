/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package exceptions;

import java.util.Date;
import java.util.Random;

import model.PizzaConfig;

public class PizzeriaAlreadyExistsException extends CustomException
{
   
    
    public PizzeriaAlreadyExistsException(PizzaConfig c,boolean debug)
    {
        super(c);
        this.setDebugAllowed(debug);
        
    }


    @Override
    public void fix()
    {
        Random rand=new Random(); 
        config.setName(config.getName()+" "+rand.nextInt());
        log("Pizzeria already exists, created pizzeria with a new Name "+config.getName());
        
    }

}
