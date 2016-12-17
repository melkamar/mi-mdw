package com.melka.mdw.service.handmade;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.melka.mdw.Repository;

@WebService
public class FlightBookingService {
	public String bookFlight(@WebParam(name="personName") String name, 
			@WebParam(name="destinationName") String destination){
		return Repository.bookFlight(destination, name);
	}
}
