/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package wrapper;

public interface UpdatePizzeria
{
    void updateBasePrice(String pizzeriaName,double newPrice);
    void updateOptionSetName(String name,String optionSetName,String newName);
    void updateOptionPrice(String pizzeriaName,String optionName,String option,double newPrice);
}
