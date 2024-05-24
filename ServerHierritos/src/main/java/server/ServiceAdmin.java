package server;

import clases.Usuario;
import interfaces.RMIAdmin;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiceAdmin extends UnicastRemoteObject implements RMIAdmin {
    private Usuario user=new Usuario(Usuario.TipoUsuario.VENDEDOR,"paola","1234");//TEMP
    protected ServiceAdmin() throws RemoteException {

    }

    @Override
    public boolean iniciarSesion(String usuario, String contrasena) throws RemoteException {
        if(user.getNombreUsuario().equals(usuario)&&user.getContrasena().equals(contrasena)&&user.getTipoUsuario().equals(Usuario.TipoUsuario.GERENTE)){
            return true;
        }
        return false;
    }
}