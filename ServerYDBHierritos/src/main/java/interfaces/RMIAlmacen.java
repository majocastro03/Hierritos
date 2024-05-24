package interfaces;

import clases.EmpresaProveedora;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RMIAlmacen extends Remote {
    public boolean iniciarSesion(String usuario, String contrasena) throws RemoteException;

    public EmpresaProveedora buscarProveedor(String nitONombre) throws RemoteException;

    public List ListaProductosInventario () throws RemoteException;


}
