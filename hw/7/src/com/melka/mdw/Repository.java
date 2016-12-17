package com.melka.mdw;

import java.util.ArrayList;
import java.util.List;

public class Repository {
	static List<Booking> bookings = new ArrayList<>();
	public static void addBooking(Booking booking){
		bookings.add(booking);
	}
	
	public static List<Booking> getBookings(){
		return bookings;
	}
	
	public static Booking getBooking(int id){
		for (Booking booking: bookings){
			if (booking.id == id){
				return booking;
			}
		}
		
		return null;
	}
	
	public static boolean removeBooking(int id){
		return bookings.remove(getBooking(id));
	}
	
	public static void editBooking(){
		
	}
	
	public static void clearBookings(){
		bookings.clear();
		Booking.id_next = 1;
	}

}
