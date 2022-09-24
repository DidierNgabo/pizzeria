package scaletests;

import wrapper.CreatePizzeria;

public class UserOne extends SimulatedUser
{
  CreatePizzeria api;

  public UserOne(CreatePizzeria _api)
  {
      api = _api;
  }
  
  @Override
  public void run()
  {
     try
     {
         System.out.println("----------"+Thread.currentThread().getName()+"--------------");
         Thread.currentThread().sleep(1000);
         api.configurePizzeria("pizzaconf.txt");
         System.out.println("----------"+Thread.currentThread().getName()+"--------------");
     }
     catch(Exception e)
     {
         e.printStackTrace();
     }
   
  }
  
}
