/*
 * Copyright FUOC.  All rights reserved.
 * @author Vicenç Font Sagristà, 2012
 */
package ejb;

import java.util.Collection;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebService;

import jpa.CarJPA;
import jpa.DriverJPA;
import TO.CarTO;
import TO.DriverTO;

/**
 * Session EJB Remote Interfaces
 */
@Remote
@WebService
public interface CatalogFacadeRemoteWSSoap {
	  /**
	   * Remotely invoked method.
	   */

	  @WebMethod public Collection<DriverTO> listAllDrivers();
	  @WebMethod public Collection<CarTO> listAllCars();
	  @WebMethod public Collection<CarTO> listCarsByDriver(String nif);
	  @WebMethod public DriverTO showDriver(String nif);
	  @WebMethod public CarTO showCar(int carId);
	  @WebMethod public CarTO getLastCarIndex();
	  @WebMethod public void removeDriver(String nif);
	  @WebMethod public void removeCar(CarTO cJPA);
	  @WebMethod public void insertCar(CarTO carJPA);
	  @WebMethod public void insertDriver(DriverTO driverJPA);
	  
}
