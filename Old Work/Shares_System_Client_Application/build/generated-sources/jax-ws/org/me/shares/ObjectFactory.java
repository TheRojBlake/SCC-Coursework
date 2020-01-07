
package org.me.shares;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.me.shares package. 
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

    private final static QName _PrintShares_QNAME = new QName("http://shares.me.org/", "Print_Shares");
    private final static QName _PrintSharesResponse_QNAME = new QName("http://shares.me.org/", "Print_SharesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.me.shares
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PrintShares }
     * 
     */
    public PrintShares createPrintShares() {
        return new PrintShares();
    }

    /**
     * Create an instance of {@link PrintSharesResponse }
     * 
     */
    public PrintSharesResponse createPrintSharesResponse() {
        return new PrintSharesResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintShares }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shares.me.org/", name = "Print_Shares")
    public JAXBElement<PrintShares> createPrintShares(PrintShares value) {
        return new JAXBElement<PrintShares>(_PrintShares_QNAME, PrintShares.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintSharesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shares.me.org/", name = "Print_SharesResponse")
    public JAXBElement<PrintSharesResponse> createPrintSharesResponse(PrintSharesResponse value) {
        return new JAXBElement<PrintSharesResponse>(_PrintSharesResponse_QNAME, PrintSharesResponse.class, null, value);
    }

}
