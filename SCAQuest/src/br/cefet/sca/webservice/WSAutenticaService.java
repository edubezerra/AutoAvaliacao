/**
 * WSAutenticaService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.cefet.sca.webservice;

public interface WSAutenticaService extends javax.xml.rpc.Service {
    public java.lang.String getWSAutenticaAddress();

    public br.cefet.sca.webservice.WSAutenticaImpl getWSAutentica() throws javax.xml.rpc.ServiceException;

    public br.cefet.sca.webservice.WSAutenticaImpl getWSAutentica(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
