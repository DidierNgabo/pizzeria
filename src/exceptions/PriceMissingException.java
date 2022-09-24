/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package exceptions;

import model.PizzaConfig;

public class PriceMissingException extends CustomException
{
   
    public PriceMissingException(PizzaConfig config,boolean debug)
    {
        super(config);
        this.setDebugAllowed(debug);
    }
    
    @Override
    public void fix()
    {
        config.setBasePrice(1000);
        log("The price was empty, it was set to the minimum price of 1000");
        
    }
}
