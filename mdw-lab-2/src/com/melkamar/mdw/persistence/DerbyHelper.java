package com.melkamar.mdw.persistence;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DerbyHelper {
	public static Connection createConnection() throws Exception {
		String driver = "org.apache.derby.jdbc.EmbeddedDriver";
        Class.forName(driver).newInstance();
        
        String protocol = "jdbc:derby:";
        Connection conn = DriverManager.getConnection(protocol + "derbyDB;create=true");
        return conn;
	}
	
	public static void initDb(Connection connection) throws SQLException{
		DatabaseMetaData dbmd = connection.getMetaData();
        ResultSet rs = dbmd.getTables(null, null, "TRIPS", null);
        if (rs.next()) {
            System.out.println("Table " +  rs.getString(3) + " exists, will not initialize db.");
        } else {
        	System.out.println("Database was not found. Initializing tables...");
        	
        	// Create table for trips
            Statement stmt = connection.createStatement();
            String query = "CREATE TABLE TRIPS ("
            		+ "ID INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
            		+ "TITLE VARCHAR(256) UNIQUE, "
            		+ "CAPACITY INTEGER"
            		+ ")";
            stmt.executeUpdate(query);
            stmt.close();
            
         // Create table for bookings
            stmt = connection.createStatement();
            query = "CREATE TABLE BOOKINGS ("
            		+ "ID INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
            		+ "PERSON VARCHAR(256), "
            		+ "TRIP_PK INTEGER, "
            		+ "FOREIGN KEY (TRIP_PK) REFERENCES TRIPS(ID)"
            		+ ")";
            stmt.executeUpdate(query);
            stmt.close();
 
            //stmt = connection.createStatement();
            //query = "INSERT INTO FIRSTTABLE VALUES (10,'TEN'),(20,'TWENTY'),(30,'THIRTY')";
            //stmt.executeUpdate(query);
            //stmt.close();
        }
	}
	
	public static void main(String [] args){
		try {
			Connection conn = createConnection();
			initDb(conn);
		} catch (Exception e){
			System.out.println("Exception occurred");
			System.out.println(e);
		}
	}
}
