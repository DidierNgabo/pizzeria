/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/
package scaletests;

import wrapper.CreatePizzeria;
import wrapper.DeletePizzeria;
import wrapper.UpdatePizzeria;

public class DeletingPizzeria extends SimulatedUser
{
CreatePizzeria api;
    
    public DeletingPizzeria(CreatePizzeria _api)
    {
        api = _api;
    }

    @Override
    public void run() {
        System.out.println("========> current thread "+Thread.currentThread().getName()+"=========");
        api.deletePizzeria("Diddy's Pizza");
        System.out.println("-----------> End of thread:"+Thread.currentThread().getName()+"-----------------------------");
    }
}
