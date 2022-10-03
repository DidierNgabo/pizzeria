/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/
package helpers;

import model.DeliveryMode;

public enum ExceptionMapper
{
    OPTIONEXISTS("Option Exists"),
    OPTIONSETEXISTS("OptionSet Exists"),
    PRICEMISSING("Price Missing"),
    PIZZERIAEXISTS("Pizzeria Exists"),
    NAMEMISSING("Name Missing"),
    FILENOTFOUND("File Not Found"),
    BADFILENAME("Bad File Name"),
    NOTFOUND("NOT FOUND");
      
    private String _text;
    
    ExceptionMapper(String s){
        _text= s;
    }
    
    public static ExceptionMapper fromString(String stringValue) 
    {
        for (ExceptionMapper option : ExceptionMapper.values())
        {
            if (stringValue.equalsIgnoreCase(option._text))
                return option;
        }
        if (stringValue.equalsIgnoreCase("Option Exists"))
            return OPTIONEXISTS;
        if (stringValue.equalsIgnoreCase("OptionSet Exists"))
            return OPTIONSETEXISTS;
        if (stringValue.equalsIgnoreCase("Price Missing"))
            return PRICEMISSING;
        if (stringValue.equalsIgnoreCase("Pizzeria Exists"))
            return PIZZERIAEXISTS;
        if (stringValue.equalsIgnoreCase("Name Missing"))
            return NAMEMISSING;
        if (stringValue.equalsIgnoreCase("File Not Found"))
            return FILENOTFOUND;
        if (stringValue.equalsIgnoreCase("Bad File Name"))
            return BADFILENAME;
        if (stringValue.equalsIgnoreCase("Not found"))
            return NOTFOUND;
        return NOTFOUND;
    }
    
    public static boolean isValid(String strValue)
    {
        if (fromString(strValue) != NAMEMISSING)
            return true;
        return false;
    }
}
