/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/
package helpers;

public enum ProtocolMapper
{
    LOAD_PROPERTIES("Load properties"),
    GET_ALL_PIZZERIAS("Get all pizzerias"),
    UPDATE_PRICE("Update Price"),
    PRINT("Print"),
    DELETE("Delete pizzeria"),
    ADD_OPTION("add option"),
    NOTFOUND("NOT FOUND");
      
    private String _text;
    
    ProtocolMapper(String s){
        _text= s;
    }
    
    public static ProtocolMapper fromString(String stringValue) 
    {
        for (ProtocolMapper option : ProtocolMapper.values())
        {
            if (stringValue.equalsIgnoreCase(option._text))
                return option;
        }
        if (stringValue.equalsIgnoreCase("load Properties"))
            return LOAD_PROPERTIES;
        if (stringValue.equalsIgnoreCase("Get all Pizzerias"))
            return GET_ALL_PIZZERIAS;
        if (stringValue.equalsIgnoreCase("Update Price"))
            return UPDATE_PRICE;
        if (stringValue.equalsIgnoreCase("Print"))
            return PRINT;
        if (stringValue.equalsIgnoreCase("Delete Pizzeria"))
            return DELETE;
        if (stringValue.equalsIgnoreCase("add Option"))
            return ADD_OPTION;
        if (stringValue.equalsIgnoreCase("Not found"))
            return NOTFOUND;
        return NOTFOUND;
    }
    
    public static boolean isValid(String strValue)
    {
        if (fromString(strValue) != DELETE)
            return true;
        return false;
    }
}
