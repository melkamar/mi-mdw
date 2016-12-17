package com.melka.autocreated;

public class TripBookingServiceProxy implements com.melka.autocreated.TripBookingService {
  private String _endpoint = null;
  private com.melka.autocreated.TripBookingService tripBookingService = null;
  
  public TripBookingServiceProxy() {
    _initTripBookingServiceProxy();
  }
  
  public TripBookingServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initTripBookingServiceProxy();
  }
  
  private void _initTripBookingServiceProxy() {
    try {
      tripBookingService = (new com.melka.autocreated.TripBookingServiceServiceLocator()).getTripBookingServicePort();
      if (tripBookingService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)tripBookingService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)tripBookingService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (tripBookingService != null)
      ((javax.xml.rpc.Stub)tripBookingService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.melka.autocreated.TripBookingService getTripBookingService() {
    if (tripBookingService == null)
      _initTripBookingServiceProxy();
    return tripBookingService;
  }
  
  public java.lang.String bookTrip(java.lang.String personName, java.lang.String destinationName) throws java.rmi.RemoteException{
    if (tripBookingService == null)
      _initTripBookingServiceProxy();
    return tripBookingService.bookTrip(personName, destinationName);
  }
  
  
}