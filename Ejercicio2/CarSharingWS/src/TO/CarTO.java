package TO;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name= "car")
@SuppressWarnings("serial")
public class CarTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int id;
	private String brand;
	private String photo;
	private String model;
	private String color;
	private String nif;
	

	public CarTO() {
		this.id = 0;
		this.brand = "";
		this.photo = "";
		this.model = "";
		this.color = "";
		this.nif = "";
	}
	
	public CarTO(String carString){
		
		System.out.println("carString ::= " + carString);
		this.id = 0;
		this.brand = "";
		this.photo = "";
		this.model = "";
		this.color = "";
		this.nif = "";
		
	}
	
	public CarTO(int id, 
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
		this.nif = nif;
	}
	
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
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
		
	@Override
	public String toString(){
		return " id := " + this.id + " brand := " + this.brand + " photo := " + this.photo + " model := " + this.model + " color := " + this.color + " refDriver := (" + this.nif.toString() + ")"; 
	}
}
