/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package protocol;

import java.io.ObjectOutputStream;
import java.util.List;

import wrapper.PizzaConfigAPI;

public class GetAllProtocol extends Protocol
{

    @Override
    public void executeProtocol(ObjectOutputStream out)
    {
        try
        {
            List<String> pizzerias = getServer().getAllPizzerias();
            out.writeObject(pizzerias);
        } catch (Exception e)
        {
            System.out.println("Error getting all pizzerias ---->" + e.getMessage());
        }

    }

}
