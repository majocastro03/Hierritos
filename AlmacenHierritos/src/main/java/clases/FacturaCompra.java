
package clases;

import clases.EmpresaProveedora.FormaDePago;

import java.io.Serializable;
import java.util.LinkedList;

public class FacturaCompra implements Serializable {
    
    private EmpresaProveedora empresaProveedora;
    private String nombreVendedor;
    private LinkedList<Producto> productos;
    private FormaDePago formaDePago;
    private double total;

    private int idFacturaCompra;

    public FacturaCompra() {
    }

    public FacturaCompra(EmpresaProveedora empresaProveedora, String nombreVendedor, LinkedList<Producto> productos, FormaDePago formaDePago) {
        this.empresaProveedora = empresaProveedora;
        this.nombreVendedor = nombreVendedor;
        this.productos = productos;
        this.formaDePago = formaDePago;
    }

    public EmpresaProveedora getEmpresaProveedora() {
        return empresaProveedora;
    }

    public void setEmpresaProveedora(EmpresaProveedora empresaProveedora) {
        this.empresaProveedora = empresaProveedora;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public LinkedList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(LinkedList<Producto> productos) {
        this.productos = productos;
    }

    public FormaDePago getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(FormaDePago formaDePago) {
        this.formaDePago = formaDePago;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdFacturaCompra() {
        return idFacturaCompra;
    }

    public void setIdFacturaCompra(int idFacturaCompra) {
        this.idFacturaCompra = idFacturaCompra;
    }
}
