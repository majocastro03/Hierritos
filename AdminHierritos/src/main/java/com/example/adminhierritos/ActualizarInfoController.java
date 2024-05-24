package com.example.adminhierritos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ActualizarInfoController {

    static Scene scene;
    static VBox newVbox;

    @FXML
    VBox VboxDisplay;

    public void ClickBotonCliente( ) {

        cargarFxml("cliente_actualizarinfo_admin.fxml");


    }

    public void ClickBotonUsuario() {
        cargarFxml("usuario_actualizarinfo_admin.fxml");
    }

    public void ClickBotonVolver( ) {
        Main.mainStage.setScene(MenuController.scene);
    }

    private void cargarFxml(String archivoFxml) {
        VboxDisplay.getChildren().clear();  // Limpiar el contenido actual
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(archivoFxml));
        try {
            newVbox = fxmlLoader.load();
            VboxDisplay.getChildren().add(newVbox);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
