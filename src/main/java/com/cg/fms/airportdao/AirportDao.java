package com.cg.fms.airportdao;

import java.util.List;

import com.cg.fms.bean.airport.Airport;
import com.cg.fms.exception.FlightException;



public interface AirportDao {
public String addAirport(Airport airport)throws FlightException;

	public List<Airport> viewAirport() throws FlightException;
	public Airport viewAirportDetails(String airportCode) throws FlightException;
	
	
}
