/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/
package protocol;

import java.io.ObjectOutputStream;
import java.util.Properties;

import wrapper.PizzaConfigAPI;

public class LoadPropertiesProtocol extends Protocol
{

    private Properties props;

    public LoadPropertiesProtocol(Properties _props)
    {
        props = _props;
    }

    public Properties getProps()
    {
        return props;
    }

    @Override
    public void executeProtocol(ObjectOutputStream out)
    {
        try
        {
            Boolean loaded = getServer().loadProperties(props);
            out.writeObject(loaded);
        } catch (Exception e)
        {
            System.out.println("Error loading properties file ---->" + e.getMessage());
        }

    }

}
