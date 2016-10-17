package com.melkamar.mdw.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.melkamar.mdw.model.Booking;
import com.melkamar.mdw.model.Repository;
import com.melkamar.mdw.model.Trip;
import com.sun.mail.iap.Argument;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Servlet implementation class BookingServlet
 */
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				String personName = request.getParameter("person");
				String tripTitle = request.getParameter("trip");
				
				Trip trip = Repository.getTrip(tripTitle);
				
				if (trip == null){
					throw new NotImplementedException();
				}
				
				if (trip.isOccupied()){
					throw new NotImplementedException();
				}
				
				Booking booking = new Booking(personName, trip);
				Repository.saveBooking(booking);
				
				
				System.out.println("Booking saved: "+booking);
				response.getWriter().println("<html><head><title>Booking saved.</title></head>"
						+ "<body>Booking saved.<br/><br/><a href=\"index.jsp\">Home</a>"
						+ "</body></html>");
	}

}
