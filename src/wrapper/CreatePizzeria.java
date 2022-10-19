/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package wrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import model.PizzaConfig;

public interface CreatePizzeria
{
   void printPizzeria(String name);
   void configurePizzeria(String name);
   void createOptionSet(String pizzeriaName,String name);
   String createOption(String pizzeriaName,String optionSetName,String option,double price);
   void printPizzerias();
   String deletePizzeria(String pizzeriaName);
   List<String> getAllPizzeria();
   PizzaConfig getPizzeria(String name);
   boolean parseProperties(Properties p);
}
