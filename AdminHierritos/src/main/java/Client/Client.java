package Client;

import clases.Cliente;
import clases.Usuario;
import clases.Vendedor;
import interfaces.RMIAdmin;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client implements RMIAdmin {

    public static Client client = new Client("localhost","5002","servicioAdmin");
    private RMIAdmin service;
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
            service = (RMIAdmin) Naming.lookup(url);
            return true;
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            return false;
        }
    }
    @Override
    public boolean iniciarSesion(String usuario, String contrasena) throws RemoteException {
        try{
            service = (RMIAdmin) Naming.lookup(url);
            return service.iniciarSesion(usuario,contrasena);
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Vendedor obtenerVendedorMes() throws RemoteException {
        try {
            service = (RMIAdmin) Naming.lookup(url);
            return service.obtenerVendedorMes();
        }catch (MalformedURLException | RemoteException | NotBoundException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String informeVentas() throws RemoteException {
        try {
            service = (RMIAdmin) Naming.lookup(url);
            return service.informeVentas();
        }catch (MalformedURLException | RemoteException | NotBoundException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String informeBalanceMensual() throws RemoteException {
        try {
            service = (RMIAdmin) Naming.lookup(url);
            return service.informeBalanceMensual();
        }catch (MalformedURLException | RemoteException | NotBoundException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String informeDevoluciones() throws RemoteException {
        try {
            service = (RMIAdmin) Naming.lookup(url);
            return service.informeDevoluciones();
        }catch (MalformedURLException | RemoteException | NotBoundException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Cliente buscarCliente(String telefono) throws RemoteException {
        try {
            service = (RMIAdmin) Naming.lookup(url);
            return service.buscarCliente(telefono);
        }catch (MalformedURLException | RemoteException | NotBoundException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Usuario buscarUsuario(String telefono) throws RemoteException {
        try {
            service = (RMIAdmin) Naming.lookup(url);
            return service.buscarUsuario(telefono);
        }catch (MalformedURLException | RemoteException | NotBoundException e){
            e.printStackTrace();
            return null;
        }
    }


}
