/*
 * Copyright FUOC.  All rights reserved.
 */
package ejb;

import java.util.Collection;

import javax.ejb.Remote;

import jpa.CarJPA;
import jpa.DriverJPA;
/**
 * Session EJB Remote Interfaces
 */
@Remote
public interface CatalogFacadeRemote {
	  /**
	   * Remotely invoked method.
	   */	
	  
	  //JPA Practica
	  ////////////////////////////////////////////////////////////////////////////
	  public Collection<?> listAllDrivers();
	  public Collection<?> listAllCars();
	  public Collection<?> listCarsByDriver(String nif);
	  public DriverJPA showDriver(String nif);
	  public CarJPA showCar(int carId);
	  public CarJPA getLastCarIndex();
	  public void removeDriver(String nif);
	  public void removeCar(CarJPA cJPA);
	  public void insertCar(CarJPA carJPA);
	  public void insertDriver(DriverJPA driverJPA);
	  ////////////////////////////////////////////////////////////////////////////
}
