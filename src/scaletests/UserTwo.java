package scaletests;

import wrapper.CreatePizzeria;
import wrapper.UpdatePizzeria;

public class UserTwo extends SimulatedUser
{
    UpdatePizzeria api;

    public UserTwo(UpdatePizzeria _api)
    {
        api = _api;
    }
    
    @Override
    public void run()
    {
       try 
       {
          System.out.println("----------"+Thread.currentThread().getName()+"--------------");
         Thread.currentThread().sleep(5000);
         api.updateBasePrice("Diddy's Pizza", 0);
         System.out.println("----------"+Thread.currentThread().getName()+"--------------");
       }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
