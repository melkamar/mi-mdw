package com.melka.mdw;

import java.util.Date;

public class Booking {
	String name;
	String from;
	String to;
	Date departureTime;
	Date arrivalTime;
	int id;
	public Booking(String name, String from, String to, Date departureTime, Date arrivalTime) {
		super();
		this.name = name;
		this.from = from;
		this.to = to;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.id = Booking.getNextId();
	}
	
	static int id_next = 1;
	public static int getNextId(){
		return id_next++;
	}
	@Override
	public String toString() {
		return "Booking [name=" + name + ", from=" + from + ", to=" + to + ", departureTime=" + departureTime
				+ ", arrivalTime=" + arrivalTime + ", id=" + id + "]";
	}
	
	
	
}
