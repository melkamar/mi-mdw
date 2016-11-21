package com.melkamar.mdw;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by Martin Melka (martin.melka@gmail.com)
 * 09.11.2016 19:25
 */
@WebServlet(name = "NewBookingServlet", urlPatterns = {"/newbooking"})
public class NewBookingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String cookieValue = new SessionIdentifierGenerator().nextSessionId();

        if (!Bookings.createBooking(cookieValue, name)) {
            response.getWriter().println("Booking for this name already exists.");
            return;
        }

        Cookie cookie = new Cookie("sessionid", cookieValue);
        response.addCookie(cookie);

        response.getWriter().println("Created a booking for: " + name);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Example Servlet: " + (new Date()) + "</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
