/*
 * Copyright FUOC.  All rights reserved.
 */
package ejb;

import java.util.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import jpa.CarJPA;
import jpa.DriverJPA;
import ejb.CatalogFacadeRemote;

/**
 * EJB Session Bean Class of example "Practical Case Study JEE"
 */
@Stateless
public class CatalogFacadeBean implements CatalogFacadeRemote {
	
	//Persistence Unit Context
	@PersistenceContext(unitName="PracticaEpcsd") 
	private EntityManager entman;
   

	@Override
	public Collection<?> listAllDrivers() {
		Collection<DriverJPA> allCategories = entman.createQuery("from DriverJPA").getResultList();
		return allCategories;
	}

	@Override
	public Collection<?> listAllCars() {
		@SuppressWarnings("unchecked")
		Collection<CarJPA> allPets = entman.createQuery("from CarJPA").getResultList();
	    return allPets;
	}
	
	
	@Override
	public CarJPA getLastCarIndex(){
		@SuppressWarnings("unchecked")
		CarJPA car = null;
		Collection<CarJPA> cars = entman.createQuery("from CarJPA b ORDER BY b.id DESC").getResultList();
		
		if (!cars.isEmpty() || cars.size()>=1)
		{
			Iterator<CarJPA> iter = cars.iterator();
			car = (CarJPA) iter.next();
		}
		
	    return car;
	}
	

	@Override
	public Collection<?> listCarsByDriver(String nif) {
		Collection<CarJPA> allCarsbyDriver = null;
		try
		{		
			@SuppressWarnings("unchecked")
			Collection<DriverJPA> drivers = entman.createQuery("FROM DriverJPA b WHERE b.nif = :nif").setParameter("nif", nif).getResultList();
			if (!drivers.isEmpty() || drivers.size()==1)
			{
				Iterator<DriverJPA> iter = drivers.iterator();
				DriverJPA element = (DriverJPA) iter.next();
				allCarsbyDriver = element.getCarsbyDriver();
			}
		}catch (PersistenceException e) {
			System.out.println(e);
		} 
	    return allCarsbyDriver;
	}

	@Override
	public DriverJPA showDriver(String nif){
		
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
	    return driver;
		
		
	}
	
	@Override
	public CarJPA showCar(int carId){
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
	    return car;		
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
	public void removeCar(CarJPA cJPA) {
		int deleteCount = entman.createQuery("DELETE FROM CarJPA b WHERE b.id = ?1").setParameter(1, new Integer(cJPA.getId())).executeUpdate();
	}
	

	@Override
	//anadimos un coche
	//insert into practicaepcsd.car (id,brand,photo,model,color,nif) values (1,'brand1','photo1','model1','color1','11111111A');
	public void insertCar(CarJPA carJPA) {
		Query query = entman.createNativeQuery("INSERT INTO practicaepcsd.car (id,brand,photo,model,color,nif) VALUES (?,?,?,?,?,?)");
		query.setParameter(1,new Integer(carJPA.getId()));
		query.setParameter(2,carJPA.getBrand());
		query.setParameter(3,carJPA.getPhoto());
		query.setParameter(4,carJPA.getModel());
		query.setParameter(5,carJPA.getColor());
		query.setParameter(6,carJPA.getDriver().getNif());
		query.executeUpdate();
	}	
	
	@Override
	//anadimos un conductor
	//insert into practicaepcsd.driver (nif,name,surname,phone,password,email,globalRatting) values ('11111111A','NOMBRE1','APP1','123456789','PASS1','nombre1@car.com',1.0);
	public void insertDriver(DriverJPA driverJPA) {
		
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
