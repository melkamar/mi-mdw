package com.melkamar.mdw.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.melkamar.mdw.model.Trip;

public interface RmiInterface extends Remote {
	public void addNewTrip(String title, int capacity) throws RemoteException;
	public List<Trip> getAllTrips() throws RemoteException;

}
