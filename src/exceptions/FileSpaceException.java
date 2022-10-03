/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package exceptions;

public class FileSpaceException extends CustomException
{

    public FileSpaceException(String n,boolean debug)
    {
        super(n);
        this.setDebugAllowed(debug);
    }
    
    @Override
    public void fix()
    {

        String[] filename = name.split(" ");
        StringBuilder builder= new StringBuilder();
        for(String path:filename)
          {
              builder.append(path);
          }
        System.out.println("----> builder name "+builder.toString());
        this.setName(builder.toString());
        log("File found after removing white space"); 
    }

}
