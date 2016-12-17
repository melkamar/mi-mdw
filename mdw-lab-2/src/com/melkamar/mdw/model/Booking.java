package com.melkamar.mdw.model;

public class Booking {
	private String person;
	private Trip trip;
	
	public Booking(String person, Trip trip){
		this.person = person;
		this.trip = trip;
	}
	
	public Booking(){
		
	}
	
	public Trip getTrip(){
		return this.trip;
	}
}
