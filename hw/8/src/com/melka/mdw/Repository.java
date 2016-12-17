package com.melka.mdw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Repository {
	private static Flight[] flightArr = new Flight[]{
			new Flight("PRG", 2),
			new Flight("NCL", 1),
			new Flight("LHR", 3),
			new Flight("JFK", 2),
			new Flight("LAX", 2)
			};
	private static Trip[] tripArr = new Trip[]{
			new Trip("Pilsen", 2),
			new Trip("Durham", 1),
			new Trip("Dejvice", 2),
			new Trip("Hell", 9999)
	};
	public static List<Flight> flights = new ArrayList<>(Arrays.asList(flightArr));
	public static List<Trip> trips = new ArrayList<>(Arrays.asList(tripArr));
	
	public static Flight getFlight(String destination){
		System.out.println("getFlight looking for "+destination);
		System.out.println("  flights count: "+flights.size());
		for (Flight flight: flights){
			System.out.println("Checking "+flight.destination);
			if (flight.destination.equals(destination))
				return flight;
		}
		
		return null;
	}
	
	public static Trip getTrip(String destination){
		for (Trip trip: trips){
			if (trip.destination.equals(destination))
				return trip;
		}
		
		return null;
	}
	
	public static String bookFlight(String destination, String name){
		System.out.println("bookFlight: ["+destination+"].");
		Flight flight = getFlight(destination);
		if (flight==null) return "No such flight found.";
		if (flight.isFull()) return "Flight is already full.";
		
		flight.addBooking(name);
		return "Booked flight to "+destination+" for name \""+name+"\"";
	}
	
	public static String bookTrip(String destination, String name){
		Trip trip = getTrip(destination);
		if (trip==null) return "No such trip found.";
		if (trip.isFull()) return "Trip is already full.";
		
		trip.addBooking(name);
		return "Booked trip to "+destination+" for name \""+name+"\"";
	}
}
