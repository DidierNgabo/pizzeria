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

public class OptionSetExistException extends CustomException
{
    public OptionSetExistException(PizzaConfig config,boolean debug)
    {
        super(config);
        this.setDebugAllowed(debug);
    }

    @Override
    public void fix()
    {
        this.setName(this.getName()+"("+new Date().toGMTString()+")");
        log("Option Set already exists, created option set with a new Name "+this.getName());
        
    }
}
