
package clases;

import java.io.Serializable;
import java.util.LinkedList;
import clases.EmpresaProveedora.FormaDePago;

public class FacturaVenta implements Serializable {
    
    private Ferreteria ferreteria;
    private String fechaYHora;
    private Usuario vendedor;
    private int consecutivoDian;
    private Cliente cliente;
    private FormaDePago formaDePago;
    private LinkedList<Producto> productos;
    private double total;

    private int idFacturaVenta;

    public Ferreteria getFerreteria() {
        return ferreteria;
    }

    public void setFerreteria(Ferreteria ferreteria) {
        this.ferreteria = ferreteria;
    }

    public String getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(String fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public Usuario getVendedor() {
        return vendedor;
    }
    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    public int getConsecutivoDian() {
        return consecutivoDian;
    }

    public void setConsecutivoDian(int consecutivoDian) {
        this.consecutivoDian = consecutivoDian;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public FormaDePago getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(FormaDePago formaDePago) {
        this.formaDePago = formaDePago;
    }

    public LinkedList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(LinkedList<Producto> productos) {
        this.productos = productos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdFacturaVenta() {return idFacturaVenta;
    }

    public void setIdFacturaVenta(int idFacturaVenta) {
        this.idFacturaVenta = idFacturaVenta;
    }
}
