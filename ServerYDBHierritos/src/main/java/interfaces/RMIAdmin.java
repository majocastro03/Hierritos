package interfaces;

import clases.Cliente;
import clases.Usuario;
import clases.Vendedor;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIAdmin extends Remote {
    public boolean iniciarSesion(String usuario, String contrasena) throws RemoteException;

    public Vendedor obtenerVendedorMes( ) throws RemoteException;

    public String informeVentas() throws RemoteException;

    public String informeBalanceMensual() throws RemoteException;

    public String informeDevoluciones() throws RemoteException;

    public Cliente buscarCliente (String telefono) throws RemoteException;
    public Usuario buscarUsuario (String telefono) throws RemoteException;

}