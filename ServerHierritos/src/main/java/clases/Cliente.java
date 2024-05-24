
package clases;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable {
    
    public enum TipoPersona implements Serializable{
        NATURAL, JURIDICA;
    }

    private TipoPersona tipoPersona;
    private boolean responsableDeIva;
    private boolean clienteFrecuente;

    public Cliente() {
        this.clienteFrecuente = false;
    }

    public Cliente(TipoPersona tipoPersona, boolean responsableDeIva) {
        this.tipoPersona = tipoPersona;
        this.responsableDeIva = responsableDeIva;
        this.clienteFrecuente = false;
    }

    public Cliente(TipoPersona tipoPersona, boolean responsableDeIva, String nombres, TipoDocumento tipoDocumento, String numDocumento) {
        super(nombres, tipoDocumento, numDocumento);
        this.tipoPersona = tipoPersona;
        this.responsableDeIva = responsableDeIva;
        this.clienteFrecuente = false;
    }

    public Cliente(TipoPersona tipoPersona, boolean responsableDeIva, String nombres, String telefono, TipoDocumento tipoDocumento, String numDocumento, String direccion, String correo) {
        super(nombres, telefono, tipoDocumento, numDocumento, direccion, correo);
        this.tipoPersona = tipoPersona;
        this.responsableDeIva = responsableDeIva;
        this.clienteFrecuente = false;
    }

    public boolean getClienteFrecuente() {
        return clienteFrecuente;
    }

    public void setClienteFrecuente(boolean clienteFrecuente) {
        this.clienteFrecuente = clienteFrecuente;
    }

    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public boolean getResponsableDeIva() {
        return responsableDeIva;
    }

    public void setResponsableDeIva(boolean responsableDeIva) {
        this.responsableDeIva = responsableDeIva;
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
