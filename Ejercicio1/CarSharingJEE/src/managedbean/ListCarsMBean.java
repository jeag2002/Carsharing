package managedbean;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.naming.Context;
import javax.naming.InitialContext;

import jpa.CarJPA;
import ejb.CatalogFacadeRemote;


@ManagedBean(name = "car")
@SessionScoped
public class ListCarsMBean implements Serializable{
	
	private static final long serialVersionUID = 1L;	

	@EJB
	private CatalogFacadeRemote carsRemote;
	
	private String nif = "ALL DRIVERS";
	
	private Collection<CarJPA> carsList;
	 
	private int screen = 0;
	
	protected Collection<CarJPA> carListView;
	
	protected int numberCars = 0;
	protected int idCar = 1;
	
	
	
	public ListCarsMBean() throws Exception
	{
		System.out.println("==>ListCarsMBean()");
		screen = 0;
		this.carList();
	}
	
	public void driverMap(ActionEvent e) {
		System.out.println("==>driverMap()");		
		nif = "ALL DRIVERS";
		this.setNif(nif);
	}

	
	public Collection<CarJPA> getCarListView()
	{
		System.out.println("==>getCarListView()");
		int n =0;
		try{carList();}catch(Exception e){}
		carListView = new ArrayList<CarJPA>();
		for (Iterator<CarJPA> iter2 = carsList.iterator(); iter2.hasNext();)
		{
			CarJPA car2 = (CarJPA) iter2.next();
			if (n >= screen*10 && n< (screen*10+10))
			{				
				this.carListView.add(car2);
			}
			n +=1;
		}
		this.numberCars = n;
		return carListView;
	}
	

	public int getNumberCars()
	{ 
		System.out.println("==>getNumberCars()");
		return this.numberCars;
	}
	
	public void nextScreen()
	{
		System.out.println("==>nextScreen()");
		if (((screen+1)*10 < carsList.size()))
		{
			screen +=1;
		}
	}
	
	public void previousScreen()
	{
		System.out.println("==>previousScreen()");
		if ((screen > 0))
		{
			screen -=1;
		}
	}

	
	public String getNif()
	{
		System.out.println("==>getNif()");
		return this.nif;
	}
	
	public void setNif(String driver)
	{
		System.out.println("==>setNif()");
		this.nif = driver;
	}
	
	public void driverValueChanged(ValueChangeEvent driverChanged) {
		System.out.println("==>driverValueChanged()");
		this.nif = driverChanged.getNewValue().toString();
	}
	
	
	public String listCar() throws Exception
	{
		System.out.println("==>listCar()");
		carList();
		return "listCarsView";
	}
	
	
	public String queryListCar()throws Exception
	{
		System.out.println("==>queryListCar()");
		screen = 0;
		carList();
		return "listCarsView";
		
	}
	
	
	public String delCar(CarJPA car) throws Exception
	{
		System.out.println("==>delCar("+car.toString()+")");
		screen = 0;
		deleteCar(car);
		carList();
		return "listCarsView";
	}
	
	
	public String setShowCar()
	{
		System.out.println("==>setShowCar()");
		return "showCarView";
	}
	
	public int getIdCar()
	{
		System.out.println("==>getIdCar()");
		return idCar;
	}
	
	
	public void setIdCar(int idCar) throws Exception
	{
		System.out.println("==>setIdCar()");
		this.idCar = idCar;
	}
	
	@SuppressWarnings("unchecked")
	private void carList() throws Exception
	{	
		Properties props = System.getProperties();
		Context ctx = new InitialContext(props);
		carsRemote = (CatalogFacadeRemote) ctx.lookup("java:app/CarSharingJEE.jar/CatalogFacadeBean!ejb.CatalogFacadeRemote");	
		if (nif.indexOf("ALL DRIVERS")!=-1)
		{
			carsList = (Collection<CarJPA>)carsRemote.listAllCars();
		}
		else
		{
			carsList = (Collection<CarJPA>)carsRemote.listCarsByDriver(nif);
		}
		
		System.out.println("==>carList() recuperar los cars de nif " + nif + " size " + carsList.size());
	}
	
	
	private void deleteCar(CarJPA car) throws Exception
	{	
		System.out.println("==>deleteCar("+car.toString()+")");
		Properties props = System.getProperties();
		Context ctx = new InitialContext(props);
		carsRemote = (CatalogFacadeRemote) ctx.lookup("java:app/CarSharingJEE.jar/CatalogFacadeBean!ejb.CatalogFacadeRemote");
		carsRemote.removeCar(car);
	
	}	
	
	
}
