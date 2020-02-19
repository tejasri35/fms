package com.cg.fms.airportdao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.fms.bean.airport.Airport;
import com.cg.fms.exception.FlightException;





public class AirportDaoImpl implements AirportDao {
	private Map<String,Airport>map;
	public AirportDaoImpl()
	{
		map=new HashMap<String,Airport>();
	}

	@Override
	public List<Airport> viewAirport()throws FlightException {
 Collection<Airport> col = map.values();
 List<Airport> airportlist = new ArrayList<Airport>(col);
		return airportlist;
		
	}

	@Override
	public Airport viewAirportDetails(String airportCode)throws FlightException {
		boolean flag = map.containsKey(airportCode);
	//	Airport airport=null;
		if(!flag)
		{
			throw new FlightException("Airport Code not found ");
		}
				
		Airport airport=map.get(airportCode);
		
		return airport;
	}

	@Override
	public String addAirport(Airport airport) throws FlightException {
		boolean flag = map.containsKey(airport.getAirportCode());
		if(flag)
		{
			throw new FlightException("Airport Code Already Exist");
		}
		else
		{
			map.put(airport.getAirportCode(),airport );
			
		}
		return  airport.getAirportCode() ;
	}
	


}