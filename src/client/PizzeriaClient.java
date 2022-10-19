/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package client;

import java.util.List;

import model.PizzaConfig;

public interface PizzeriaClient
{
  public void loadProperties(String name);
  public List<String> getAllPizzerias();
  public void printPizzeria(String name);
  public String deletePizzeria(String name);
  public String addOption(String pizzeriaName,String optionSetName,String option,double price);
  public String updateBasePrice(String name,double newPrice);
  public PizzaConfig getPizzeria(String name);
}
