package com.melkamar.mdw.soap;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.melkamar.mdw.model.Booking;
import com.melkamar.mdw.model.Repository;
import com.melkamar.mdw.model.Trip;

@WebService
public class BookingService {
	public List<String> listTrips(){
		List<Trip> trips = Repository.getTrips();
		
		List<String> result = new ArrayList<>();
		for (Trip trip: trips){
			result.add(trip.toString());
		}
		return result;
	}
	
	public String addTrip(@WebParam(name="title") String title, @WebParam(name="capacity") int capacity){
		Trip trip = new Trip(title, capacity);
		Repository.saveTrip(trip);
		
		return "Trip "+title+" successfully created.";
	}
	
	public String makeBooking(@WebParam(name="personName") String personName, @WebParam(name="tripTitle") String tripTitle){
		Trip trip = Repository.getTrip(tripTitle);
		
		if (trip == null){
			return "Trip "+tripTitle+" not found.";
		}
		
		if (trip.isOccupied()){
			return "Trip "+tripTitle+" already fully booked.";
		}
		
		Booking booking = new Booking(personName, trip);
		Repository.saveBooking(booking);
		
		return "Trip "+tripTitle+" booked for person "+personName;
	}
}
