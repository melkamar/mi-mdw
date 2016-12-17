package com.melka.autocreated;

public class FlightBookingServiceProxy implements com.melka.autocreated.FlightBookingService {
  private String _endpoint = null;
  private com.melka.autocreated.FlightBookingService flightBookingService = null;
  
  public FlightBookingServiceProxy() {
    _initFlightBookingServiceProxy();
  }
  
  public FlightBookingServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initFlightBookingServiceProxy();
  }
  
  private void _initFlightBookingServiceProxy() {
    try {
      flightBookingService = (new com.melka.autocreated.FlightBookingServiceServiceLocator()).getFlightBookingServicePort();
      if (flightBookingService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)flightBookingService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)flightBookingService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (flightBookingService != null)
      ((javax.xml.rpc.Stub)flightBookingService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.melka.autocreated.FlightBookingService getFlightBookingService() {
    if (flightBookingService == null)
      _initFlightBookingServiceProxy();
    return flightBookingService;
  }
  
  public java.lang.String bookFlight(java.lang.String personName, java.lang.String destinationName) throws java.rmi.RemoteException{
    if (flightBookingService == null)
      _initFlightBookingServiceProxy();
    return flightBookingService.bookFlight(personName, destinationName);
  }
  
  
}