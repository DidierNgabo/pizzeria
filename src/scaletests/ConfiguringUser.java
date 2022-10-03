/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/
package scaletests;

import wrapper.CreatePizzeria;

public class ConfiguringUser extends SimulatedUser
{
    CreatePizzeria api;
    public ConfiguringUser(CreatePizzeria _api)
    {
         api = _api;
    }
     @Override
     public void run() {
         System.out.println("========> current thread "+Thread.currentThread().getName()+"=========");
         api.configurePizzeria("pizza conf.txt");
         api.configurePizzeria("src/pizzaconf.txt");
         System.out.println("-----------> End of thread:"+Thread.currentThread().getName()+"-----------------------------");
     }
  
}
