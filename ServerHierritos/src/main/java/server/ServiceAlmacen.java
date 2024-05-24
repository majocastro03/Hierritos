package server;

import clases.EmpresaProveedora;
import clases.Usuario;
import database.Consulta;
import interfaces.RMIAlmacen;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiceAlmacen extends UnicastRemoteObject implements RMIAlmacen {

    private boolean sesionIniciada = false;

    public ServiceAlmacen() throws RemoteException {
    }

    @Override
    public boolean iniciarSesion(String usuario, String contrasena) throws RemoteException {
        Consulta consulta = new Consulta();
        String contrasenaDB = consulta.obtenerContraseñaPorNombre(usuario);
        if(contrasenaDB.equals(contrasena)){
            return true;
        }
        return false;
    }

/*    @Override
    public boolean iniciarSesion(String usuario, String contrasena) throws RemoteException {
        if(user.getNombreUsuario().equals(usuario)&&user.getContrasena().equals(contrasena)&&user.getTipoUsuario().equals(Usuario.TipoUsuario.BODEGUERO)){
            return true;
        }
        return false;
    }*/

    @Override
    public EmpresaProveedora buscarProveedor(String nit) throws RemoteException {
        return new EmpresaProveedora();
    }

}
