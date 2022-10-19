/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package server;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import wrapper.CreatePizzeria;
import wrapper.PizzaConfigAPI;
import wrapper.UpdatePizzeria;

public class MainServer
{
    static boolean keepRunning = true;
    public static PizzaConfigAPI  api;
    public static void main(String args[])
    {
        int             portNumber=6000;
        int             acceptTimeout = -1;
        ServerSocket    socket = null;

         Socket          clientSocket;
        ClientHandler   clientHandler;
        
        api = new PizzaConfigAPI();
        
//        if (args.length != 1)
//        {
//            System.err.println("Usage: java KnockKnockServer <port number>");
//            System.exit(1);
//        }
//
//        portNumber = Integer.parseInt(args[0]);
//        
        if ((socket = openSocket(portNumber, acceptTimeout)) == null)
            System.exit(2);
        
        try
        {
            System.out.println("Timeout: " + socket.getSoTimeout());
        } catch (IOException e1)
        {
            e1.printStackTrace();
        }
        

        try
        {
            while (keepRunning)
            {
                clientSocket = acceptConnection(socket);
                if (clientSocket != null)
                {
                    clientHandler = new ClientHandler(clientSocket);
                    clientHandler.start();
                    System.out.println("Server now handling " + clientHandler.getName());
                }
            } 
            System.out.println("The Server is ending.");
        }
        catch (IOException e)
        {
            System.out.println(
                    "Exception caught when trying to listen on port " + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
        
    }
    
    private static ServerSocket openSocket(int portNumber, int acceptTimeout)
    {
        ServerSocket    socket = null;
        try
        {
            socket = new ServerSocket(portNumber);
            if (acceptTimeout > 0)
                socket.setSoTimeout(acceptTimeout);
        }
        catch (BindException e)
        {
            System.err.println("Server cannot bind to port " + portNumber);
            System.err.println(e);
            System.exit(3);
        }
        catch (Exception e)
        {
            System.err.println("Server caught exception when trying to create socket ");
            System.err.println(e);
        }

        return socket;
    }

    private static Socket acceptConnection(ServerSocket socket)
    {
        try
        {
            // blocked on an I/O until a connection is made

            Socket clientSocket = socket.accept();     
            System.out.println("Server connected to " + clientSocket);
            return clientSocket;
        }
        catch (SocketTimeoutException e)
        {
            System.out.println("Server timed out waiting for a connection.");
        }
        catch (IOException e)
        {
            System.err.println("Server caught exception when trying to listen on port "
                + socket.getLocalPort() );
            System.err.println(e);
        }
        return null;
    }
}
