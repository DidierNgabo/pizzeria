/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package exceptions;


import helpers.ExceptionMapper;
import model.PizzaConfig;

public class ExceptionFactory
{
   
    
    public static CustomException createException(ExceptionMapper type,PizzaConfig config,boolean debug)
    {
        CustomException exception=null;
        
        if(type == ExceptionMapper.PRICEMISSING)
        {
            exception = new PriceMissingException(config,debug);
        }
        else if(type == ExceptionMapper.NAMEMISSING)
        {
            exception = new NameMissingException(config,debug); 
        }
        else if(type == ExceptionMapper.OPTIONSETEXISTS)
        {
            exception = new OptionSetExistException(config,debug); 
        }
        else if(type == ExceptionMapper.PIZZERIAEXISTS)
        {
            exception = new PizzeriaAlreadyExistsException(config,debug); 
        }
        else
        {
            exception = new OptionExistsException(config,debug); 
        }
        return exception;
    }
    
    public static CustomException createException(ExceptionMapper type,String name,boolean debug)
    {
        CustomException exception=null;
          
         if(type == ExceptionMapper.BADFILENAME)
        {
             exception = new FileSpaceException(name,debug); 
        }
         
         if(type == ExceptionMapper.FILENOTFOUND)
         {
              exception = new FileException(name,debug); 
         }
         
         if(type == ExceptionMapper.NOTFOUND)
         {
              exception = new NotFoundException(name,debug); 
         }
       
        return exception;
    }
}
