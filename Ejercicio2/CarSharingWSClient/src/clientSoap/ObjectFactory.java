
package clientSoap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the clientSoap package. 
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

    private final static QName _ListCarsByDriverResponse_QNAME = new QName("http://ejb/", "listCarsByDriverResponse");
    private final static QName _ShowCar_QNAME = new QName("http://ejb/", "showCar");
    private final static QName _RemoveCarResponse_QNAME = new QName("http://ejb/", "removeCarResponse");
    private final static QName _ShowDriver_QNAME = new QName("http://ejb/", "showDriver");
    private final static QName _ListAllDriversResponse_QNAME = new QName("http://ejb/", "listAllDriversResponse");
    private final static QName _GetLastCarIndexResponse_QNAME = new QName("http://ejb/", "getLastCarIndexResponse");
    private final static QName _RemoveDriverResponse_QNAME = new QName("http://ejb/", "removeDriverResponse");
    private final static QName _InsertDriver_QNAME = new QName("http://ejb/", "insertDriver");
    private final static QName _InsertDriverResponse_QNAME = new QName("http://ejb/", "insertDriverResponse");
    private final static QName _GetLastCarIndex_QNAME = new QName("http://ejb/", "getLastCarIndex");
    private final static QName _RemoveCar_QNAME = new QName("http://ejb/", "removeCar");
    private final static QName _ListAllCars_QNAME = new QName("http://ejb/", "listAllCars");
    private final static QName _ShowDriverResponse_QNAME = new QName("http://ejb/", "showDriverResponse");
    private final static QName _ListAllDrivers_QNAME = new QName("http://ejb/", "listAllDrivers");
    private final static QName _ShowCarResponse_QNAME = new QName("http://ejb/", "showCarResponse");
    private final static QName _ListAllCarsResponse_QNAME = new QName("http://ejb/", "listAllCarsResponse");
    private final static QName _ListCarsByDriver_QNAME = new QName("http://ejb/", "listCarsByDriver");
    private final static QName _InsertCar_QNAME = new QName("http://ejb/", "insertCar");
    private final static QName _InsertCarResponse_QNAME = new QName("http://ejb/", "insertCarResponse");
    private final static QName _RemoveDriver_QNAME = new QName("http://ejb/", "removeDriver");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: clientSoap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InsertCar }
     * 
     */
    public InsertCar createInsertCar() {
        return new InsertCar();
    }

    /**
     * Create an instance of {@link ListCarsByDriver }
     * 
     */
    public ListCarsByDriver createListCarsByDriver() {
        return new ListCarsByDriver();
    }

    /**
     * Create an instance of {@link ShowCarResponse }
     * 
     */
    public ShowCarResponse createShowCarResponse() {
        return new ShowCarResponse();
    }

    /**
     * Create an instance of {@link ListAllCarsResponse }
     * 
     */
    public ListAllCarsResponse createListAllCarsResponse() {
        return new ListAllCarsResponse();
    }

    /**
     * Create an instance of {@link RemoveDriver }
     * 
     */
    public RemoveDriver createRemoveDriver() {
        return new RemoveDriver();
    }

    /**
     * Create an instance of {@link InsertCarResponse }
     * 
     */
    public InsertCarResponse createInsertCarResponse() {
        return new InsertCarResponse();
    }

    /**
     * Create an instance of {@link RemoveCar }
     * 
     */
    public RemoveCar createRemoveCar() {
        return new RemoveCar();
    }

    /**
     * Create an instance of {@link ListAllCars }
     * 
     */
    public ListAllCars createListAllCars() {
        return new ListAllCars();
    }

    /**
     * Create an instance of {@link ListAllDrivers }
     * 
     */
    public ListAllDrivers createListAllDrivers() {
        return new ListAllDrivers();
    }

    /**
     * Create an instance of {@link ShowDriverResponse }
     * 
     */
    public ShowDriverResponse createShowDriverResponse() {
        return new ShowDriverResponse();
    }

    /**
     * Create an instance of {@link InsertDriver }
     * 
     */
    public InsertDriver createInsertDriver() {
        return new InsertDriver();
    }

    /**
     * Create an instance of {@link RemoveDriverResponse }
     * 
     */
    public RemoveDriverResponse createRemoveDriverResponse() {
        return new RemoveDriverResponse();
    }

    /**
     * Create an instance of {@link GetLastCarIndexResponse }
     * 
     */
    public GetLastCarIndexResponse createGetLastCarIndexResponse() {
        return new GetLastCarIndexResponse();
    }

    /**
     * Create an instance of {@link ListAllDriversResponse }
     * 
     */
    public ListAllDriversResponse createListAllDriversResponse() {
        return new ListAllDriversResponse();
    }

    /**
     * Create an instance of {@link ShowDriver }
     * 
     */
    public ShowDriver createShowDriver() {
        return new ShowDriver();
    }

    /**
     * Create an instance of {@link RemoveCarResponse }
     * 
     */
    public RemoveCarResponse createRemoveCarResponse() {
        return new RemoveCarResponse();
    }

    /**
     * Create an instance of {@link GetLastCarIndex }
     * 
     */
    public GetLastCarIndex createGetLastCarIndex() {
        return new GetLastCarIndex();
    }

    /**
     * Create an instance of {@link InsertDriverResponse }
     * 
     */
    public InsertDriverResponse createInsertDriverResponse() {
        return new InsertDriverResponse();
    }

    /**
     * Create an instance of {@link ShowCar }
     * 
     */
    public ShowCar createShowCar() {
        return new ShowCar();
    }

    /**
     * Create an instance of {@link ListCarsByDriverResponse }
     * 
     */
    public ListCarsByDriverResponse createListCarsByDriverResponse() {
        return new ListCarsByDriverResponse();
    }

    /**
     * Create an instance of {@link DriverTO }
     * 
     */
    public DriverTO createDriverTO() {
        return new DriverTO();
    }

    /**
     * Create an instance of {@link CarTO }
     * 
     */
    public CarTO createCarTO() {
        return new CarTO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListCarsByDriverResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb/", name = "listCarsByDriverResponse")
    public JAXBElement<ListCarsByDriverResponse> createListCarsByDriverResponse(ListCarsByDriverResponse value) {
        return new JAXBElement<ListCarsByDriverResponse>(_ListCarsByDriverResponse_QNAME, ListCarsByDriverResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowCar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb/", name = "showCar")
    public JAXBElement<ShowCar> createShowCar(ShowCar value) {
        return new JAXBElement<ShowCar>(_ShowCar_QNAME, ShowCar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveCarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb/", name = "removeCarResponse")
    public JAXBElement<RemoveCarResponse> createRemoveCarResponse(RemoveCarResponse value) {
        return new JAXBElement<RemoveCarResponse>(_RemoveCarResponse_QNAME, RemoveCarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowDriver }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb/", name = "showDriver")
    public JAXBElement<ShowDriver> createShowDriver(ShowDriver value) {
        return new JAXBElement<ShowDriver>(_ShowDriver_QNAME, ShowDriver.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAllDriversResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb/", name = "listAllDriversResponse")
    public JAXBElement<ListAllDriversResponse> createListAllDriversResponse(ListAllDriversResponse value) {
        return new JAXBElement<ListAllDriversResponse>(_ListAllDriversResponse_QNAME, ListAllDriversResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastCarIndexResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb/", name = "getLastCarIndexResponse")
    public JAXBElement<GetLastCarIndexResponse> createGetLastCarIndexResponse(GetLastCarIndexResponse value) {
        return new JAXBElement<GetLastCarIndexResponse>(_GetLastCarIndexResponse_QNAME, GetLastCarIndexResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveDriverResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb/", name = "removeDriverResponse")
    public JAXBElement<RemoveDriverResponse> createRemoveDriverResponse(RemoveDriverResponse value) {
        return new JAXBElement<RemoveDriverResponse>(_RemoveDriverResponse_QNAME, RemoveDriverResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertDriver }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb/", name = "insertDriver")
    public JAXBElement<InsertDriver> createInsertDriver(InsertDriver value) {
        return new JAXBElement<InsertDriver>(_InsertDriver_QNAME, InsertDriver.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertDriverResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb/", name = "insertDriverResponse")
    public JAXBElement<InsertDriverResponse> createInsertDriverResponse(InsertDriverResponse value) {
        return new JAXBElement<InsertDriverResponse>(_InsertDriverResponse_QNAME, InsertDriverResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastCarIndex }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb/", name = "getLastCarIndex")
    public JAXBElement<GetLastCarIndex> createGetLastCarIndex(GetLastCarIndex value) {
        return new JAXBElement<GetLastCarIndex>(_GetLastCarIndex_QNAME, GetLastCarIndex.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveCar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb/", name = "removeCar")
    public JAXBElement<RemoveCar> createRemoveCar(RemoveCar value) {
        return new JAXBElement<RemoveCar>(_RemoveCar_QNAME, RemoveCar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAllCars }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb/", name = "listAllCars")
    public JAXBElement<ListAllCars> createListAllCars(ListAllCars value) {
        return new JAXBElement<ListAllCars>(_ListAllCars_QNAME, ListAllCars.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowDriverResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb/", name = "showDriverResponse")
    public JAXBElement<ShowDriverResponse> createShowDriverResponse(ShowDriverResponse value) {
        return new JAXBElement<ShowDriverResponse>(_ShowDriverResponse_QNAME, ShowDriverResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAllDrivers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb/", name = "listAllDrivers")
    public JAXBElement<ListAllDrivers> createListAllDrivers(ListAllDrivers value) {
        return new JAXBElement<ListAllDrivers>(_ListAllDrivers_QNAME, ListAllDrivers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowCarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb/", name = "showCarResponse")
    public JAXBElement<ShowCarResponse> createShowCarResponse(ShowCarResponse value) {
        return new JAXBElement<ShowCarResponse>(_ShowCarResponse_QNAME, ShowCarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAllCarsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb/", name = "listAllCarsResponse")
    public JAXBElement<ListAllCarsResponse> createListAllCarsResponse(ListAllCarsResponse value) {
        return new JAXBElement<ListAllCarsResponse>(_ListAllCarsResponse_QNAME, ListAllCarsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListCarsByDriver }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb/", name = "listCarsByDriver")
    public JAXBElement<ListCarsByDriver> createListCarsByDriver(ListCarsByDriver value) {
        return new JAXBElement<ListCarsByDriver>(_ListCarsByDriver_QNAME, ListCarsByDriver.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertCar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb/", name = "insertCar")
    public JAXBElement<InsertCar> createInsertCar(InsertCar value) {
        return new JAXBElement<InsertCar>(_InsertCar_QNAME, InsertCar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertCarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb/", name = "insertCarResponse")
    public JAXBElement<InsertCarResponse> createInsertCarResponse(InsertCarResponse value) {
        return new JAXBElement<InsertCarResponse>(_InsertCarResponse_QNAME, InsertCarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveDriver }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb/", name = "removeDriver")
    public JAXBElement<RemoveDriver> createRemoveDriver(RemoveDriver value) {
        return new JAXBElement<RemoveDriver>(_RemoveDriver_QNAME, RemoveDriver.class, null, value);
    }

}
