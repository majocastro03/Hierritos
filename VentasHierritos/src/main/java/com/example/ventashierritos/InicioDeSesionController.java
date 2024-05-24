package com.example.ventashierritos;

import clases.Usuario;
import client.Client;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.rmi.RemoteException;

public class InicioDeSesionController {

    static Scene scene;
    @FXML
    private VBox vbox;
    @FXML
    private Label labelError;
    @FXML
    private TextField textfieldUsuario;

    @FXML
    private PasswordField textfieldContrasena;

    static Usuario vendedorActual;
    @FXML
    protected void clickBotonInicio() {
        try {
            //Main.mainStage.setScene(BuscarClienteController.scene);
            if(true) {

                if (!Client.client.isConnected()) {
                    labelError.setText("Ups! Tenemos problemas de conexión.");
                    labelError.setStyle("-fx-background-color: #ff6666;");
                } else{
                    String nUser = textfieldUsuario.getText();
                    String pass = textfieldContrasena.getText();
                    if(nUser!=""&&pass!=""){
                        if (Client.client.iniciarSesion(nUser, pass)) {
                            vendedorActual=Client.client.obtenerVendedor(nUser,pass);
                            BuscarCliente2Controller.controller.dibujarTarjetasProductos();
                            Main.mainStage.setScene(BuscarClienteController.scene);
                        }else {
                            labelError.setText("Usuario o contraseña incorrectos.");
                            labelError.setStyle("-fx-background-color: #ff6666;");
                        }
                    }else {
                        labelError.setText("Rellene todos los campos.");
                        labelError.setStyle("-fx-background-color: #ff6666;");
                    }
                }
            }
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

}