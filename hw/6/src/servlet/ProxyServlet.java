package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProxyServlet
 */
public class ProxyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// index of the server last used (to properly change them using round robin)
    private int lastServerIndex = 0;
    
    private static final String[] serverPool = new String[]{
    		"http://147.32.233.18:8888/MI-MDW-LastMinute1/list",
    		"http://147.32.233.18:8888/MI-MDW-LastMinute2/list",
    		"http://147.32.233.18:8888/MI-MDW-LastMinute3/list"
    };

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("***************************");
    	
    	// Check for healthy servers with each incoming request.
    	// Could be done more properly using a background task, but this will suffice for now.
    	List<String> healthyServers = getHealthyServers();
    	if (healthyServers.size()==0){
    		response.getWriter().append("No available servers.");
    		response.setStatus(500);
    		return;
    	} else {
    		System.out.println("Healthy servers:");
    		for (String server: healthyServers){
        		System.out.println("    "+server);
    		}
    	}
    	
    	// Increment server index to use a next one
    	lastServerIndex = (lastServerIndex + 1) % healthyServers.size();
    	String url = serverPool[lastServerIndex];
    	System.out.println("Using server "+url);
    	
    	// Simply copy the response
        HttpURLConnection connection = (HttpURLConnection) (new URL(url)).openConnection();
        // HTTP method
        connection.setRequestMethod("GET");
        
        // copy headers
        for (Object key: Collections.list(request.getHeaderNames())){
        	connection.setRequestProperty((String)key, request.getHeader((String)key));
        }
        
        // copy body
        BufferedReader inputStream = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        ServletOutputStream sout = response.getOutputStream();
        while ((inputLine = inputStream.readLine()) != null) {
            sout.write(inputLine.getBytes());
        }
        
        // close
        inputStream.close();
        sout.flush();
    }
    
    protected List<String> getHealthyServers(){
    	ArrayList<String> healthyServers = new ArrayList<>(serverPool.length);
    	for (String server: serverPool){
    		if (serverHealthy(server))
    			healthyServers.add(server);
    	}
    	
    	return healthyServers;
    }
    
    protected boolean serverHealthy(String url){
    	 HttpURLConnection connection;
		try {
			connection = (HttpURLConnection) (new URL(url)).openConnection();
			connection.setRequestMethod("GET");
	    	int code = connection.getResponseCode();
	    	return code < 400;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    }

}
