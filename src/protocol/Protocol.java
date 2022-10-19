/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package protocol;

import java.io.ObjectOutputStream;
import java.io.Serializable;

import server.MainServer;
import server.PizzeriaServer;
import wrapper.PizzaConfigAPI;

public abstract class Protocol
{
    private PizzaConfigAPI api = MainServer.api;

    private PizzeriaServer server = new PizzeriaServer(api);

    public PizzeriaServer getServer()
    {
        return server;
    }

    public abstract void executeProtocol(ObjectOutputStream out);

}
