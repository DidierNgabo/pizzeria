/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/
package exceptions;

public class NotFoundException extends CustomException
{

    public NotFoundException(String n,boolean d)
    {
        super(n);
        this.setDebugAllowed(d);
    }

    @Override
    public void fix()
    {
       log(name+" not found please try again!!!");
        
    }

}
