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
 * 09.11.2016 23:10
 */
@WebServlet(name = "PayBookingServlet", urlPatterns = {"/paybooking"})
public class PayBookingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sessionId = null;
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("sessionid")) {
                sessionId = cookie.getValue();
            }
        }

        if (sessionId == null) {
            response.getWriter().println("No session id provided. Quitting.");
            return;
        }

        if (!Bookings.exists(sessionId)) {
            response.getWriter().println("Session ID does not exist.");
            return;
        }

        boolean result = Bookings.setStatus(sessionId, Status.COMPLETED);
        if (result) {
            response.getWriter().println("Completed the booking. Thank you.");
        } else {
            response.getWriter().println("Booking could not be finalized for: " + Bookings.getBooking(sessionId).name);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
