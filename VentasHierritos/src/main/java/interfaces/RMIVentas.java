package interfaces;

import clases.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RMIVentas extends Remote {
    public boolean iniciarSesion(String usuario, String contrasena) throws RemoteException;
    public List listaProductosInventario() throws RemoteException;
    public Cliente buscarCliente (String telefono) throws RemoteException;

    public Producto buscarProducto (String codigo) throws RemoteException;

    public int agregarCliente(Cliente cliente) throws RemoteException;

    public Usuario obtenerVendedor(String usuario, String contrasena) throws RemoteException;
    public int enviarFactura(FacturaVenta facturaVenta) throws RemoteException;

    public FacturaVenta pagarCotizacion(String id, EmpresaProveedora.FormaDePago formaDePago) throws RemoteException;

    public boolean cantidadSuficiente(double cantidadPedida, int idProducto) throws RemoteException;

    FacturaVenta buscarCotizacion(String id) throws RemoteException;
}
