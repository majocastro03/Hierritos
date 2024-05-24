package com.example.almacenhierritos;

import client.Client;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static Stage mainStage;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("inicio_sesion1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hierritos");
        stage.getIcons().add(new Image(Main.class.getResource("Images/icono.png").openStream()));
        stage.setScene(scene);
        mainStage=stage;
        InicioDeSesionController.scene=scene;
        stage.show();
        fxmlLoader = new FXMLLoader(Main.class.getResource("menu_almacen.fxml"));
        scene = new Scene(fxmlLoader.load());
        MenuController.scene=scene;

        fxmlLoader = new FXMLLoader(Main.class.getResource("nuevaorden_almacen.fxml"));
        scene = new Scene(fxmlLoader.load());
        NuevaOrdenController.scene=scene;
        NuevaOrdenController.controller = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(Main.class.getResource("buscarproveedor_almacen.fxml"));
        scene = new Scene(fxmlLoader.load());
        BuscarProveedorController.scene=scene;

        fxmlLoader = new FXMLLoader(Main.class.getResource("inventario_almacen.fxml"));
        scene = new Scene(fxmlLoader.load());
        InventarioController.scene = scene;
        InventarioController.controller = fxmlLoader.getController();


    }

    public static void main(String[] args) {
        launch();
    }
}