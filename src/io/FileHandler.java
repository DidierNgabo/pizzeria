package io;

import java.io.BufferedReader;
import java.io.FileReader;

import model.PizzaConfig;

public class FileHandler
{
    
    
    public static PizzaConfig buildPizzaConfig(String filename)
    {
        try
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
            
            config.print();
            return config;
        } catch (Exception e)
        {
            System.out.println("Error " + e.toString());
            return null;
        }
      
    }
}
