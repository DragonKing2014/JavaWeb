package zxn.ws.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.11
 * 2017-04-28T10:41:16.740+08:00
 * Generated source version: 3.1.11
 * 
 */
@WebService(targetNamespace = "http://service.ws.zxn/", name = "RegeditService")
@XmlSeeAlso({ObjectFactory.class})
public interface RegeditService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "regedit", targetNamespace = "http://service.ws.zxn/", className = "zxn.ws.service.Regedit")
    @WebMethod
    @ResponseWrapper(localName = "regeditResponse", targetNamespace = "http://service.ws.zxn/", className = "zxn.ws.service.RegeditResponse")
    public java.lang.String regedit(
        @WebParam(name = "username", targetNamespace = "")
        java.lang.String username,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password
    );
}