/*
 * Copyright FUOC.  All rights reserved.
 */
package managedbean;

import java.io.Serializable;
import java.util.*;

import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import javax.faces.bean.*;
import javax.naming.Context;
import javax.naming.InitialContext;

import jpa.DriverJPA;
import ejb.CatalogFacadeRemote;

/**
 * Managed Bean ListCategoriesMBean
 */
@ManagedBean(name = "driver")
@SessionScoped
public class ListDriversMBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private CatalogFacadeRemote catalogRemote;		
	protected Collection<SelectItem> driverList = new ArrayList<SelectItem>();
	protected Collection<SelectItem> driverNif = new ArrayList<SelectItem>();
	
	public ListDriversMBean() throws Exception
	{
		this.driversList();
	}

	/**
	 * Method get which return Categories Collection
	 * @return Collection
	 */
	public Collection<SelectItem> getDriversList()
	{
		System.out.println("==>getDriversList()");
		try{
		driversList();
		}catch(Exception e){
			System.out.println("DriversList " + e.getMessage());
			driverList = new ArrayList<SelectItem>();
		}
		return driverList;
	}
	
	
	public Collection<SelectItem> getDriversNif()
	{
		System.out.println("==>getDriversNif()");
		
		try{
			driversNif();
		}catch(Exception e){
			System.out.println("DriversNif " + e.getMessage());
			driverNif = new ArrayList<SelectItem>();
		}
		
		
		return driverList;
	}
	
	
	public void driversNif() throws Exception
	{
		System.out.println("==>generateList()");
		Properties props = System.getProperties();
		Context ctx = new InitialContext(props);
		catalogRemote = (CatalogFacadeRemote) ctx.lookup("java:app/CarSharingJEE.jar/CatalogFacadeBean!ejb.CatalogFacadeRemote");
		@SuppressWarnings("unchecked")
		Collection<DriverJPA> driverCollection = (Collection<DriverJPA>) catalogRemote.listAllDrivers();
		this.driverList.clear();
		this.driverNif.clear();
		
		for (Iterator<DriverJPA> iter2 = driverCollection.iterator(); iter2.hasNext();)
		{
			DriverJPA pet2 = (DriverJPA) iter2.next();
			SelectItem item = new SelectItem(pet2.getNif());
			this.driverList.add(item);	
			this.driverNif.add(item);
		}
		
	}
	
	/**
	 * Method that takes a collection of instances of CategoryJPA calling 
	 * method listAllCategories of the EJB Session
	 * @throws Exception
	 */
	public void driversList() throws Exception
	{	
		System.out.println("==>driversList()");
		driversNif();
		this.driverList.add(new SelectItem("ALL DRIVERS"));
	}
}
