
package clases;

import java.io.Serializable;

public class Usuario extends Persona implements Serializable {
    
    public enum TipoUsuario implements Serializable {
        INGENIERO, GERENTE, VENDEDOR, BODEGUERO;
    }
    
    protected TipoUsuario tipoUsuario;
    protected String nombreUsuario;
    protected String contrasena;

    public Usuario() {
    }

    public Usuario(TipoUsuario tipoUsuario, String nombreUsuario, String contrasena) {
        this.tipoUsuario = tipoUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public Usuario(TipoUsuario tipoUsuario, String nombreUsuario, String contrasena, String nombres, TipoDocumento tipoDocumento, String numDocumento) {
        super(nombres, tipoDocumento, numDocumento);
        this.tipoUsuario = tipoUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public Usuario(TipoUsuario tipoUsuario, String nombreUsuario, String contrasena, String nombres, String telefono, TipoDocumento tipoDocumento, String numDocumento, String direccion, String correo) {
        super(nombres, telefono, tipoDocumento, numDocumento, direccion, correo);
        this.tipoUsuario = tipoUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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
