/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package test;

public class PizzeriaTestDriver
{
   
    public static void main(String[] args)
    {
        PizzaTester tester;
        
        tester =new CreatingPizzeriaTest(); 
        tester.executeTest();
        
        tester =new DuplicatingPizzeriaTest(); 
        tester.executeTest();
        
        tester =new CreateNameMissingPizzeriaTest(); 
        tester.executeTest();
        
        tester =new AddingOptionSetPizzeriaTest(); 
        tester.executeTest();
        
        tester =new DuplicatingOptionSetPizzeriaTest(); 
        tester.executeTest();
        
        tester =new AddingOptionPizzeriaTest(); 
        tester.executeTest();
        
        tester =new DuplicatingOptionPizzeriaTest(); 
        tester.executeTest();
        
        tester =new UpdatingBasePricePizzeriaTest(); 
        tester.executeTest();
        
        tester =new UpdatingOptionSetNamePizzeriaTest(); 
        tester.executeTest();
        
        tester =new ConfigurePizzeriaTest(); 
        tester.executeTest();
    }
}
