package jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * Clase coche -> Equivalente al mascotas del ejemplo
 */

@Entity
@Table(name="practicaepcsd.car")

public class CarJPA implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String brand;
	private String photo;
	private String model;
	private String color;
	private DriverJPA nif;
	
	public CarJPA() {
		super();
		this.id = 0;
		this.brand = "";
		this.photo = "";
		this.model = "";
		this.color = "";	
	}
	
	public CarJPA(int id, 
			String brand, 
			String photo, 
			String model, 
			String color, 
			String nif) {
		
		this.id = id;
		this.brand = brand;
		this.photo = photo;
		this.model = model;
		this.color = color;
	}
	
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
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
		
	@Override
	public String toString(){
		return " id := " + this.id + " brand := " + this.brand + " photo := " + this.photo + " model := " + this.model + " color := " + this.color + " refDriver := (" + this.nif.toString() + ")"; 
	}
	
	/*
	 * Methods get/set persistent relationships
	 */
	@ManyToOne
	@JoinColumn (name="nif")
	public DriverJPA getDriver() {
		return nif;
	}
	public void setDriver(DriverJPA driver) {
		this.nif = driver;
	}
}
