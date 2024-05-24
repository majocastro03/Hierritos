package server;

import Database.Consulta;
import clases.Cliente;
import clases.Persona;
import clases.Usuario;
import clases.Vendedor;
import interfaces.RMIAdmin;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiceAdmin extends UnicastRemoteObject implements RMIAdmin {
    private boolean sesionIniciada = false;

    protected ServiceAdmin() throws RemoteException {

    }

    @Override
    public boolean iniciarSesion(String usuario, String contrasena) throws RemoteException {
        Consulta consulta = new Consulta();
        String contrasenaDB = consulta.obtenerContraseñaPorNombre(usuario);
        if(contrasenaDB!=null&&contrasena!=null){
            if(contrasenaDB.equals(contrasena)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Vendedor obtenerVendedorMes() throws RemoteException {

        Vendedor vendedorPrueba = new Vendedor(Usuario.TipoUsuario.VENDEDOR, "PepeVentas" , "1234", "Pepe", Persona.TipoDocumento.CEDULA_CIUDADANIA, "63517971");
        return vendedorPrueba;

    }

    @Override
    public String informeVentas() throws RemoteException {
        String test = "Informe Ventas";

        return test;
    }

    @Override
    public String informeBalanceMensual() throws RemoteException {
        String test = "Informe Balance Mensual";

        return test;
    }

    @Override
    public String informeDevoluciones() throws RemoteException {
        String test = "Informe Devoluciones";

        return test;
    }

    @Override
    public Cliente buscarCliente(String telefono) throws RemoteException {
        Cliente clienteTest = new Cliente(Cliente.TipoPersona.JURIDICA, true, "Yenifer Paola", "316533 ", Persona.TipoDocumento.CEDULA_CIUDADANIA, "1097910658", "Giron", "hpaola@gmail.com" );

        Cliente cliente = null;
        try {
            cliente = Consulta.obtenerClientePorCedula(telefono);
            if (cliente.getId() == null) {
                cliente = Consulta.obtenerClientePorTelefono(telefono);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return cliente;
    }

    @Override
    public Usuario buscarUsuario(String telefono) throws RemoteException {
        Usuario usuarioTest = new Usuario(Usuario.TipoUsuario.BODEGUERO,  "YeniferVentas", "1234",  "Paola", "3165", Persona.TipoDocumento.CEDULA_CIUDADANIA, "107910657", "Gamarra", "pepeGrillo@gmail.com" );

        Usuario usuario = null;
        try {
            usuario = Consulta.obtenerUsuarioPorId(telefono);
        }catch (Exception e){
            e.printStackTrace();
        }

        return usuarioTest;
    }

}