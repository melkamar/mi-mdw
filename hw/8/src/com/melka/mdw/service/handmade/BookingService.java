package com.melka.mdw.service.handmade;

import java.rmi.RemoteException;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.rpc.ServiceException;

import com.melka.autocreated.FlightBookingServiceProxy;
import com.melka.autocreated.FlightBookingServiceServiceLocator;
import com.melka.autocreated.TripBookingServiceServiceLocator;

@WebService
public class BookingService {
	public String makeBooking(@WebParam(name="bookingType") String type, 
			@WebParam(name="personName") String name, 
			@WebParam(name="destinationName")String destination){
		if (type.equals("flight")){
			try {
				return new FlightBookingServiceServiceLocator().getFlightBookingServicePort().bookFlight(name, destination);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return e.toString();
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return e.toString();
			}
		} else if (type.equals("trip")){
			try {
				return new TripBookingServiceServiceLocator().getTripBookingServicePort().bookTrip(name, destination);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return e.toString();
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return e.toString();
			}
		}
		
		return "Invalid booking type.";
	}
}
