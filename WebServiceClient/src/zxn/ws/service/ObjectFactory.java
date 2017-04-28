
package zxn.ws.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the zxn.ws.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Regedit_QNAME = new QName("http://service.ws.zxn/", "regedit");
    private final static QName _RegeditResponse_QNAME = new QName("http://service.ws.zxn/", "regeditResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: zxn.ws.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Regedit }
     * 
     */
    public Regedit createRegedit() {
        return new Regedit();
    }

    /**
     * Create an instance of {@link RegeditResponse }
     * 
     */
    public RegeditResponse createRegeditResponse() {
        return new RegeditResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Regedit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.zxn/", name = "regedit")
    public JAXBElement<Regedit> createRegedit(Regedit value) {
        return new JAXBElement<Regedit>(_Regedit_QNAME, Regedit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegeditResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.zxn/", name = "regeditResponse")
    public JAXBElement<RegeditResponse> createRegeditResponse(RegeditResponse value) {
        return new JAXBElement<RegeditResponse>(_RegeditResponse_QNAME, RegeditResponse.class, null, value);
    }

}
