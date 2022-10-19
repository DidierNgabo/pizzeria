/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package server;

import java.util.List;
import java.util.Properties;

import model.PizzaConfig;

public interface PizzeriaInterface
{
    public Boolean loadProperties(Properties p);
    public List<String> getAllPizzerias();
    public PizzaConfig printPizzeria(String name);
    public String deletePizzeria(String name);
    public String addOption(String pizzeriaName,String optionSetName,String option,double price);
    public String updateBasePrice(String name,double newPrice);
    public PizzaConfig getPizzeria(String name);
}
