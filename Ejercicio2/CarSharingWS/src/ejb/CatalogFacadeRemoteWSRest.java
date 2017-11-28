/*
 * Copyright FUOC.  All rights reserved.
 * @author Vicen� Font Sagrist�, 2012
 */
package ejb;

import java.util.Collection;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import jpa.CarJPA;
import jpa.DriverJPA;
import TO.DriverTO;
import TO.CarTO;

/**
 * Session EJB Remote Interfaces
 */
@Remote
@Path("/WSCatalogRest")
public interface CatalogFacadeRemoteWSRest {
	  
	  /**
	   * Remotely invoked method.
	   */
	  ///////////////////////////////////////////////////////////////////////////
	  
	  @GET
	  @Produces("application/xml")
	  @Path("/listAllDrivers")
	  public Collection<DriverTO> listAllDrivers();
	  
	  @GET
	  @Produces("application/xml")
	  @Path("/listAllCars")
	  public Collection<CarTO> listAllCars();
	  
	  @GET
	  @Produces("application/xml")
	  @Path("/listCarsByDriver/{nif}")
	  public Collection<CarTO> listCarsByDriver(@PathParam("nif") String nif);
	  
	  @GET
	  @Produces("application/json")
	  @Path("/showDriver/{nif}")
	  public DriverTO showDriver(@PathParam("nif") String nif);
	  
	  @GET
	  @Produces("application/json")
	  @Path("/showCar/{carId}")
	  public CarTO showCar(@PathParam("carId") int carId);
	  
	  @GET
	  @Produces("application/json")
	  @Path("/getLastCarIndex")
	  public CarTO getLastCarIndex();
	  
	  @GET
	  @Produces("application/xml")
	  @Path("/removeDriver/{nif}")
	  public void removeDriver(@PathParam("nif") String nif);
	  
	  @GET
	  @Produces("application/xml")
	  @Path("/removeCar/{cJPA}")
	  public void removeCar(@PathParam("cJPA") CarTO cJPA);
	  
	  @GET
	  @Produces("application/xml")
	  @Path("/insertCar/{carJPA}")
	  public void insertCar(@PathParam("carJPA") CarTO carJPA);
	  
	  @GET
	  @Produces("application/xml")
	  @Path("/insertDriver/{driverJPA}")
	  public void insertDriver(@PathParam("driverJPA") DriverTO driverJPA);
	  
	  ///////////////////////////////////////////////////////////////////////////	  
}
