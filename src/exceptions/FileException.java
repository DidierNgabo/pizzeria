/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package exceptions;

public class FileException extends CustomException
{
    public FileException(String n,boolean debug)
    {
        super(n);
        this.setDebugAllowed(debug);
    }
    
    @Override
    public void fix()
    {

        String[] filename = name.split("/");
        this.setName(filename[1]);      
        log("File found in the parent directory"); 
    }
}
