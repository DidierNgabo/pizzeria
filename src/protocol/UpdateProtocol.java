/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/
package protocol;

import java.io.ObjectOutputStream;

import wrapper.PizzaConfigAPI;

public class UpdateProtocol extends Protocol
{

    private String pizzeria;
    private double basePrice;

    public UpdateProtocol(String _pizzeria, double _basePrice)
    {
        pizzeria = _pizzeria;
        basePrice = _basePrice;
    }

    @Override
    public void executeProtocol(ObjectOutputStream out)
    {
        try
        {
            String updated = getServer().updateBasePrice(pizzeria, basePrice);
            out.writeObject(updated);
        } catch (Exception e)
        {
            System.out.println("Error updating base price ---->" + e.getMessage());
        }

    }
}
