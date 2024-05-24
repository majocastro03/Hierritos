package com.example.adminhierritos;

import Client.Client;
import clases.Cliente;
import clases.Persona;
import clases.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.rmi.RemoteException;

public class UsuarioActualizarInfoController {
    static Scene scene;
    static UsuarioActualizarInfoController controller;
    static Usuario usuarioActual;
    @FXML
    TextField textfieldBuscar;

    @FXML
    TextField textfieldNombreUsuario;

    @FXML
    TextField textfieldNombresTrabajador;

    @FXML
    ComboBox comboBoxTipoDoc;

    @FXML
    TextField textfieldNumDoc;

    @FXML
    TextField textfieldContrasena;

    @FXML
    TextField textfieldNumTel;

    @FXML
    ComboBox comboBoxTipoUsuario;

    public void ClickBotonBuscar() throws RemoteException {

        Usuario usuario;

        usuario = Client.client.buscarUsuario(textfieldBuscar.getText());

        if(usuario.getId()!=null) {
            usuarioActual = usuario;
            llenarEspacios(usuarioActual);

        }else if(textfieldBuscar.getText().equals("")){
            cuadroRellenarCampos();

        }else{
            usuarioActual = usuario;
            llenarEspacios(usuarioActual);

            cuadroClienteNoEncontrado();
            usuarioActual=null;
        }
    }


    public void desplegables() {
        desplegableTipoUsuario();
        desplegableTipoDocumento();
    }

    public void llenarEspacios(Usuario usuarioActual){
        textfieldNombreUsuario.setText(usuarioActual.getNombreUsuario());
        textfieldNumTel.setText(usuarioActual.getTelefono());
        textfieldNombresTrabajador.setText(usuarioActual.getNombres());
        textfieldContrasena.setText(usuarioActual.getContrasena());
        textfieldNumDoc.setText(usuarioActual.getNumDocumento());
    }
    public void clickBotonGuardarCambios() {

    }

    private void cuadroClienteNoEncontrado() {
        // Crear un cuadro de diálogo de tipo INFORMATION
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Usuario No Encontrado");
        alert.setHeaderText(null); // Opcional, puedes configurar un encabezado si lo deseas
        alert.setContentText("\n Usuario no encontrado. Por favor agréguelo llenando los espacios y pulsando el botón \"Crear\"");

        // Agregar un botón "Ok"
        ButtonType okButton = new ButtonType("Ok");
        alert.getButtonTypes().setAll(okButton);

        // Mostrar el cuadro de diálogo y esperar a que el usuario lo cierre
        alert.showAndWait();
    }
    private void cuadroRellenarCampos() {
        // Crear un cuadro de diálogo de tipo INFORMATION
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Rellenar Campos");
        alert.setHeaderText(null); // Opcional, puedes configurar un encabezado si lo deseas
        alert.setContentText("\"Rellene la barra de búsqueda con el id \\n    del Usuario por favor");

        // Agregar un botón "Ok"
        ButtonType okButton = new ButtonType("Ok");
        alert.getButtonTypes().setAll(okButton);

        // Mostrar el cuadro de diálogo y esperar a que el usuario lo cierre
        alert.showAndWait();
    }

    public void clickBotonCrear( ) {

    }

    public void desplegableTipoDocumento(){
        for (Persona.TipoDocumento tipoDoumento: Persona.TipoDocumento.values()) {
            comboBoxTipoDoc.getItems().add(tipoDoumento);

        }
    }
    public void desplegableTipoUsuario(){
        for (Usuario.TipoUsuario tipoUsuario : Usuario.TipoUsuario.values()) {
            comboBoxTipoUsuario.getItems().add(tipoUsuario);
        }
    }
}
