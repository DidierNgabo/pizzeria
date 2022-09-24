package exceptions;

import java.io.File;
import java.io.FileNotFoundException;

public class FileException extends CustomException
{

    public FileException(String n)
    {
        super(n);
    }
    
    @Override
    public void fix()
    {
            File file =new File(name);
            String parentDir = file.getParentFile().getName();
            boolean fileExists = new File(parentDir, name).exists();
            if(!fileExists)
                System.out.println("working");
            
              log("Pizzeria name created with a new Name "+this.getName());
        
    }

}
