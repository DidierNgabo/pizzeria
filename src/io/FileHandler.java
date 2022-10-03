/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import exceptions.CustomException;
import model.PizzaConfig;

public class FileHandler
{
    
    
    public  PizzaConfig buildPizzaConfig(String filename) throws IOException
    
    {
       
            PizzaConfig config = new PizzaConfig();
            FileReader file = new FileReader(filename);
            BufferedReader buff = new BufferedReader(file);
            String line;

            line = buff.readLine();
            while (line != null)
            {
                if(line.startsWith("$"))
                {
                    String conf = line.substring(1);
                    String name = conf.split(",")[0];
                    String price = conf.split(",")[1];
                    config.setName(name);
                    config.setBasePrice(Double.parseDouble(price));
                }
                
                if(line.startsWith("*"))
                {
                    String optionSet = line.substring(1);
                    config.addOptionSet(optionSet);
                }
                
                if(line.startsWith("#"))
                {
                    String conf = line.substring(1);
                    String optionSet = conf.split(":")[0];
                    String option=conf.split(":")[1];
                    config.addOption(optionSet,option.split(",")[0],Double.parseDouble(option.split(",")[1]));
                }
                line = buff.readLine();
            }
            buff.close();
            
            //config.print();
            return config;
      
    }
}
