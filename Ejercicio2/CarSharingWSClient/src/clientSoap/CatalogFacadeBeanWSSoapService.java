
package clientSoap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CatalogFacadeBeanWSSoapService", targetNamespace = "http://ejb/", wsdlLocation = "http://localhost:8080/PracticalCaseWSSoap/WSCatalogSoap?wsdl")
public class CatalogFacadeBeanWSSoapService
    extends Service
{

    private final static URL CATALOGFACADEBEANWSSOAPSERVICE_WSDL_LOCATION;
    private final static WebServiceException CATALOGFACADEBEANWSSOAPSERVICE_EXCEPTION;
    private final static QName CATALOGFACADEBEANWSSOAPSERVICE_QNAME = new QName("http://ejb/", "CatalogFacadeBeanWSSoapService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/PracticalCaseWSSoap/WSCatalogSoap?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CATALOGFACADEBEANWSSOAPSERVICE_WSDL_LOCATION = url;
        CATALOGFACADEBEANWSSOAPSERVICE_EXCEPTION = e;
    }

    public CatalogFacadeBeanWSSoapService() {
        super(__getWsdlLocation(), CATALOGFACADEBEANWSSOAPSERVICE_QNAME);
    }

    public CatalogFacadeBeanWSSoapService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CATALOGFACADEBEANWSSOAPSERVICE_QNAME, features);
    }

    public CatalogFacadeBeanWSSoapService(URL wsdlLocation) {
        super(wsdlLocation, CATALOGFACADEBEANWSSOAPSERVICE_QNAME);
    }

    public CatalogFacadeBeanWSSoapService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CATALOGFACADEBEANWSSOAPSERVICE_QNAME, features);
    }

    public CatalogFacadeBeanWSSoapService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CatalogFacadeBeanWSSoapService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CatalogFacadeRemoteWSSoap
     */
    @WebEndpoint(name = "WSCatalogSoapPort")
    public CatalogFacadeRemoteWSSoap getWSCatalogSoapPort() {
        return super.getPort(new QName("http://ejb/", "WSCatalogSoapPort"), CatalogFacadeRemoteWSSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CatalogFacadeRemoteWSSoap
     */
    @WebEndpoint(name = "WSCatalogSoapPort")
    public CatalogFacadeRemoteWSSoap getWSCatalogSoapPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ejb/", "WSCatalogSoapPort"), CatalogFacadeRemoteWSSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CATALOGFACADEBEANWSSOAPSERVICE_EXCEPTION!= null) {
            throw CATALOGFACADEBEANWSSOAPSERVICE_EXCEPTION;
        }
        return CATALOGFACADEBEANWSSOAPSERVICE_WSDL_LOCATION;
    }

}
