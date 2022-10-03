/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package scaletests;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolHandler
{
    public static void runThread(SimulatedUser firstUser,SimulatedUser secondUser,SimulatedUser thirdUser)
    {
ExecutorService threadPool = Executors.newFixedThreadPool(3);
        
        
        for (int i = 0; i < 10; i++)
        {
            threadPool.execute(new Thread(firstUser, "user1"));
            threadPool.execute( new Thread(secondUser, "user2")); 
            threadPool.execute(new Thread(thirdUser, "user3")); 
            
        }
        threadPool.shutdown();
        
        while (!threadPool.isTerminated())
        {
            SimulatedUser.pause(1000);
        }
        System.out.println("main Ending");
    }
}
