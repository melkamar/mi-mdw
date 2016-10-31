package com.melkamar.mdw.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.melkamar.mdw.model.Trip;

public class DerbyDAO {
	
	public static Trip getTrip(String title){
		Connection connection;
		try {
			connection = DerbyHelper.createConnection();
			Statement stmt = connection.createStatement();
	        String query = "SELECT TITLE, CAPACITY FROM TRIPS "
	        		+ "WHERE TITLE=\'"+title+"\'";
	        System.out.println("Executing query: "+query);
	        ResultSet result = stmt.executeQuery(query);
	        while (result.next()){
	        	String newTitle = result.getString("TITLE");
	        	int capacity = result.getInt("CAPACITY");
	        	Trip newTrip = new Trip(title, capacity);
	        	System.out.print("Found trip of name \""+title+"\": ("+newTitle+" | "+capacity+")\n");
	        	
	        	stmt.close();
	        	return newTrip;
	        }
	        return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Trip> getTrips(){
		Connection connection;
		try {
			connection = DerbyHelper.createConnection();
			Statement stmt = connection.createStatement();

	        String query = "SELECT TITLE, CAPACITY FROM TRIPS";
	        System.out.println("Executing query: "+query);
	        ResultSet result = stmt.executeQuery(query);
	        
	        List<Trip> resList = new ArrayList<>();
	        while (result.next()){
	        	String newTitle = result.getString("TITLE");
	        	int capacity = result.getInt("CAPACITY");
	        	Trip newTrip = new Trip(newTitle, capacity);
	        	resList.add(newTrip);
	        	System.out.print("Found trip of name \""+newTitle+"\": ("+newTitle+" | "+capacity+")\n");
	        }
	        
	        stmt.close();
	        return resList;
	        
	        
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void saveTrip(Trip trip) throws SQLIntegrityConstraintViolationException{
		Connection connection;
		try {
			connection = DerbyHelper.createConnection();
			Statement stmt = connection.createStatement();
			
	        String query = "INSERT INTO TRIPS (TITLE, CAPACITY) VALUES (\'"+trip.getTitle()+"\', "+trip.getCapacity()+")";
	        System.out.println("Executing query: "+query);
	        
	        stmt.executeUpdate(query);
	        stmt.close();
	        
	        
		} catch (SQLIntegrityConstraintViolationException e){
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String [] args){
		try {
			Connection conn = DerbyHelper.createConnection();
			DerbyHelper.initDb(conn);
			
			Trip trip = new Trip("Trip1", 10);
			try {
				saveTrip(trip);
			} catch (SQLIntegrityConstraintViolationException e){
			}
			
			
			try{
				trip = new Trip("Trip2", 20);
				saveTrip(trip);
			} catch (SQLIntegrityConstraintViolationException e){
			}
			
			
			
			getTrip("Trip1");
			getTrips();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
