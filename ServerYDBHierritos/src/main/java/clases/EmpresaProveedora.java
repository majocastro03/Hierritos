
package clases;

import java.io.Serializable;
import java.util.LinkedList;

public class EmpresaProveedora implements Serializable {
    public enum FormaDePago implements Serializable {
        EFECTIVO, TARJETA, TRANSFERENCIA;
    }
    private String nombre;
    private String nit;
    private LinkedList<FormaDePago> formasDePago;
    private LinkedList<Producto> productos;
    private String banco;
    private String cuentaBancaria;

    private int id;

    public EmpresaProveedora() {
    }

    public EmpresaProveedora(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
    }

    public EmpresaProveedora(String nombre, String nit, LinkedList<FormaDePago> formasDePago, String banco, String cuentaBancaria) {
        this.nombre = nombre;
        this.nit = nit;
        this.formasDePago = formasDePago;
        this.banco = banco;
        this.cuentaBancaria = cuentaBancaria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public LinkedList<FormaDePago> getFormasDePago() {
        return formasDePago;
    }

    public void setFormasDePago(LinkedList<FormaDePago> formasDePago) {
        this.formasDePago = formasDePago;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(String cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public LinkedList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(LinkedList<Producto> productos) {
        this.productos = productos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
