package dbWrapper;

import java.util.List;

import dao.PizzeriaDao;
import exceptions.CustomException;
import exceptions.ExceptionFactory;
import helpers.ExceptionMapper;
import model.PizzaConfig;

public class DBProxyPizzeria
{
    PizzeriaDao pizzeriaDao = new PizzeriaDao();

    public Boolean savePizzeria(PizzaConfig config)
    {
        try
        {
            if (config.getName().isBlank())
            {

                throw ExceptionFactory.createException(ExceptionMapper.NAMEMISSING, config, true);
            }

            if (checkExists(config.getName()))
            {
                throw ExceptionFactory.createException(ExceptionMapper.PIZZERIAEXISTS, config, true);
            }

            return pizzeriaDao.create(config);

        } catch (CustomException e)
        {
            e.fix();
            return pizzeriaDao.create(config);
        }
    }

    public Boolean checkExists(String name)
    {
        try
        {
            PizzaConfig config = pizzeriaDao.findOne(name);
            if (config != null)
            {
                return true;
            }
            return false;
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean saveOrder()
    {
        return true;
    }

    public Boolean deletePizzeria(String name)
    {
        if (checkExists(name))
        {

            return pizzeriaDao.delete(name);
        }
        return null;
    }

    public Boolean deleteOrder()
    {
        return true;
    }

    public Boolean updatePizzeria(String name, double price)
    {
        PizzaConfig config = pizzeriaDao.findOne(name);
        try
        {
            if (price == 0)
            {
                throw ExceptionFactory.createException(ExceptionMapper.PRICEMISSING, config, true);
            }
            if (config != null)
            {
                return pizzeriaDao.update(name, price);
            }

            return false;
        } catch (CustomException e)
        {
            e.fix();

            if (config != null)
            {

                return pizzeriaDao.update(name, price);
            }

        }
        return false;
    }

    public Boolean updateOrder()
    {
        return true;
    }

    public List<PizzaConfig> listAllPizzerias()
    {
        return pizzeriaDao.findAll();
    }

    public List<PizzaConfig> listAllOrders()
    {
        return null;
    }

}
