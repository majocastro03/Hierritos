package client;

import clases.EmpresaProveedora;
import interfaces.RMIAlmacen;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class Client implements RMIAlmacen {

    public static Client client = new Client("localhost","5000","servicioAlmacen");
    private RMIAlmacen service;
    private String ip;
    private String port;
    private String serviceName;
    private String url;

    public Client(String ip, String port, String serviceName){
        this.service = null;
        this.ip = ip;
        this.port = port;
        this.serviceName = serviceName;
        this.url = "rmi://" + ip + ":" + port + "/" + serviceName;
    }

    public boolean isConnected(){
        try{
            service = (RMIAlmacen) Naming.lookup(url);
            return true;
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            return false;
        }
    }

    @Override
    public boolean iniciarSesion(String usuario, String contrasena) throws RemoteException {
        try{
            service = (RMIAlmacen) Naming.lookup(url);
            return service.iniciarSesion(usuario,contrasena);
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public EmpresaProveedora buscarProveedor(String nitONombre) throws RemoteException {
        try{
            service = (RMIAlmacen) Naming.lookup(url);
            return service.buscarProveedor(nitONombre);
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List ListaProductosInventario() throws RemoteException {
        try {
            service = (RMIAlmacen) Naming.lookup(url);
            return service.ListaProductosInventario();
        }catch (MalformedURLException | RemoteException | NotBoundException e){
            e.printStackTrace();
            return null;
        }

    }


}
