/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package scaletests;

import java.util.concurrent.*;

import wrapper.CreatePizzeria;
import wrapper.PizzaConfigAPI;
import wrapper.UpdatePizzeria;

public class ScaleTestDriver
{
    public static void main(String[] args)
    {
        
        PizzaConfigAPI api=new PizzaConfigAPI();
        
        CreatePizzeria createPizzeria = api;
        UpdatePizzeria updatePizzeria = api;
        
        SimulatedUser user1 = new ConfiguringUser(createPizzeria);
        SimulatedUser user3 = new PrintingPizzeria(createPizzeria);
        SimulatedUser user2 = new DeletingPizzeria(createPizzeria);
        
        
       /***
        * 
        * running test without threadpool
        * 
        ***/
        Thread thread1 = new Thread(user1, "user1 without threadpool");
        Thread thread2 = new Thread(user2, "user2 without threadpool");

        thread1.start();
        thread2.start();

        
        
        /***
         * 
         * running test with threadpool
         * 
         ***/
        ThreadPoolHandler.runThread(user1, user3, user2);
        
       
       
    }
}
