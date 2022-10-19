/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import protocol.ProtocalHandler;
import protocol.Protocol;
import protocol.ProtocolFactory;
import protocol.RequestObj;
import wrapper.PizzaConfigAPI;

public class ClientHandler extends Thread
{
    static int clientNumber = 0;

    PizzaConfigAPI api = MainServer.api;
    RequestObj req;

    Socket clientSocket;
    
    public ClientHandler(Socket _clientSocket) throws IOException
    {
        clientSocket = _clientSocket;
        clientNumber++;
        setName("Client " + clientNumber);
    }

    public void run()
    {
        try
        (
            ObjectInputStream  in = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream  out = new ObjectOutputStream(clientSocket.getOutputStream());
        )
        {
            while((req = (RequestObj) in.readObject()) !=null) {
                Protocol p = ProtocolFactory.createProtocol(req);
                ProtocalHandler ph = new ProtocalHandler(p, out);
                ph.executeStrategy(); 
            }
            System.out.println("Server finished handling " + Thread.currentThread().getName());
        } catch (IOException | ClassNotFoundException e)
        {
            System.err.println("Exception caught when trying to read requests");
            System.err.println(e.getMessage());
        }
    }

}
