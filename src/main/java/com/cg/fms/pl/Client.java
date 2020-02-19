package com.cg.fms.pl;

import java.util.List;
import java.util.Scanner;

import com.cg.fms.airportservice.AirportService;
import com.cg.fms.airportservice.AirportServiceImpl;
import com.cg.fms.bean.airport.Airport;
import com.cg.fms.exception.FlightException;

public class Client {
public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	List<Airport> list = null;
	AirportService airportService = new AirportServiceImpl();
	int choice=0;
	String name=null;
	String code=null;
	String location=null;
	while(choice!=4)
	{
		System.out.println("1.add Airport ");
		System.out.println("2.List Airport Details");
		System.out.println("3.View Details Of Details");
		System.out.println("4.Exit");
		System.out.println("Enter Your Choice");
		choice = sc.nextInt();
	
	
	switch(choice) {
	case 1:
		sc.nextLine();
		System.out.println("Enter Airport Name ");
		 name=sc.nextLine();
	System.out.println("Enter Airport Location ");
          location =sc.nextLine();
         Airport airport= new Airport();
         airport.setAirportLocation(location);
         airport.setAirportName(name);
         
       
         try
         {
          code= airportService.addAirport(airport);
         System.out.println("Airport code="+code);  
         }
	catch(FlightException e)
	{
		System.out.println(e.getMessage());
	}
		case 2:
	 try
	 
	 {
	list = airportService.viewAirport();
	for(Airport ap : list)
	{
		 name=ap.getAirportName();
		 code =ap.getAirportCode();
		location=ap.getAirportLocation();
	    System.out.println(name+" "+code+" "+location);
	
	}
	 }
	catch(FlightException e)
	{
		System.err.println(e.getMessage());
		
	}
		break;
		case 3:
			System.out.println("Enter Airport Code");

			 code=sc.next();
			try
			{
	
			 airport=airportService.viewAirportDetails(code);
	System.out.println("Airport name="+airport.getAirportName());
	System.out.println("Airport location= "+airport.getAirportLocation());
			}
			catch(FlightException e)
			{
				System.err.println(e.getMessage());
			}
			break;
		case 4:
			System.out.println("Thank You");
			return;
	
}
	
	
}
}
}
