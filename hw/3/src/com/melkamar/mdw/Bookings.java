package com.melkamar.mdw;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

/**
 * Created by Martin Melka (martin.melka@gmail.com)
 * 09.11.2016 22:22
 */
public class Bookings {
    private static Set<String> namesTaken = new HashSet<>(); // Dirty, but whatever.
    private static Map<String, Booking> bookings = new HashMap<>();

    public static boolean exists(String cookie) {
        return bookings.get(cookie) != null;
    }

    public static boolean setStatus(String cookie, Status newStatus) {
        Booking booking = bookings.get(cookie);
        if (booking == null) return false;

        switch (newStatus) {
            case NEW:
                return false;

            case WAITING:
                if (booking.status != Status.NEW) return false;
                booking.status = Status.WAITING;
                bookings.put(cookie, booking);
                return true;

            case COMPLETED:
                if (booking.status != Status.WAITING) return false;

                booking.status = Status.COMPLETED;
                bookings.remove(cookie);
                namesTaken.remove(booking.name);
                return true;

            default:
                throw new NotImplementedException();
        }
    }

    public static Booking getBooking(String cookie) {
        return bookings.get(cookie);
    }

    public static boolean createBooking(String cookie, String name) {
        if (namesTaken.contains(name)) {
            return false;
        }

        bookings.put(cookie, new Booking(name));
        namesTaken.add(name);

        System.out.println("Booking created. Total count: " + bookings.size());
        for (String key : bookings.keySet()) {
            System.out.println("    " + key);
        }
        return true;
    }
}

class Booking {
    public Status status;
    public String name;

    public Booking(String name) {
        this.name = name;
        this.status = Status.NEW;
    }
}

enum Status {
    NEW, WAITING, COMPLETED
}
