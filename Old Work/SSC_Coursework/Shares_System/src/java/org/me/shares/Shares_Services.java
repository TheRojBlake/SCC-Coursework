package org.me.shares;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

@WebService(serviceName = "Shares_Services")
@Stateless()
public class Shares_Services
{
    /**
     * Web service operation
     */
    @WebMethod(operationName = "Print_Shares")
    public String Print_Shares()
    {
        
        return null;
    }
}
