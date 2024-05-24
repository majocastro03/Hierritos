package com.example.ventashierritos;

import clases.Cliente;
import clases.Persona;
import client.Client;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.rmi.RemoteException;
import java.time.temporal.Temporal;

public class AgregarClienteController {
    static Scene scene;
    static AgregarClienteController controller;
    @FXML
    TextField textfieldNombres;
    @FXML
    TextField textfieldNumTel;
    @FXML
    ComboBox menuTipoDocumento;
    @FXML
    TextField textfieldNumDoc;
    @FXML
    TextField textfieldDireccion;
    @FXML
    TextField textfieldCorreo;
    @FXML
    ComboBox menuTipoPersona;
    @FXML
    ComboBox menuIVA;

    public void clickBotonBuscar() {
    }
    public void clickBotonAceptar() {

        Cliente cliente = new Cliente();
        try{
            cliente.setNombres(textfieldNombres.getText());
            cliente.setTelefono(textfieldNumTel.getText());
            cliente.setTipoDocumento(Persona.TipoDocumento.valueOf(menuTipoDocumento.getSelectionModel().getSelectedItem().toString()));
            cliente.setNumDocumento(textfieldNumDoc.getText());
            cliente.setDireccion(textfieldDireccion.getText());
            cliente.setCorreo(textfieldCorreo.getText());
            cliente.setTipoPersona(Cliente.TipoPersona.valueOf(menuTipoPersona.getSelectionModel().getSelectedItem().toString()));
            cliente.setResponsableDeIva((menuIVA.getSelectionModel().getSelectedItem().toString().equals("Sí"))?true:false);
            cliente.setClienteFrecuente(false);

            int entero = -4;
            try {
                entero = Client.client.agregarCliente(cliente);
            } catch (RemoteException e) {
                System.out.println("CODIGO DE ERROR: "+entero);
                throw new RuntimeException(e);
            }
            if(entero>0){
                cliente.setId(""+entero);
                BuscarClienteController.clienteActual = cliente;
                BuscarClienteController.controller.dibujarCliente();
                Main.mainStage.setScene(BuscarClienteController.scene);
                limpiarCampos();
            }else{
                cuadroClienteYaExiste();
            }
        }catch (Exception e){
            cuadroRellenarCampos();
        }

    }

    private void cuadroClienteYaExiste() {
        // Crear un cuadro de diálogo de tipo INFORMATION
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cliente Existente");
        alert.setHeaderText(null); // Opcional, puedes configurar un encabezado si lo deseas
        alert.setContentText("El cliente ya se encuentra registrado.");

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
        alert.setContentText("Por favor rellene todos los campos.");

        // Agregar un botón "Ok"
        ButtonType okButton = new ButtonType("Ok");
        alert.getButtonTypes().setAll(okButton);

        // Mostrar el cuadro de diálogo y esperar a que el usuario lo cierre
        alert.showAndWait();
    }
    public void clickBotonCancelar() {
        limpiarCampos();
        Main.mainStage.setScene(BuscarClienteController.scene);
    }

    void limpiarCampos() {
        textfieldNombres.setText("");
        textfieldNumTel.setText("");
        textfieldNumDoc.setText("");
        textfieldDireccion.setText("");
        textfieldCorreo.setText("");
        menuTipoDocumento.getSelectionModel().clearSelection();
        menuTipoPersona.getSelectionModel().clearSelection();
        menuIVA.getSelectionModel().clearSelection();
    }

    public void desplegables(){
        desplegableTipoPersona();
        desplegableTipoDocumento();
        desplegableIva();
    }
    public void desplegableTipoDocumento(){
        for (Persona.TipoDocumento tipoDoumento: Persona.TipoDocumento.values()) {
            menuTipoDocumento.getItems().add(tipoDoumento);
        }
    }
    public void desplegableTipoPersona(){
        for (Cliente.TipoPersona tipoPersona: Cliente.TipoPersona.values()) {
            menuTipoPersona.getItems().add(tipoPersona);
        }
    }
    public void desplegableIva(){
        menuIVA.getItems().add("Sí");
        menuIVA.getItems().add("No");
    }

}
