/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package test;

public class CreateConfigTest extends PizzaTester
{
    
    CreateConfigTest()
    {
        super("Brioche ",6000,"Small","TA");
    }
  
    public void executeTest()
    {
        this.setLabel("======== Creating pizza config test =========");
        System.out.println(this.getLabel());
        serialize();
        deserialize();
    }
  
}
