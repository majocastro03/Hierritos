
package clases;

import java.io.Serializable;

public class Ferreteria implements Serializable {
    
    private String nombre;
    private String telefono;
    private String nit;
    private String direccion;
    private String correo;

    public Ferreteria() {
    }

    public Ferreteria(String nombre, String telefono, String nit, String direccion, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.nit = nit;
        this.direccion = direccion;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
}
