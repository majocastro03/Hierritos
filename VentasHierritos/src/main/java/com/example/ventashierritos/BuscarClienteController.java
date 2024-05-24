package com.example.ventashierritos;

import clases.Cliente;
import client.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.rmi.RemoteException;

public class BuscarClienteController {

    static Scene scene;
    static BuscarClienteController controller;

    @FXML
    TextArea textArea;
    @FXML
    TextField textfieldBuscar;
    static Cliente clienteActual=null;

    public void clickBotonBuscar( ) throws RemoteException {
        Cliente cliente;

        cliente  =  Client.client.buscarCliente(textfieldBuscar.getText());

        if(cliente.getId()!=null) {
            clienteActual = cliente;
            dibujarCliente();
        }else if(textfieldBuscar.getText().equals("")){
            textArea.setText("\n    Rellene la barra de búsqueda con el teléfono o cédula\n    del cliente por favor. ");
            clienteActual=null;
        }else{
            textArea.setText("\n    Cliente no encontrado. Por favor agréguelo pulsando el botón\n    \"Agregar Cliente\"");
            clienteActual=null;
        }

    }

    public void limpiarCampos(){
        BuscarClienteController.clienteActual=null;
        textfieldBuscar.setText("");
        textArea.setText("");
    }

    public void dibujarCliente() {
        textArea.setText("\n    Nombres: " + clienteActual.getNombres() + "\n    "
                + clienteActual.getTipoDocumento().toString().toLowerCase() + ": " + clienteActual.getNumDocumento() + "\n    "
                + "\n    Teléfono: " + clienteActual.getTelefono() + "\n    "
                + "\n    Dirección: " + clienteActual.getDireccion() + "\n    "
                + "Correo Electrónico: " + clienteActual.getCorreo() + "\n    "
                + "\n    Tipo de persona: " + clienteActual.getTipoPersona().toString().toLowerCase() + "\n    "
                + "Responsable de Iva: " + (clienteActual.getResponsableDeIva() ? "Sí" : "No") + "\n    "
                + "\n    \n    \n    "
                + "Cliente Frecuente: " + (clienteActual.getClienteFrecuente() ? "Sí" : "No") + "\n    "
                + "ID interno: " + clienteActual.getId() + "\n    "
        );
    }

    public void clickBotonSiguiente() {
        if(clienteActual==null){
            cuadroClienteNulo();
        }else{
            Main.mainStage.setScene(BuscarCliente2Controller.scene);
        }
    }

    public void clickBotonAgCliente( ) {
        if((!textfieldBuscar.getText().equals(""))&&(clienteActual==null)){
            AgregarClienteController.controller.textfieldNumTel.setText(textfieldBuscar.getText());
        }
        Main.mainStage.setScene(AgregarClienteController.scene);
    }

    public void clickBotonPagarCot() {
        Main.mainStage.setScene(CotizacionController.scene);
    }

    private void cuadroClienteNulo() {
        // Crear un cuadro de diálogo de tipo INFORMATION
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cliente No Seleccionado");
        alert.setHeaderText(null); // Opcional, puedes configurar un encabezado si lo deseas
        alert.setContentText("No tiene un cliente seleccionado, por favor búsquelo por su teléfono o número de identificación, o agréguelo.");

        // Agregar un botón "Ok"
        ButtonType okButton = new ButtonType("Ok");
        alert.getButtonTypes().setAll(okButton);

        // Mostrar el cuadro de diálogo y esperar a que el usuario lo cierre
        alert.showAndWait();
    }
}
