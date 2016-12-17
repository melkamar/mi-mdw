package com.melka.mdw;

import java.util.ArrayList;
import java.util.List;

public abstract class Event {
	public String destination;
	public List<String> bookings;
	public int capacity;
	
	public Event(String destination, int capacity) {
		super();
		this.destination = destination;
		this.capacity = capacity;
		bookings = new ArrayList<String>();
	}
	
	public boolean isFull(){
		return bookings.size() >= capacity;
	}
	
	public boolean addBooking(String booking){
		if (isFull()) return false;
		
		bookings.add(booking);
		return true;
	}
	
	@Override
	public abstract String toString();
}
