package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UIDriver
{
 public static void main(String[] args)
 {
     try
    {
         int choice; 
         BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));        
             
             while(true)
             {
                 System.out.println("-----------------------------------------");
                 System.out.println("Choose an option");
                 System.out.println("-----------------------------------------");
                 System.out.println("1.Upload a Properties file");
                 System.out.println("2.Show available pizzeiras");
                 System.out.println("3.print a pizzeria");
                 System.out.println("4.Delete a pizzeria");
                 System.out.println("5.Configure pizzeria");
               
                 
                 choice = Integer.parseInt(keyboard.readLine());
                 switch (choice)
                {
                case 1:
                {
                    
                    System.out.println("Option 1");
                    break;
                }
                case 2:
                {
                    
                    System.out.println("Option 2");
                    break;
                }
                case 3:
                {
                    
                    System.out.println("Option 3");
                    break;
                }
                case 4:
                {
                    
                    System.out.println("Option 4");
                    break;
                }
                case 5:
                {
                    
                    System.out.println("Option 5");
                    break;
                }
                case 0:
                {
                    
                    System.exit(0);
                    break;
                }
                default:
                    throw new IllegalArgumentException("Unexpected value: " + choice);
                }
                 
                 System.out.println("choose an option 1-5:");
                 choice = Integer.parseInt(keyboard.readLine());
                 
             }
              
         
    } catch (Exception e)
    {
        System.out.println(e.getMessage());
    }
     
 }

}