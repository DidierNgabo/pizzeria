/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Properties;

import com.sun.net.httpserver.Request;

import helpers.ProtocolMapper;
import model.PizzaConfig;
import protocol.LoadPropertiesProtocol;
import protocol.Protocol;
import protocol.RequestObj;
import wrapper.CreatePizzeria;
import wrapper.PizzaConfigAPI;
import wrapper.UpdatePizzeria;

public class Client implements PizzeriaClient
{
    PizzaConfigAPI api = new PizzaConfigAPI();

    CreatePizzeria createApi = api;

    UpdatePizzeria updateApi = api;

    private Socket socket;

    private ObjectInputStream input;
    private ObjectOutputStream out;
    
    public Client(String address, int port) throws IOException
    {
        socket = new Socket(address,port);
        out = new ObjectOutputStream(socket.getOutputStream());
        input =  new ObjectInputStream(socket.getInputStream());
        
    }

    public Object getConnection(RequestObj req)
    {
        Object res;

        try
        {
            out.writeObject(req);
            while((res = input.readObject()) != null )
            {
                return res;
            }
          
        } catch (UnknownHostException | ClassNotFoundException u)
        {
            System.out.println(u);
        } catch (IOException i)
        {
            System.out.println(i);
        }
        return null;
    }

    @Override
    public void loadProperties(String filename)
    {
        try
        {
            Properties props = new Properties();
            FileInputStream in = new FileInputStream(filename);
            props.load(in);
            RequestObj req =   new RequestObj(ProtocolMapper.LOAD_PROPERTIES, props);
            Boolean response = (Boolean) getConnection(req);
            
//            Boolean response =  input.readObject();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<String> getAllPizzerias()
    {
        try
        {
            RequestObj req =  new RequestObj(ProtocolMapper.GET_ALL_PIZZERIAS);
            List<String> pizzerias = (List<String>) getConnection(req);
            return pizzerias;
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String deletePizzeria(String name)
    {
        try
        {
            RequestObj req = new RequestObj(ProtocolMapper.DELETE, name);
            String response = (String) getConnection(req);
            return response;
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return "";

        }
    }

    @Override
    public String addOption(String pizzeriaName, String optionSetName, String option, double price)
    {
        try
        {
            RequestObj req = new RequestObj(ProtocolMapper.ADD_OPTION, pizzeriaName, optionSetName, option, price);
            String response = (String) getConnection(req);
            return response;
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return "";
        }
    }

    @Override
    public String updateBasePrice(String name, double newPrice)
    {

        try
        {
            RequestObj req = new RequestObj(ProtocolMapper.UPDATE_PRICE, name, newPrice);
            String message = (String) getConnection(req);
            return message;
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return "";
        }
    }

    @Override
    public PizzaConfig getPizzeria(String name)
    {
        try
        {
            RequestObj req = new RequestObj(ProtocolMapper.PRINT, name);
            PizzaConfig config = (PizzaConfig) getConnection(req);
            return config;
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void printPizzeria(String name)
    {
        try
        {
            RequestObj req = new RequestObj(ProtocolMapper.PRINT, name);
            PizzaConfig config = (PizzaConfig) getConnection(req);
            config.print();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
