package com.melkamar.mdw;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Martin Melka (martin.melka@gmail.com)
 * 09.11.2016 22:55
 */
@WebServlet(name = "ConfirmBookingServlet", urlPatterns = {"/confirmbooking"})
public class ConfirmBookingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sessionId = null;
        for (Cookie cookie: request.getCookies()){
            if (cookie.getName().equals("sessionid")){
                sessionId = cookie.getValue();
            }
        }

        if (sessionId==null){
            response.getWriter().println("No session id provided. Quitting.");
            return;
        }

        if (!Bookings.exists(sessionId)){
            response.getWriter().println("Session ID does not exist.");
            return;
        }

        boolean result = Bookings.setStatus(sessionId, Status.WAITING);
        if (result) {
            response.getWriter().println("Updated a booking for: " + Bookings.getBooking(sessionId).name);
        } else {
            response.getWriter().println("Booking could not be updated for: " + Bookings.getBooking(sessionId).name);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
