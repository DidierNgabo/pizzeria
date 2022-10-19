/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/
package protocol;

import java.io.ObjectOutputStream;

public class DeleteProtocol extends Protocol
{

    private String pizzeriaName;

    public DeleteProtocol(String _pizzeriaName)
    {
        pizzeriaName = _pizzeriaName;
    }

    @Override
    public void executeProtocol(ObjectOutputStream out)
    {
        try
        {
            String message = getServer().deletePizzeria(pizzeriaName);
            out.writeObject(message);
        } catch (Exception e)
        {
            System.out.println("Error Deleting pizzeria ---->" + e.getMessage());
        }

    }

}
