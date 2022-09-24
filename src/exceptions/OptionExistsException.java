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

public class OptionExistsException extends CustomException
{
    public OptionExistsException(PizzaConfig config,boolean debug)
    {
        super(config);
        this.setDebugAllowed(debug);
    }

    @Override
    public void fix()
    {
        this.setName(this.getName()+"("+new Date().toGMTString()+")");
        log("Option already exists, created option with a new Name "+this.getName());
        
    }
}
