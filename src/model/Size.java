/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package model;

public enum Size
{
  SMALL("Small"),
  MEDIUM("Medium"),
  LARGE("Large");
    
  private String _text;
  
  Size(String s){
      _text= s;
  }
  
  public String toString()
  {
      return _text;
  }
  
  public static Size fromString(String stringValue) 
  {
      for (Size option : Size.values())
      {
          if (stringValue.equalsIgnoreCase(option._text))
              return option;
      }
      if (stringValue.equalsIgnoreCase("S"))
          return SMALL;
      if (stringValue.equalsIgnoreCase("M"))
          return MEDIUM;
      if (stringValue.equalsIgnoreCase("L"))
          return LARGE;
      return SMALL;
  }
  
  public static boolean isValid(String strValue)
  {
      if (fromString(strValue) != SMALL)
          return true;
      return false;
  }
  
}
