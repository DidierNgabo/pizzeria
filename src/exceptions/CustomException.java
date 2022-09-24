/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package exceptions;
import java.util.logging.Logger;

import model.PizzaConfig;


public abstract class CustomException extends Exception
{
    private static Logger logger = Logger.getLogger(CustomException.class.getName());
    
    private boolean isDebugAllowed=true;
    
    String name;
    
    PizzaConfig config;
    
    public CustomException(PizzaConfig c)
    {
   
        config = c;
    }
    
    public CustomException(String n)
    {
   
        name = n;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String pizzeriaName)
    {
        name = pizzeriaName;
    }

    public boolean isDebugAllowed()
    {
        return isDebugAllowed;
    }

    public void setDebugAllowed(boolean debug)
    {
        isDebugAllowed = debug;
    }

    public void log(String msg)
    {
        if(isDebugAllowed)
        {
            logger.info(msg);
        }
       
    }
     
    public  abstract void fix();
}
