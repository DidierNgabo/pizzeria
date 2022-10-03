/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package scaletests;

import wrapper.CreatePizzeria;

public class PrintingPizzeria extends SimulatedUser
{
    CreatePizzeria api;
    public PrintingPizzeria(CreatePizzeria _api)
       {
            api = _api;
       }
    @Override
    public void run() {
        
        System.out.println("========> current thread "+Thread.currentThread().getName()+"=========");
        System.out.println("-------> "+Thread.currentThread().getName());
        api.printPizzerias();
        System.out.println("-----------> End of thread:"+Thread.currentThread().getName()+"-----------------------------");
    }
}
