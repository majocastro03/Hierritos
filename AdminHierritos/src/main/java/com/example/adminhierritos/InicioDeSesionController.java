package com.example.adminhierritos;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InicioDeSesionController {

    static Scene scene;

    @FXML
    private TextField textfieldUsuario;


    @FXML
    private TextField textfieldContrasena;

    @FXML
    protected void clickBotonRegistrate() {
        textfieldUsuario.setText("Gerente");
    }

    @FXML
    protected void clickBotonInicio() {
        Main.mainStage.setScene(MenuController.scene);
        textfieldContrasena.setText("12345");
    }
/*
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
*/
}