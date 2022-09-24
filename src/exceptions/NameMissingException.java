/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package exceptions;

import model.PizzaConfig;

public class NameMissingException extends CustomException
{
    

    public NameMissingException(PizzaConfig config,boolean debug)
    {
        super(config);
        this.setDebugAllowed(debug);
    }

    @Override
    public void fix()
    {
            config.setName("xxxxx");
            log("Pizzeria name created with a new Name "+this.getName());
        
    }
}
