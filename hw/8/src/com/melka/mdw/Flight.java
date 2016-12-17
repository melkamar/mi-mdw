package com.melka.mdw;

import java.util.ArrayList;
import java.util.List;

public class Flight extends Event{
	public Flight(String destination, int capacity) {
		super(destination, capacity);
	}

	@Override
	public String toString() {
		return "Flight to "+destination+". Bookings: "+this.bookings.size()+"/"+this.capacity;
	}
}
