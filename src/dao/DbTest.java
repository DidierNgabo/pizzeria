package dao;

import java.util.List;

import model.DeliveryMode;
import model.PizzaConfig;
import model.Size;

public class DbTest
{
    public static void main(String[] args)
    {
        PizzeriaDao pizzeriaDao= new PizzeriaDao();
        
        pizzeriaDao.createTable();
        // pizzeriaDao.create("CMU's Pies", 2000, Size.SMALL.name(), DeliveryMode.EATIN.name());
        
        List<PizzaConfig> pizzerias =  pizzeriaDao.findAll();
        
        pizzerias.forEach(config -> config.print());
    }
}
