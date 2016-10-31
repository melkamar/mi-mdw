package com.melkamar.mdw.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.melkamar.mdw.model.Trip;
import com.melkamar.mdw.persistence.DerbyDAO;
import com.melkamar.mdw.persistence.DerbyHelper;

public class RmiServer extends UnicastRemoteObject implements RmiInterface {

	protected RmiServer() throws RemoteException {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void addNewTrip(String title, int capacity) {
		try {
			Trip trip = new Trip(title,capacity);
			DerbyDAO.saveTrip(trip);
		} catch (SQLIntegrityConstraintViolationException e) {
			// duplicate object
			System.out.println("Trip "+title+" already present in database.");
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Trip> getAllTrips() {
		return DerbyDAO.getTrips();
	}
	
	public static void main(String [] args){
		try {
			DerbyHelper.initDb(DerbyHelper.createConnection());
			
			LocateRegistry.createRegistry(1099);
			 
	        RmiServer server = new RmiServer();
	        Naming.rebind("//0.0.0.0/Hello", server);
	
	        System.out.println("Server started...");
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
