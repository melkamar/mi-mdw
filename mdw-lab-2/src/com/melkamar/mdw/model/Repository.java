package com.melkamar.mdw.model;

import java.util.ArrayList;
import java.util.List;

import weblogic.rmi.extensions.NotImplementedException;

public class Repository {
	private static List<Booking> bookings;
	private static List<Person> persons;
	private static List<Trip> trips;
	
	static {
		bookings = new ArrayList<>();
		persons = new ArrayList<>();
		trips = new ArrayList<>();

		for (int i=1; i<20; i++){
			trips.add(new Trip("Trip"+i, i));
		}
	}
	
	public static List<Booking> getBookings(){
		return bookings;
	}
	
	public static List<Booking> getBookings(Trip trip){
		List<Booking> res = new ArrayList<>();
		for (Booking booking: bookings){
			if (booking.getTrip() == trip){
				res . add(booking);
			}
		}
		
		return res;
	}
	
	public static void saveBooking(Booking booking){
		bookings.add(booking);
	}
	
	
	
	
	public static List<Person> getPersons(){
		throw new NotImplementedException();
	}
	
	public static void savePerson(Person person){
		throw new NotImplementedException();
	}
	
	
	public static List<Trip> getAvailableTrips(){
		List<Trip> res = new ArrayList<>(trips.size());
		for (Trip trip: trips){
			if (!trip.isOccupied()){
				res.add(trip);
			}
		}
		
		return res;
	}
	
	public static List<Trip> getTrips(){
		return trips;
	}
	
	public static Trip getTrip(String title){
		for (Trip trip: trips){
			if (trip.getTitle().equals(title)){
				return trip;
			}
		}
		
		return null;
	}
	
	public static void saveTrip(Trip trip){
		trips.add(trip);
	}
	
	
}
