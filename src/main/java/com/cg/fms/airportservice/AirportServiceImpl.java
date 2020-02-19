package com.cg.fms.airportservice;

import java.util.List;
import java.util.Random;

import com.cg.fms.airportdao.AirportDao;
import com.cg.fms.airportdao.AirportDaoImpl;
import com.cg.fms.bean.airport.Airport;
import com.cg.fms.exception.FlightException;

public class AirportServiceImpl implements AirportService{
 private AirportDao airportDao;
 public AirportServiceImpl() {
	 airportDao = new AirportDaoImpl();
 }
 
	@Override
	public List<Airport> viewAirport()  throws FlightException{
     
		return airportDao.viewAirport();
	}

	@Override
	public Airport viewAirportDetails(String airportCode)throws FlightException {
		boolean flag = airportCode.matches("[a-zA-Z]{3}+[0-9]{4}");
		if(!flag)
			throw new FlightException("Airport Code Should contain only 3 characters");
				Airport airport=airportDao.viewAirportDetails(airportCode);
		 return airport;
	}

	@Override
	public String addAirport(Airport airport) throws FlightException {
		Random random = new Random();
		String str=airport.getAirportName();
	String code = str.substring(0,3)+(random.nextInt(100)+1000);
	airport.setAirportCode(code);
	code=airportDao.addAirport(airport);
		return code;
	}
	

}
