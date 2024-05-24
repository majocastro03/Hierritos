package server;

import Database.Consulta;
import Database.Insercion;
import Database.Update;
import clases.*;
import interfaces.RMIVentas;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ServiceVentas extends UnicastRemoteObject implements RMIVentas {

    private boolean sesionIniciada = false;
    protected ServiceVentas() throws RemoteException {

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
    public List listaProductosInventario() throws RemoteException {
        return Consulta.listaProductosStock();
    }

    @Override
    public Cliente buscarCliente(String telefono) throws RemoteException {
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
    public Producto buscarProducto(String codigo) throws RemoteException {
        Producto productoPrueba = new Producto("Codigo2","nombreTornillo",  "descripcionLargo",  200,  3,  0.19,  100);
        return productoPrueba;
    }

    @Override
    public int agregarCliente(Cliente cliente) throws RemoteException {
        int bool = -2;
        try{
            Insercion.nuevoCliente(
                    cliente.getNombres(),
                    cliente.getTelefono(),
                    cliente.getTipoDocumento().toString(),
                    cliente.getNumDocumento(),
                    cliente.getDireccion(),
                    cliente.getCorreo(),
                    cliente.getTipoPersona().toString(),
                    (cliente.getResponsableDeIva()?1:0)+"",
                    ""+(cliente.getClienteFrecuente()?1:0)
            );

            cliente = Consulta.obtenerClientePorTelefono(cliente.getTelefono());
            try{
                bool = Integer.valueOf(cliente.getId());
            }catch (Exception e){
                bool = -3;
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return bool;
        }
    }

    @Override
    public Usuario obtenerVendedor(String usuario, String contrasena) throws RemoteException {
        return Consulta.obtenerUsuarioPorNombre(usuario,contrasena);
    }

    @Override
    public int enviarFactura(FacturaVenta facturaVenta) throws RemoteException {
        int entero=-1;
        try{
            //TODO fechaYHora
            Insercion.facturasDeVenta(
                    "10-10-10",
                    ""+facturaVenta.getConsecutivoDian(),
                    facturaVenta.getFormaDePago().toString(),
                    "1",
                    facturaVenta.getVendedor().getId(),
                    facturaVenta.getCliente().getId(),
                    ""+facturaVenta.getTotal()
            );
            entero = Integer.valueOf(Consulta.ultimaFacturaVenta());
            guardarTablaFacturaVentaHasProductos(""+entero,facturaVenta.getProductos());
            if(facturaVenta.getConsecutivoDian()!=0){
                Update.consecutivoDian(""+entero);
                restarProductosDeInventario(facturaVenta.getProductos());
            }
            //TODO hacer pdf
            //AbrirPdf.abrirPdf(""+entero);
        }catch (Exception e){
            entero = -2;
            e.printStackTrace();
        }
        return entero;
    }

    @Override
    public FacturaVenta pagarCotizacion(String id, EmpresaProveedora.FormaDePago formaDePago) throws RemoteException {
        FacturaVenta facturaVenta = null;
        LinkedList<Producto> productosId = new LinkedList<>();
        boolean bool = false;
        try{
            productosId = Consulta.listaIdProductosFacturaVentaHasProductos(id);
            Update.cambiarFormaDePagoFacturaVenta(id,formaDePago.toString());
            Update.consecutivoDian(id);
            bool = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        if(bool){
            restarProductosDeInventario(productosId);
            facturaVenta = obtenerFacturaVenta(id);
            //TODO hacer pdf
            //AbrirPdf.abrirPdf(""+id);
        }
        return facturaVenta;
    }

    private FacturaVenta obtenerFacturaVenta(String id) {
        FacturaVenta facturaVenta=null;
        facturaVenta = Consulta.obtenerFacturaVentaPorId(id);
        LinkedList<Producto> productosCompletos = new LinkedList<>();
        LinkedList<Producto> productosId = Consulta.listaIdProductosFacturaVentaHasProductos(id);
        for (Producto producto : productosId) {
            productosCompletos.add(Consulta.obtenerProductoPorId(""+producto.getIdProducto()));
        }
        facturaVenta.setProductos(productosCompletos);
        return facturaVenta;
    }

    @Override
    public boolean cantidadSuficiente(double cantidadPedida, int idProducto) throws RemoteException {
        Producto producto = Consulta.obtenerProductoPorId(""+idProducto);
        return (cantidadPedida<=producto.getExistencias());
    }

    @Override
    public FacturaVenta buscarCotizacion(String id) throws RemoteException {
        return obtenerFacturaVenta(id);
    }

    private void restarProductosDeInventario(LinkedList<Producto> productos) {
        for (Producto producto : productos) {
            Update.restarExistencias(((int)producto.getExistencias()),""+producto.getIdProducto());
        }
    }

    private void guardarTablaFacturaVentaHasProductos(String idFactura,LinkedList<Producto> productos) {
        for (Producto producto : productos) {
            Insercion.productos_has_facturas_de_venta(idFactura,""+producto.getIdProducto(),""+producto.getExistencias());
        }
    }

}
