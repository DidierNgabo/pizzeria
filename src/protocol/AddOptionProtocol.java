/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/
package protocol;

import java.io.ObjectOutputStream;

public class AddOptionProtocol extends Protocol
{

    private String pizzeriaName;
    private String optionSetName;
    private String option;
    private Double price;

    public AddOptionProtocol(String _pizzeriaName, String _optionSetName, String _option, Double _price)
    {

        pizzeriaName = _pizzeriaName;
        optionSetName = _optionSetName;
        option = _option;
        price = _price;
    }

    @Override
    public void executeProtocol(ObjectOutputStream out)
    {
        try
        {
            String message = getServer().addOption(pizzeriaName, optionSetName, option, price);
            out.writeObject(message);
        } catch (Exception e)
        {
            System.out.println("Error adding new option " + e.getMessage());
        }
    }
}
