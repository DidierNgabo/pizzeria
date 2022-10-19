package dbWrapper;

import java.util.List;

import model.PizzaConfig;

public interface CreatePizzeria
{
    public Boolean savePizzeria(PizzaConfig config);
    public Boolean saveOrder();
    public List<PizzaConfig> listAllPizzerias();
    public List<PizzaConfig> listAllOrders();
}
