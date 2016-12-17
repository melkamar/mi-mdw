/**
 * TripBookingServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.melka.autocreated;

public class TripBookingServiceServiceLocator extends org.apache.axis.client.Service implements com.melka.autocreated.TripBookingServiceService {

    public TripBookingServiceServiceLocator() {
    }


    public TripBookingServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TripBookingServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TripBookingServicePort
    private java.lang.String TripBookingServicePort_address = "http://10.0.2.15:7001/8/TripBookingServiceService";

    public java.lang.String getTripBookingServicePortAddress() {
        return TripBookingServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TripBookingServicePortWSDDServiceName = "TripBookingServicePort";

    public java.lang.String getTripBookingServicePortWSDDServiceName() {
        return TripBookingServicePortWSDDServiceName;
    }

    public void setTripBookingServicePortWSDDServiceName(java.lang.String name) {
        TripBookingServicePortWSDDServiceName = name;
    }

    public com.melka.autocreated.TripBookingService getTripBookingServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TripBookingServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTripBookingServicePort(endpoint);
    }

    public com.melka.autocreated.TripBookingService getTripBookingServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.melka.autocreated.TripBookingServicePortBindingStub _stub = new com.melka.autocreated.TripBookingServicePortBindingStub(portAddress, this);
            _stub.setPortName(getTripBookingServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTripBookingServicePortEndpointAddress(java.lang.String address) {
        TripBookingServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.melka.autocreated.TripBookingService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.melka.autocreated.TripBookingServicePortBindingStub _stub = new com.melka.autocreated.TripBookingServicePortBindingStub(new java.net.URL(TripBookingServicePort_address), this);
                _stub.setPortName(getTripBookingServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("TripBookingServicePort".equals(inputPortName)) {
            return getTripBookingServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://handmade.service.mdw.melka.com/", "TripBookingServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://handmade.service.mdw.melka.com/", "TripBookingServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TripBookingServicePort".equals(portName)) {
            setTripBookingServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
