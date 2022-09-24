/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/
package model;

public enum DeliveryMode
{
    EATIN("EatIn"),
    TAKEAWAY("TakeAway"),
    DELIVERED("Delivered");
      
    private String _text;
    
    DeliveryMode(String s){
        _text= s;
    }
    
    public static DeliveryMode fromString(String stringValue) 
    {
        for (DeliveryMode option : DeliveryMode.values())
        {
            if (stringValue.equalsIgnoreCase(option._text))
                return option;
        }
        if (stringValue.equalsIgnoreCase("E"))
            return EATIN;
        if (stringValue.equalsIgnoreCase("T"))
            return TAKEAWAY;
        if (stringValue.equalsIgnoreCase("D"))
            return DELIVERED;
        return DELIVERED;
    }
    
    public static boolean isValid(String strValue)
    {
        if (fromString(strValue) != DELIVERED)
            return true;
        return false;
    }
}
