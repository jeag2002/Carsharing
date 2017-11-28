package clientSoap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Iterator;

import clientSoap.CatalogFacadeBeanWSSoapService;
import clientSoap.CatalogFacadeRemoteWSSoap;

class ClientWSJavaSoap {
    @SuppressWarnings("unchecked")
	public static void main(String args[ ]) 
    {
	    CatalogFacadeBeanWSSoapService service = new CatalogFacadeBeanWSSoapService();
	    CatalogFacadeRemoteWSSoap port = service.getWSCatalogSoapPort();
	    
	    java.util.Collection<DriverTO> resultDrivers;
	    java.util.Collection<CarTO> resultCars;
	    
	    try{
	    	resultDrivers = port.listAllDrivers();
	    	System.out.println(" D R I V E R S ");
	    	
	    	int driver = 0;
	    	for(DriverTO dTO : resultDrivers){
	    		System.out.println(" ================================ ");
	    		System.out.println(" driver [" + driver + "] nif [" + dTO.getNif() + "]");
	    		System.out.println("_datos___: ");
	    		System.out.println("_nif___: " + dTO.getNif() );
	    		System.out.println("_name__: " + dTO.getName() + " - " + dTO.getSurname() );
	    		System.out.println("_pass__: " + dTO.getPassword());
	    		System.out.println("_phone_: " + dTO.getPhone());
	    		System.out.println("_ratio_: " + dTO.getGlobalRatting());
	    		System.out.println(" ");
	    		System.out.println(" C A R S related to driver [" + dTO.getNif() + "]");
	    		resultCars = port.listCarsByDriver(dTO.getNif());
	    		System.out.println(" ******************************** ");
	    		for(CarTO cTO:resultCars){
	    			System.out.println(" ");
	    			System.out.println("_idCar_: " + cTO.getId());
	    			System.out.println("_Model_: " + cTO.getModel());
	    			System.out.println("_Brand_: " + cTO.getBrand());
	    			System.out.println("_Color_: " + cTO.getColor());
	    			System.out.println("_Photo_: " + cTO.getPhoto());
	    		}
	    		System.out.println(" ******************************** ");
	    		System.out.println(" ================================ ");
	    		driver++;
	    	}
	    	
	    	
	    	
	    	
	    }catch(Exception e){
	    	System.out.println ("PracticalCase Client exception: " + e);
	    }
	    
    }

	/**
	* Reads a character from keyboard 
	* @return char
	* @throws IOException
	*/
	static public char getChar() throws IOException
	{
	  char ch = (char) System.in.read();
	  input(); 
	  return ch;
	}
	
	/**
	* Reads a string from keyboard
	* @return String
	* @throws IOException
	*/
	static public String input() throws IOException
	{
	    String input; 
	    //an instance of the BufferedReader class
	    //will be used to read the data
	    BufferedReader reader;
	    //specify the reader variable 
	    //to be a standard input buffer
	    reader = new BufferedReader(new InputStreamReader(System.in));
	    //read the data entered by the user using 
	    //the readLine() method of the BufferedReader class
	    //and store the value in the name variable
	    input = reader.readLine();
	    return input;
	}
	
	/**
	* Formats a string according to a given length
	* @param stringFormat
	* @param lengthFormat
	* @return String
	*/
	public static String formatString(String stringFormat, int lengthFormat)
	{
	  stringFormat = stringFormat.trim();
	
	  int lengthName = stringFormat.length();
	  if (lengthFormat>0)
	  {
		  stringFormat +="                                                            ";
		  stringFormat= stringFormat.substring(0, lengthFormat);
	  }
	  else if (lengthFormat<0)
	  {
		  stringFormat = "1                                                           "+stringFormat;
		  stringFormat = stringFormat.substring(60+lengthName-(-lengthFormat));
	  }
	  return stringFormat;
	}
}


