package TO;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name= "driver")
@SuppressWarnings("serial")
public class DriverTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nif;
	private String name;
	private String surname;
	private String phone;
	private String password;
	private String email;
	private float globalRatting;
	
	
	public DriverTO() {
		this.nif = "";
		this.name = "";
		this.surname = "";
		this.phone = "";
		this.password = "";
		this.email = "";
		this.globalRatting = 0.0f;
	}
	
	public DriverTO(String carString){
		
		System.out.println("carString ::= " + carString);
		this.nif = "";
		this.name = "";
		this.surname = "";
		this.phone = "";
		this.password = "";
		this.email = "";
		this.globalRatting = 0.0f;
	}
	
	
	public DriverTO(String nif, 
			String name, 
			String surname, 
			String phone, 
			String password, 
			String email,
			float globalRatting) {
		
		this.nif = nif;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.password = password;
		this.email = email;
		this.globalRatting = globalRatting;
	}
	
	
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public float getGlobalRatting() {
		return globalRatting;
	}
	public void setGlobalRatting(float globalRatting) {
		this.globalRatting = globalRatting;
	}
	
	@Override
	public String toString(){
		return " (" + this.nif + ") "
				+ " name := " + this.name 
				+ " surname := " + this.surname 
				+ " pass := " + this.password 
				+ " email := " + this.email 
				+ " phone := " + this.phone
				+ " globalRatting := " + this.globalRatting;
	}

}
