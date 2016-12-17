package com.melka.mdw;

import java.util.ArrayList;
import java.util.List;

public class Trip extends Event{

	public Trip(String destination, int capacity) {
		super(destination, capacity);
	}

	@Override
	public String toString() {
		return "Trip to "+destination+". Bookings: "+this.bookings.size()+"/"+this.capacity;
	}
	
	
}
