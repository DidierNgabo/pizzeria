package scaletests;

import wrapper.CreatePizzeria;

public class UserThree extends SimulatedUser
{
    CreatePizzeria api;

    public UserThree(CreatePizzeria _api)
    {
        api = _api;
    }
    
    @Override
    public void run()
    {
        System.out.println("----------"+Thread.currentThread().getName()+"--------------");
       api.printPizzerias();
       System.out.println("----------"+Thread.currentThread().getName()+"--------------");
    }
}
