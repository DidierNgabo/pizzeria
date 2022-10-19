
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

public class ProtocalHandler
{
    private Protocol protocol;

    private ObjectOutputStream out;

    public ProtocalHandler(Protocol _protocol, ObjectOutputStream _out)
    {
        protocol = _protocol;
        out = _out;
    }

    public void executeStrategy()
    {
        protocol.executeProtocol(out);
    }

}
