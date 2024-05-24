package client;

import clases.*;
import interfaces.RMIVentas;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class Client implements RMIVentas {

    public static Client client = new Client("localhost","5001","servicioVentas");
    private RMIVentas service;
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
            service = (RMIVentas) Naming.lookup(url);
            return true;
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            return false;
        }
    }

    @Override
    public boolean iniciarSesion(String usuario, String contrasena) throws RemoteException {
        try{
            service = (RMIVentas) Naming.lookup(url);
            return service.iniciarSesion(usuario,contrasena);
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List listaProductosInventario() throws RemoteException {
        try {
            service = (RMIVentas) Naming.lookup(url);
            return service.listaProductosInventario();
        }catch (MalformedURLException | RemoteException | NotBoundException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Cliente buscarCliente(String telefono) throws RemoteException {
        try {
            service = (RMIVentas) Naming.lookup(url);
            return service.buscarCliente(telefono);
        }catch (MalformedURLException | RemoteException | NotBoundException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Producto buscarProducto(String codigo) throws RemoteException {
        try {
            service = (RMIVentas) Naming.lookup(url);
            return service.buscarProducto(codigo);
        }catch (MalformedURLException | RemoteException | NotBoundException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int agregarCliente(Cliente cliente) throws RemoteException {
        try {
            service = (RMIVentas) Naming.lookup(url);
            return service.agregarCliente(cliente);
        }catch (MalformedURLException | RemoteException | NotBoundException e){
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public Usuario obtenerVendedor(String usuario, String contrasena) throws RemoteException {
        try {
            service = (RMIVentas) Naming.lookup(url);
            return service.obtenerVendedor(usuario,contrasena);
        }catch (MalformedURLException | RemoteException | NotBoundException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int enviarFactura(FacturaVenta facturaVenta) throws RemoteException {
        try {
            service = (RMIVentas) Naming.lookup(url);
            return service.enviarFactura(facturaVenta);
        }catch (MalformedURLException | RemoteException | NotBoundException e){
            e.printStackTrace();
            return -3;
        }
    }

    @Override
    public FacturaVenta pagarCotizacion(String id, EmpresaProveedora.FormaDePago formaDePago) throws RemoteException {
        try {
            service = (RMIVentas) Naming.lookup(url);
            return service.pagarCotizacion(id,formaDePago);
        }catch (MalformedURLException | RemoteException | NotBoundException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean cantidadSuficiente(double cantidadPedida, int idProducto) throws RemoteException {
        try {
            service = (RMIVentas) Naming.lookup(url);
            return service.cantidadSuficiente(cantidadPedida,idProducto);
        }catch (MalformedURLException | RemoteException | NotBoundException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public FacturaVenta buscarCotizacion(String id) throws RemoteException {
        try {
            service = (RMIVentas) Naming.lookup(url);
            return service.buscarCotizacion(id);
        }catch (MalformedURLException | RemoteException | NotBoundException e){
            e.printStackTrace();
            return null;
        }
    }

}
