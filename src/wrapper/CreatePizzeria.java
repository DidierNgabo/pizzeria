/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package wrapper;

import java.util.ArrayList;

import model.PizzaConfig;

public interface CreatePizzeria
{
  public void printPizzeria(String name);
  public void configurePizzeria(String name);
  public void createOptionSet(String pizzeriaName,String name);
  public void createOption(String pizzeriaName,String optionSetName,String option,double price);
  public void printPizzerias();
}
