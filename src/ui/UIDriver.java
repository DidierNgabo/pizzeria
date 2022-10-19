/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import client.Client;

public class UIDriver
{
  
 public static void handleConfigure(Client client)
 {
     try
    {
         BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
         List<String> pizzerias = client.getAllPizzerias();
         if(!pizzerias.isEmpty())
         {
             for (String pizzeria : pizzerias)
            {
                System.out.println(pizzeria);
            }
         }
         else {
             System.out.println("There are no available pizzerias");
         }
         System.out.println("1.Update baseprice \n2.add option \n0.Exit");
        int choice = Integer.parseInt(keyboard.readLine());
        switch (choice)
        {
        case 1:
        {
            System.out.print("Enter pizzeria name:");
            String name = keyboard.readLine();
            client.printPizzeria(name);
            System.out.print("Enter new base price:");
            Double price = Double.parseDouble(keyboard.readLine());
            System.out.println(client.updateBasePrice(name,price));
            break;
        }
        case 2:
        {
            System.out.print("Enter pizzeria name:");
            String name = keyboard.readLine();
            client.printPizzeria(name);
            System.out.print("Choose Option set:");
            String optionSetName = keyboard.readLine();
            System.out.print("Enter new option name:");
            String option= keyboard.readLine();
            System.out.print("Enter new base price:");
            Double price = Double.parseDouble(keyboard.readLine());
            System.out.println(client.addOption(name,optionSetName,option,price));
            break;
        }
        default:
            System.out.println("Unexpected value: " + choice);
        }
    } catch (Exception e)
    {
       System.out.println(e.getMessage());
    }
     
 }
 public static void main(String[] args)
 {
     try
    {
         Client client = new Client("localhost",6000);
         int choice=1; 
         BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
             
             while(choice != 0)
             {
                 System.out.println("-----------------------------------------");
                 System.out.println("welcome to Pizzeria App");
                 System.out.println("Choose an option");
                 System.out.println("-----------------------------------------");
                 System.out.println("1.Upload a Properties file\n2.Show available pizzerias\n3.Print a pizzeria\n4.delete a pizzeria\n5.Configure pizzeria\n0.Exit");
                 System.out.print("choose an option 0-5:");
                 choice = Integer.parseInt(keyboard.readLine());
                 switch (choice)
                {
                case 1:
                {
                    System.out.println("choose filename");
                    String filename = keyboard.readLine(); 
                    client.loadProperties(filename);
                    break;
                }
                case 2:
                {
                    
                    if(!client.getAllPizzerias().isEmpty())
                    {
                        for(String name:client.getAllPizzerias())
                        {
                            System.out.println(name);
                        }
                    }
                    else
                    {
                        System.out.println("No available pizzerias");
                    }
                   
                    break;
                }
                case 3:
                {
                    
                    System.out.print("Enter pizzeria name:");
                    String name = keyboard.readLine(); 
                    client.printPizzeria(name);
                    break;
                }
                case 4:
                {
                    
                    System.out.print("Enter pizzeria name:");
                    String name = keyboard.readLine(); 
                    System.out.println(client.deletePizzeria(name));
                    break;
                }
                case 5:
                {
                    handleConfigure(client);
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
             }
              
         
    } catch (Exception e)
    {
        System.out.println(e.getMessage());
    }
     
 }

}