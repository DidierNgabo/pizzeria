/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package exceptions;

import java.util.Date;

import model.PizzaConfig;

public class PizzeriaAlreadyExistsException extends CustomException
{
    public PizzeriaAlreadyExistsException(String name,boolean debug)
    {
        super(name);
        this.setDebugAllowed(debug);
    }
    
    @Override
    public void fix()
    {
        this.setName(this.getName()+"("+new Date().toGMTString()+")");
        log("Pizzeria already exists, created pizzeria with a new Name "+this.getName());
        
    }

}
