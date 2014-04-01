/**
 * WSAutenticaServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.cefet.sca.webservice;

public class WSAutenticaServiceLocator extends org.apache.axis.client.Service implements br.cefet.sca.webservice.WSAutenticaService {

    public WSAutenticaServiceLocator() {
    }


    public WSAutenticaServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WSAutenticaServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WSAutentica  
    
    private java.lang.String WSAutentica_address = "http://teammobile.kinghost.net/SCAQuest/services/WSAutentica";
    //private java.lang.String WSAutentica_address = "http://localhost:8080/SCAQuest/services/WSAutentica";
     

    public java.lang.String getWSAutenticaAddress() {
        return WSAutentica_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSAutenticaWSDDServiceName = "WSAutentica";

    public java.lang.String getWSAutenticaWSDDServiceName() {
        return WSAutenticaWSDDServiceName;
    }

    public void setWSAutenticaWSDDServiceName(java.lang.String name) {
        WSAutenticaWSDDServiceName = name;
    }

    public br.cefet.sca.webservice.WSAutenticaImpl getWSAutentica() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSAutentica_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSAutentica(endpoint);
    }

    public br.cefet.sca.webservice.WSAutenticaImpl getWSAutentica(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.cefet.sca.webservice.WSAutenticaSoapBindingStub _stub = new br.cefet.sca.webservice.WSAutenticaSoapBindingStub(portAddress, this);
            _stub.setPortName(getWSAutenticaWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWSAutenticaEndpointAddress(java.lang.String address) {
        WSAutentica_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.cefet.sca.webservice.WSAutentica.class.isAssignableFrom(serviceEndpointInterface)) {
                br.cefet.sca.webservice.WSAutenticaSoapBindingStub _stub = new br.cefet.sca.webservice.WSAutenticaSoapBindingStub(new java.net.URL(WSAutentica_address), this);
                _stub.setPortName(getWSAutenticaWSDDServiceName());
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
        if ("WSAutentica".equals(inputPortName)) {
            return getWSAutentica();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservice.sca.cefet.br", "WSAutenticaService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservice.sca.cefet.br", "WSAutentica"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WSAutentica".equals(portName)) {
            setWSAutenticaEndpointAddress(address);
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
