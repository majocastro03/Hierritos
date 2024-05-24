
package clases;

import java.io.Serializable;

public class Persona implements Serializable {
    public enum TipoDocumento implements Serializable {
        CEDULA_CIUDADANIA, CEDULA_EXTRANJERIA, PASAPORTE,NIT;
    }
    
    protected String id;
    protected String nombres;
    protected String telefono;
    protected TipoDocumento tipoDocumento;
    protected String numDocumento;
    protected String direccion;
    protected String correo;
    
    public Persona() {
    }

    public Persona(String nombres, TipoDocumento tipoDocumento, String numDocumento) {
        this.nombres = nombres;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
    }

    public Persona(String nombres, String telefono, TipoDocumento tipoDocumento, String numDocumento, String direccion, String correo) {
        this.nombres = nombres;
        this.telefono = telefono;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.direccion = direccion;
        this.correo = correo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
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

