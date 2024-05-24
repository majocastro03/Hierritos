
package clases;

import java.io.Serializable;

public class Producto implements Serializable {
    
    private String codigo;
    private String nombre;
    private String descripcion;
    private double precioVenta;
    private double precioCompra;
    private double precioTotal;
    private double existencias;
    private double cantidadMinima;
    private double cantidadMaxima;
    private double pDescuento;
    private double pIva;

    public Producto() {
    }

    public Producto(String codigo, String nombre, String descripcion, double precioVenta, double existencias, double pIva, double precioCompra) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
        this.existencias = existencias;
        this.pIva = pIva;
        this.precioCompra = precioCompra;
    }

    public Producto(String codigo, String nombre, String descripcion, double precioVenta, double existencias, double pDescuento, double pIva, double precioCompra) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
        this.existencias = existencias;
        this.pDescuento = pDescuento;
        this.pIva = pIva;
        this.precioCompra = precioCompra;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getExistencias() {
        return existencias;
    }

    public void setExistencias(double existencias) {
        this.existencias = existencias;
    }

    public double getpDescuento() {
        return pDescuento;
    }

    public void setpDescuento(double pDescuento) {
        this.pDescuento = pDescuento;
    }

    public double getpIva() {
        return pIva;
    }

    public void setpIva(double pIva) {
        this.pIva = pIva;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(double cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public double getCantidadMaxima() {
        return cantidadMaxima;
    }

    public void setCantidadMaxima(double cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
    }
}
