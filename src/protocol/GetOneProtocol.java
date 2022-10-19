/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/
package protocol;

import java.io.ObjectOutputStream;

import model.PizzaConfig;
import wrapper.PizzaConfigAPI;

public class GetOneProtocol extends Protocol
{

    private String pizzeriaName;

    public GetOneProtocol(String _pizzeriaName)
    {
        pizzeriaName = _pizzeriaName;
    }

    @Override
    public void executeProtocol(ObjectOutputStream out)
    {
        try
        {
            PizzaConfig config = getServer().getPizzeria(pizzeriaName);
            out.writeObject(config);
        } catch (Exception e)
        {
            System.out.println("Error getting one pizzeria ---->" + e.getMessage());
        }

    }

}
