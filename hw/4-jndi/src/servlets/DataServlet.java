package servlets;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Martin Melka (martin.melka@gmail.com)
 * 11.11.2016 1:12
 */
@WebServlet(name = "DataServlet", value = "/showdata")
public class DataServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Context ctx = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/melkamardb");

            statement = ds.getConnection().createStatement();
            resultSet = statement.executeQuery("SELECT * FROM records");

            PrintWriter out = response.getWriter();
            while (resultSet.next()) {
                out.println("*********************************************");
                out.println("type: " + resultSet.getString("type"));
                out.println("location: " + resultSet.getString("location"));
                out.println("capacity: " + resultSet.getString("capacity"));
                out.println("occupied: " + resultSet.getString("occupied"));
                out.println("trip: " + resultSet.getString("trip"));
                out.println("person: " + resultSet.getString("person"));
                out.println("*********************************************");
                out.println();
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
