package com.example.adminhierritos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
        mainStage = stage;

        InicioDeSesionController.scene=scene;
        stage.show();

        fxmlLoader = new FXMLLoader(Main.class.getResource("menu_admin.fxml"));
        scene = new Scene(fxmlLoader.load());
        MenuController.scene=scene;

        fxmlLoader = new FXMLLoader(Main.class.getResource("informes_admin.fxml"));
        scene = new Scene(fxmlLoader.load());
        InformesController.scene=scene;

        fxmlLoader = new FXMLLoader(Main.class.getResource("actualizarinfo_admin.fxml"));
        scene = new Scene(fxmlLoader.load());
        ActualizarInfoController.scene=scene;

        fxmlLoader = new FXMLLoader(Main.class.getResource("cliente_actualizarinfo_admin.fxml"));
        scene = new Scene(fxmlLoader.load());
        ClienteActualizarInfoController.scene=scene;

        fxmlLoader = new FXMLLoader(Main.class.getResource("ventas_informes_admin.fxml"));
        scene = new Scene(fxmlLoader.load());
        VentasInformesController.scene=scene;

        fxmlLoader = new FXMLLoader(Main.class.getResource("vendedor_informes_admin.fxml"));
        scene = new Scene(fxmlLoader.load());
        VendedorMesInformeController.scene = scene;

        fxmlLoader = new FXMLLoader(Main.class.getResource("cliente_actualizarinfo_admin.fxml"));
        scene = new Scene(fxmlLoader.load());
        VendedorMesInformeController.scene = scene;

        fxmlLoader = new FXMLLoader(Main.class.getResource("configuracion_admin.fxml"));
        scene = new Scene(fxmlLoader.load());
        ConfiguracionController.scene = scene;

        fxmlLoader = new FXMLLoader(Main.class.getResource("usuario_actualizarinfo_admin.fxml"));
        scene = new Scene(fxmlLoader.load());
        UsuarioActualizarInfoController.scene = scene;
        UsuarioActualizarInfoController.controller = fxmlLoader.getController();
        UsuarioActualizarInfoController.controller.desplegables();

    }

    public static void main(String[] args) {
        launch();
    }
}