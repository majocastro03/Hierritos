package server;

import clases.Usuario;
import interfaces.RMIVentas;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiceVentas extends UnicastRemoteObject implements RMIVentas {
    private Usuario user=new Usuario(Usuario.TipoUsuario.VENDEDOR,"paola","1234");//TEMP
    protected ServiceVentas() throws RemoteException {

    }

    @Override
    public boolean iniciarSesion(String usuario, String contrasena) throws RemoteException {
        if(user.getNombreUsuario().equals(usuario)&&user.getContrasena().equals(contrasena)&&user.getTipoUsuario().equals(Usuario.TipoUsuario.VENDEDOR)){
            return true;
        }
        return false;
    }
}
