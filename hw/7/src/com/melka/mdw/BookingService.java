package com.melka.mdw;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class BookingService {
	public String addBooking(@WebParam(name = "name") String name, @WebParam(name = "from") String from,
			@WebParam(name = "to") String to, @WebParam(name = "departureTime") String departureTime,
			@WebParam(name = "arrivalTime") String arrivalTime) {

		Date departureT;
		Date arrivalT;
		try {
			departureT = new SimpleDateFormat("HH:mm:ss yyyy-MM-dd").parse(departureTime);
			arrivalT = new SimpleDateFormat("HH:mm:ss yyyy-MM-dd").parse(arrivalTime);
		} catch (ParseException e) {
			e.printStackTrace();
			return "Could not parse arrival or departure time!";
		}

		Booking booking = new Booking(name, from, to, departureT, arrivalT);
		Repository.addBooking(booking);

		return "Booking with ID " + booking.id + " was created.";
	}

	public String listBookings() {
		StringBuilder builder = new StringBuilder();
		for (Booking booking : Repository.getBookings()) {
			builder.append(booking.toString());
			builder.append("\n");
		}

		return builder.toString();
	}

	public String removeBooking(int id) {
		boolean result = Repository.removeBooking(id);
		if (result) {
			return "Booking deleted";
		} else {
			return "Booking was not found.";
		}
	}
	
	public String getBookingsCount(){
		return Repository.getBookings().size()+"";
	}

	public String updateBooking(@WebParam(name = "id") int id, @WebParam(name = "name") String name, @WebParam(name = "from") String from,
			@WebParam(name = "to") String to, @WebParam(name = "departureTime") String departureTime,
			@WebParam(name = "arrivalTime") String arrivalTime) {
		Booking booking = Repository.getBooking(id);

		if (name != null && !name.isEmpty()) {
            booking.name = name;
        }
        if (from != null && !from.isEmpty()) {
            booking.from = from;

        }
        if (to != null && !to.isEmpty()) {
            booking.to = to;

        }

        try {
            if (departureTime != null && !departureTime.isEmpty()) {
                booking.departureTime = new SimpleDateFormat("HH:mm:ss yyyy-MM-dd").parse(departureTime);
            }

            if (arrivalTime != null && !arrivalTime.isEmpty()) {
                booking.arrivalTime = new SimpleDateFormat("HH:mm:ss yyyy-MM-dd").parse(arrivalTime);
            }
        } catch (ParseException e) {
            return "Could not parse arrival or departure time!";
        }
		
		return "Updated.";
	}
	
	public String cleanup(){
		Repository.clearBookings();
		return "All bookings deleted.";
	}
}
