package scaletests;

import wrapper.CreatePizzeria;
import wrapper.PizzaConfigAPI;
import wrapper.UpdatePizzeria;

public class ScaleTestDriver
{
    public static void main(String[] args)
    {
        
        PizzaConfigAPI api= new PizzaConfigAPI();
        
        CreatePizzeria createApi = api;
        
        UpdatePizzeria updateApi = api;
        SimulatedUser user1=new UserOne(createApi);
        
        SimulatedUser user2=new UserOne(createApi);
//        SimulatedUser user3=new UserTwo(updateApi);
        SimulatedUser user4=new UserThree(createApi);
        SimulatedUser user5=new UserOne(createApi);
        SimulatedUser user6=new UserOne(createApi);
        
         
        new Thread(user1,"1").start();
        new Thread(user2,"2").start();
        
//        new Thread(user3,"3").start();
        new Thread(user4,"4").start();
        new Thread(user5,"5").start();
        new Thread(user6,"6").start();
       
    }
}
