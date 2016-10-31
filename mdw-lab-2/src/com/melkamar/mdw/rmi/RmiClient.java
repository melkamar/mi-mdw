package com.melkamar.mdw.rmi;

import java.rmi.Naming;

import com.melkamar.mdw.model.Trip;

public class RmiClient {
	public static void main(String[] args) throws Exception{
        RmiInterface server = (RmiInterface)Naming.lookup("//localhost/Hello");

        
        System.out.println(server.getAllTrips());
        server.addNewTrip("Trip A", 10);
        System.out.println(server.getAllTrips());
        server.addNewTrip("Trip B", 20);
        System.out.println(server.getAllTrips());
        server.addNewTrip("Trip C", 30);
        System.out.println(server.getAllTrips());
    }
}
