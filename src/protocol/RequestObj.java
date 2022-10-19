/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package protocol;

import java.io.Serializable;
import java.util.Properties;

import helpers.ProtocolMapper;

public class RequestObj  implements Serializable
{
    private ProtocolMapper mapper;
    private String pizzeriaName;
    private String optionName;
    private Double price;
    private String optionSetName;
    private Properties props;

    public RequestObj(ProtocolMapper _mapper)
    {
        mapper = _mapper;
    }

    public RequestObj(ProtocolMapper _mapper, String _pizzeriaName)
    {
        mapper = _mapper;
        pizzeriaName = _pizzeriaName;
    }

    public RequestObj(ProtocolMapper _mapper, Properties _props)
    {
        mapper = _mapper;
        props = _props;
    }

    public RequestObj(ProtocolMapper _mapper, String _pizzeriaName, Double _price)
    {
        mapper = _mapper;
        pizzeriaName = _pizzeriaName;
        price = _price;
    }

    public RequestObj(ProtocolMapper _mapper, String _pizzeriaName, String _optionSetName, String option, double _price)
    {
        mapper = _mapper;
        pizzeriaName = _pizzeriaName;
        optionSetName = _optionSetName;
        optionName = option;
        price = _price;
    }

    public String getPizzeriaName()
    {
        return pizzeriaName;
    }

    public Properties getProps()
    {
        return props;
    }

    public String getOptionName()
    {
        return optionName;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public String getOptionSetName()
    {
        return optionSetName;
    }

    public ProtocolMapper getMapper()
    {
        return mapper;
    }

}
