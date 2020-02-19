package com.cg.fms.airportservice;

import java.util.List;

import com.cg.fms.bean.airport.Airport;
import com.cg.fms.exception.FlightException;



public interface AirportService {
	public String addAirport(Airport airport)throws FlightException;

	public List<Airport>viewAirport()  throws FlightException;
	public Airport viewAirportDetails(String airportCode) throws FlightException;
}
