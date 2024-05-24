package com.example.adminhierritos;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MenuController {

    static Scene scene;


    @FXML
    Button botonConfig;
    @FXML
    protected void clickInformes(){
        Main.mainStage.setScene(InformesController.scene);
    }
    @FXML
    protected void clickActualizarInfo() {
        Main.mainStage.setScene(ActualizarInfoController.scene);
    }

    public void  initialize(){
        botonConfig.setOnMouseClicked(event -> {
            ConfiguracionController.stage = new Stage();
            ConfiguracionController.stage.initStyle(StageStyle.UNDECORATED);
            ConfiguracionController.stage.setScene(ConfiguracionController.scene);
            ConfiguracionController.stage.show();
        });
    }
}
