package br.cefet.sca.webservice;

public class WSAutenticaProxy implements br.cefet.sca.webservice.WSAutenticaImpl {
  private String _endpoint = null;
  private br.cefet.sca.webservice.WSAutenticaImpl wSAutentica = null;
  
  public WSAutenticaProxy() {
    _initWSAutenticaProxy();
  }
  
  public WSAutenticaProxy(String endpoint) {
    _endpoint = endpoint;
    _initWSAutenticaProxy();
  }
  
  private void _initWSAutenticaProxy() {
    try {
      wSAutentica = (new br.cefet.sca.webservice.WSAutenticaServiceLocator()).getWSAutentica();
      if (wSAutentica != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wSAutentica)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wSAutentica)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wSAutentica != null)
      ((javax.xml.rpc.Stub)wSAutentica)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.cefet.sca.webservice.WSAutenticaImpl getWSAutentica() {
    if (wSAutentica == null)
      _initWSAutenticaProxy();
    return wSAutentica;
  }
  
  public boolean autentica(java.lang.String login, java.lang.String password) throws java.rmi.RemoteException{
    if (wSAutentica == null)
      _initWSAutenticaProxy(); 
    return wSAutentica.autentica(login, password);
  }
  
  
}