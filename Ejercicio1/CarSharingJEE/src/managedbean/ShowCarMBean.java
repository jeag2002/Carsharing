package managedbean;

import java.io.Serializable;
import java.util.*;

import javax.ejb.EJB;
import javax.faces.bean.*;
import javax.naming.Context;
import javax.naming.InitialContext;

import jpa.CarJPA;
import ejb.CatalogFacadeRemote;

/**
 * Managed Bean ShowPetMBean
 */
@ManagedBean(name = "carshow")
@SessionScoped
public class ShowCarMBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@EJB
	private CatalogFacadeRemote showCarRemote;
	//stores PetJPA instance
	protected CarJPA dataCar;
	//stores PetJPA number id
	protected int idCar = 1;
	
	public ShowCarMBean() throws Exception 
	{
		setDataCar();
	}
	
	/**
	 * Get/set the id number and PetJPA instance
	 * @return Pet Id
	 */
	public int getIdCar()
	{
		return idCar;
	}
	
	public void setIdCar(int idCar) throws Exception
	{
		this.idCar = idCar;
		setDataCar();
	}
	
	public CarJPA getDataCar()
	{
		return dataCar;
	}	
	
	public void setDataCar() throws Exception
	{	
		System.out.println("==>showCar (" + idCar+ ")");	
		Properties props = System.getProperties();
		Context ctx = new InitialContext(props);
		showCarRemote = (CatalogFacadeRemote) ctx.lookup("java:app/CarSharingJEE.jar/CatalogFacadeBean!ejb.CatalogFacadeRemote");
		dataCar = (CarJPA) showCarRemote.showCar(idCar);
	}
}
