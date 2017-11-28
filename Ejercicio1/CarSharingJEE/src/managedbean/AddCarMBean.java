package managedbean;

import java.io.Serializable;
import java.util.*;

import javax.ejb.EJB;
import javax.faces.bean.*;
import javax.faces.event.ValueChangeEvent;
import javax.naming.Context;
import javax.naming.InitialContext;

import jpa.CarJPA;
import jpa.DriverJPA;
import ejb.CatalogFacadeRemote;

/**
 * Managed Bean ShowPetMBean
 */
@ManagedBean(name = "caradd")
@SessionScoped
public class AddCarMBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@EJB
	private CatalogFacadeRemote showCarRemote;
	private CarJPA dataCar;

	protected int idCar = 1;
	protected String nif = "";
	protected String brand = "";
	protected String model = "";
	protected String color = "";
	protected String photo = "";
	
	
	public AddCarMBean() throws Exception 
	{
		nextIndexCar();
	}
	
	
	public String saveCar() throws Exception
	{
		System.out.println("==>saveCar()");
		insertCar();
		nif = "";
		brand = "";
		model = "";
		color = "";
		photo = "";
		nextIndexCar();
		return "listCarsView";
	}
	
	
	public void driverValueChanged(ValueChangeEvent driverChanged) {
		System.out.println("==>driverValueChanged()");
		this.nif = driverChanged.getNewValue().toString();
	}

	private void insertCar() throws Exception
	{
		System.out.println("==>insertCar()");
		Properties props = System.getProperties();
		Context ctx = new InitialContext(props);
		showCarRemote = (CatalogFacadeRemote) ctx.lookup("java:app/CarSharingJEE.jar/CatalogFacadeBean!ejb.CatalogFacadeRemote");
		
		CarJPA newCar = new CarJPA();
		newCar.setId(idCar);
		newCar.setModel(model);
		newCar.setBrand(brand);
		newCar.setColor(color);
		newCar.setPhoto(photo);
		
		DriverJPA driver = showCarRemote.showDriver(nif);
		newCar.setDriver(driver);
		
		System.out.println("==>insertCar("+newCar.toString()+")");
		
		showCarRemote.insertCar(newCar);
		
	}
	
	
	private void nextIndexCar() throws Exception
	{
		System.out.println("==>nextIndexCar()");
		Properties props = System.getProperties();
		Context ctx = new InitialContext(props);
		showCarRemote = (CatalogFacadeRemote) ctx.lookup("java:app/CarSharingJEE.jar/CatalogFacadeBean!ejb.CatalogFacadeRemote");
		CarJPA newIndex = showCarRemote.getLastCarIndex();
		idCar = newIndex.getId()+1;
	}
	
	
	public int getIdCar() {
		return idCar;
	}


	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}


	public String getNif() {
		return nif;
	}


	public void setNif(String nif) {
		this.nif = nif;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
	
}
