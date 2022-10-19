/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/
package protocol;

import helpers.ProtocolMapper;

public class ProtocolFactory
{
    public static Protocol createProtocol(RequestObj req)
    {
        Protocol p = null;
        if (req.getMapper() == ProtocolMapper.GET_ALL_PIZZERIAS)
        {
            p = new GetAllProtocol();
        }

        if (req.getMapper() == ProtocolMapper.PRINT)
        {
            p = new GetOneProtocol(req.getPizzeriaName());
        }

        if (req.getMapper() == ProtocolMapper.UPDATE_PRICE)
        {
            p = new UpdateProtocol(req.getPizzeriaName(), req.getPrice());
        }

        if (req.getMapper() == ProtocolMapper.LOAD_PROPERTIES)
        {
            p = new LoadPropertiesProtocol(req.getProps());
        }

        if (req.getMapper() == ProtocolMapper.DELETE)
        {
            p = new DeleteProtocol(req.getPizzeriaName());
        }

        if (req.getMapper() == ProtocolMapper.ADD_OPTION)
        {
            p = new AddOptionProtocol(req.getPizzeriaName(), req.getOptionSetName(), req.getOptionName(),
                    req.getPrice());
        }
        return p;
    }
}
