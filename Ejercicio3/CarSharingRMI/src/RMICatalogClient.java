/*
 * Copyright FUOC.  All rights reserved.
 * @author Vicenç Font Sagristà, 2011
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.NumberFormatException;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Iterator;

public class RMICatalogClient {
	/**
	 * Client program for the "RMI Practical Case!" example.
     * @param argv The command line arguments which are ignored.
	 */	
	
	private static final String EXIT = "E";
	
	@SuppressWarnings("unchecked")
	public static void main (String[] argv) {
		
	    try {
	      RMICatalogInterface practicalCase = 
	        (RMICatalogInterface) Naming.lookup ("rmi://localhost:1099/PracticalCaseRMI");
	      
	      System.out.println("          C A R S H A R I N G ");
	      
	      int car = 0;
	      String EOF = "";
	      
	      
	      while(!EOF.trim().equals(EXIT)){
	      
		      System.out.println("          M E N U ");
		      System.out.println("          [0-99]_Get Data Car by Index ");
		      System.out.println("          [E]____Exit ");
		      
		      EOF = input();
		      
		      try{
		    	 car = Integer.parseInt(EOF); 
		      }catch(Exception e_2){
		    	  if (!EOF.trim().equalsIgnoreCase(EXIT)){
		    		  System.out.println("Entrada no reconocida [" + EOF +"]. valor car por defecto 1");
		    		  car = 1;
		    	  }
		      }
		      
		      if (!EOF.equalsIgnoreCase(EXIT)){		      
		    	  System.out.println("          I N F O R M A T I O N   A B O U T   C A R [" + car + "]");
		    	  RMICarTO carTO = practicalCase.showCar(car);
			      System.out.println("");
			      if (carTO!=null){
				      System.out.println("__________ID number_______: "+carTO.getId() 	+ " "); 					   
				      System.out.println("__________Brand car_______: "+carTO.getBrand() + " ");
				      System.out.println("__________Model car_______: "+carTO.getModel() + " ");
				      System.out.println("__________Color car_______: "+carTO.getColor() + " ");
				      System.out.println("__________ID driver_______: "+carTO.getNif() 	+ " ");
			      }else{
			    	  System.out.println("__________No Data_________: ");
			      }
			      
			      System.out.println("___ pulsar <ENTER> para continuar ___");
			      String next = input();
		      }
	      }
	    } catch (Exception e) {
		  System.out.println ("practicaepcsd Client exception: " + e);
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
