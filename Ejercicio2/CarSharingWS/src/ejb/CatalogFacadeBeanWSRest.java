/*
 * Copyright FUOC.  All rights reserved.
 * @author Vicen� Font Sagrist�, 2012
 */
package ejb;

import java.util.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import jpa.CarJPA;
import jpa.DriverJPA;
import TO.CarTO;
import TO.DriverTO;
import ejb.CatalogFacadeRemoteWSRest;

/**
 * EJB Session Bean Class of example "Practical Case Study WS Rest"
 */
@Stateless
public class CatalogFacadeBeanWSRest implements CatalogFacadeRemoteWSRest {

	
	//Persistence Unit Context
	@PersistenceContext(unitName="PracticaEpcsd") 
	private EntityManager entman;
   

	@Override
	public Collection<DriverTO> listAllDrivers() {
		Collection<DriverTO> drivers= new ArrayList<DriverTO>();
		System.out.println("->listAllDrivers REST WS IN");
		@SuppressWarnings("unchecked")
		Collection<DriverJPA> allCategories = entman.createQuery("from DriverJPA").getResultList();
		
		for(DriverJPA car: allCategories){
			DriverTO driverTo = new DriverTO();
			driverTo.setEmail(car.getEmail());
			driverTo.setGlobalRatting(car.getGlobalRatting());
			driverTo.setName(car.getName());
			driverTo.setSurname(car.getSurname());
			driverTo.setNif(car.getNif());
			driverTo.setPassword(car.getPassword());
			System.out.println("->listAllDrivers set driver " + driverTo.toString());
			drivers.add(driverTo);
		}
		System.out.println("->listAllDrivers REST WS OUT");
		
		return drivers;
	}

	@Override
	public Collection<CarTO> listAllCars() {
		
		Collection<CarTO> cars= new ArrayList<CarTO>();
		System.out.println("->listAllCars REST WS IN");
		@SuppressWarnings("unchecked")
		Collection<CarJPA> allPets = entman.createQuery("from CarJPA").getResultList();
	    
		for(CarJPA car: allPets){
			CarTO cTO = new CarTO();
			cTO.setBrand(car.getBrand());
			cTO.setColor(car.getColor());
			cTO.setModel(car.getModel());
			cTO.setNif(car.getDriver().getNif());
			cTO.setPhoto(car.getPhoto());
			cTO.setId(car.getId());
			System.out.println("->listAllCars set car " + cTO.toString());
			cars.add(cTO);		
		}
		System.out.println("->listAllCars REST WS IN");
		return cars;
	}
	
	
	@Override
	public CarTO getLastCarIndex(){
		@SuppressWarnings("unchecked")
		CarJPA car = null;
		CarTO cTO = new CarTO();
		Collection<CarJPA> cars = entman.createQuery("from CarJPA b ORDER BY b.id DESC").getResultList();
		
		if (!cars.isEmpty() || cars.size()>=1)
		{
			Iterator<CarJPA> iter = cars.iterator();
			car = (CarJPA) iter.next();
		}
		
		if (car!=null){
			cTO.setBrand(car.getBrand());
			cTO.setColor(car.getColor());
			cTO.setModel(car.getModel());
			cTO.setNif(car.getDriver().getNif());
			cTO.setPhoto(car.getPhoto());
			cTO.setId(car.getId());
		}
		
	    return cTO;
	}
	

	
	@Override
	public Collection<CarTO> listCarsByDriver(String nif) {
		Collection<CarJPA> allCarsbyDriver = null;
		Collection<CarTO> allCarsTo = new ArrayList<CarTO>();
		
		
		try
		{		
			@SuppressWarnings("unchecked")
			Collection<DriverJPA> drivers = entman.createQuery("FROM DriverJPA b WHERE b.nif = :nif").setParameter("nif", nif).getResultList();
			System.out.println("->listCarsByDriver("+nif+") REST WS IN");
			if (!drivers.isEmpty() || drivers.size()==1)
			{
				Iterator<DriverJPA> iter = drivers.iterator();
				DriverJPA element = (DriverJPA) iter.next();
				allCarsbyDriver = element.getCarsbyDriver();
				
				for(CarJPA cJPA: allCarsbyDriver){
					CarTO carTO = new CarTO(cJPA.getId(),
							cJPA.getBrand(),
							cJPA.getPhoto(),
							cJPA.getModel(),
							cJPA.getColor(),
							nif);
					System.out.println("->listCarsByDriver set car " + carTO.toString());
					allCarsTo.add(carTO);
				}
			}
			System.out.println("->listCarsByDriver("+nif+") REST WS OUT");
		}catch (PersistenceException e) {
			System.out.println(e);
		} 
	    return allCarsTo;
	}

	@Override
	public DriverTO showDriver(String nif){
		
		DriverJPA driver = null;
		try
		{
			@SuppressWarnings("unchecked")
			Collection<DriverJPA> drivers = entman.createQuery("FROM DriverJPA b WHERE b.nif = ?1").setParameter(1, nif).getResultList();
			if (!drivers.isEmpty() || drivers.size()==1)
			{
				Iterator<DriverJPA> iter = drivers.iterator();
				driver = (DriverJPA) iter.next();				
			}
		}catch (PersistenceException e) {
			System.out.println(e);
		} 
		
		DriverTO driverTo = new DriverTO();
		
		if (driver!=null){
			driverTo.setEmail(driver.getEmail());
			driverTo.setGlobalRatting(driver.getGlobalRatting());
			driverTo.setName(driver.getName());
			driverTo.setSurname(driver.getSurname());
			driverTo.setNif(driver.getNif());
			driverTo.setPassword(driver.getPassword());
		}
		
	    return driverTo;
		
		
	}
	
	@Override
	public CarTO showCar(int carId){
		CarJPA car = null;
		try
		{
			@SuppressWarnings("unchecked")
			Collection<CarJPA> cars = entman.createQuery("FROM CarJPA b WHERE b.id = ?1").setParameter(1, new Integer(carId)).getResultList();
			if (!cars.isEmpty() || cars.size()==1)
			{
				Iterator<CarJPA> iter = cars.iterator();
				car = (CarJPA) iter.next();				
			}
		}catch (PersistenceException e) {
			System.out.println(e);
		} 
		
		CarTO carTO = new CarTO();
		
		if (car!=null){
			carTO.setBrand(car.getBrand());
			carTO.setColor(car.getColor());
			carTO.setId(car.getId());
			carTO.setModel(car.getModel());
			carTO.setNif(car.getDriver().getNif());
			carTO.setPhoto(car.getPhoto());
		}
	
	    return carTO;		
	}
	

	@Override
	//borramos los coches asociados y el conductor.
	public void removeDriver(String nif) {
		
		//-->borrar coches asociados a un conductor 
		int deleteCount = entman.createQuery("DELETE FROM CarJPA b WHERE b.nif = ?1").setParameter(1, nif).executeUpdate();
		//-->borrar conductor
		deleteCount = entman.createQuery("DELETE FROM DriverJPA b WHERE b.nif = ?1").setParameter(1, nif).executeUpdate();
	}

	@Override
	//borramos un coche
	public void removeCar(CarTO cJPA) {
		CarJPA carJPA = new CarJPA();
		carJPA.setBrand(cJPA.getBrand());
		carJPA.setColor(cJPA.getColor());
		carJPA.setId(cJPA.getId());
		carJPA.setModel(cJPA.getModel());
		carJPA.setPhoto(cJPA.getPhoto());
		
		int deleteCount = entman.createQuery("DELETE FROM CarJPA b WHERE b.id = ?1").setParameter(1, new Integer(cJPA.getId())).executeUpdate();
	}
	

	@Override
	//a�adimos un coche
	//insert into practicaepcsd.car (id,brand,photo,model,color,nif) values (1,'brand1','photo1','model1','color1','11111111A');
	public void insertCar(CarTO carJPA) {
		
		Query query = entman.createNativeQuery("INSERT INTO practicaepcsd.car (id,brand,photo,model,color,nif) VALUES (?,?,?,?,?,?)");
		query.setParameter(1,new Integer(carJPA.getId()));
		query.setParameter(2,carJPA.getBrand());
		query.setParameter(3,carJPA.getPhoto());
		query.setParameter(4,carJPA.getModel());
		query.setParameter(5,carJPA.getColor());
		query.setParameter(6,carJPA.getNif());
		query.executeUpdate();
	}	
	
	@Override
	//a�adimos un conductor
	//insert into practicaepcsd.driver (nif,name,surname,phone,password,email,globalRatting) values ('11111111A','NOMBRE1','APP1','123456789','PASS1','nombre1@car.com',1.0);
	public void insertDriver(DriverTO driverJPA) {
		
		Query query = entman.createNativeQuery("INSERT INTO practicaepcsd.driver (nif,name,surname,phone,password,email,globalRatting) VALUES (?,?,?,?,?,?,?)");
		query.setParameter(1,driverJPA.getNif());
		query.setParameter(2,driverJPA.getName());
		query.setParameter(3,driverJPA.getSurname());
		query.setParameter(4,driverJPA.getPhone());
		query.setParameter(5,driverJPA.getPassword());
		query.setParameter(6,driverJPA.getEmail());
		query.setParameter(7,new Float(driverJPA.getGlobalRatting()));
		query.executeUpdate();
	}
	
	
}
