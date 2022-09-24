/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package exceptions;

import java.util.LinkedHashMap;

import model.PizzaConfig;

// change the name please
public class ExceptionFactory
{
   
    
    public static CustomException createException(String type,PizzaConfig config,boolean debug)
    {
        CustomException exception=null;
        
        if(type.equalsIgnoreCase("basePriceMissing"))
        {
            exception = new PriceMissingException(config,debug);
        }
        else if(type.equalsIgnoreCase("nameMissing"))
        {
            exception = new NameMissingException(config,debug); 
        }
        else if(type.equalsIgnoreCase("OptionSetExists"))
        {
            exception = new OptionSetExistException(config,debug); 
        }
        else
        {
            exception = new OptionExistsException(config,debug); 
        }
        return exception;
    }
    
    public static CustomException createException(String type,String name,boolean debug)
    {
        CustomException exception=null;
        
         if(type.equalsIgnoreCase("pizzeriaAlreadyExists"))
        {
            exception = new PizzeriaAlreadyExistsException(name,debug); 
        }
       
        return exception;
    }
}
