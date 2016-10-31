package com.melkamar.mdw.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Trip implements Serializable {
	private String title;
	private int capacity;
	//private List<Booking> bookings;
	
	public Trip(String title, int capacity){
		this.title = title;
		this.capacity = capacity;
		//bookings = new ArrayList<Booking>();
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public int getCapacity(){
		return this.capacity;
	}
	
	private List<Booking> getBookings(){
		return Repository.getBookings(this);
	}
	
	public boolean isOccupied(){
		return this.getBookings().size() >= capacity; 
	}
	
	@Override
	public String toString(){
		return "Title: "+title+" (capacity "+capacity+", bookings:"+this.getBookings().size()+") Availability: "+(this.isOccupied()?"Occupied":"FREE");
	}
}
