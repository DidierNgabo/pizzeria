/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/
package test;

import wrapper.*;
import model.*;
public class TestDriver
{
    public static void main(String[] args)
    {
       PizzaTester pizzaTest;
       
       
       pizzaTest= new AddingOptionTest();
       pizzaTest.executeTest();
        
       pizzaTest= new DeleteOptionTest();
       pizzaTest.executeTest();
        
       pizzaTest= new DeleteChoiceTest();
       pizzaTest.executeTest();
        
       pizzaTest= new AddingChoiceTest();
       pizzaTest.executeTest();
        
       pizzaTest= new UpdateOptionTest();
       pizzaTest.executeTest();       
       pizzaTest= new FindChoiceTest();
       pizzaTest.executeTest();       
       pizzaTest= new UpdateChoiceTest();
       pizzaTest.executeTest();
    }
}
