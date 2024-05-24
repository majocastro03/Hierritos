package com.example.ventashierritos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{
    public static Stage mainStage;
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("inicio_sesion1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hierritos");
        stage.getIcons().add(new Image(Main.class.getResource("Images/icono.png").openStream()));
        stage.setScene(scene);
        mainStage=stage;
        InicioDeSesionController.scene=scene;
        stage.show();

        fxmlLoader = new FXMLLoader(Main.class.getResource("buscarcliente_ventas.fxml"));
        scene = new Scene(fxmlLoader.load());
        BuscarClienteController.scene = scene;
        BuscarClienteController.controller = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(Main.class.getResource("agregarcliente_ventas.fxml"));
        scene = new Scene(fxmlLoader.load());
        AgregarClienteController.scene = scene;
        AgregarClienteController.controller = fxmlLoader.getController();
        AgregarClienteController.controller.desplegables();

        fxmlLoader = new FXMLLoader(Main.class.getResource("buscarcliente2_ventas.fxml"));
        scene = new Scene(fxmlLoader.load());
        BuscarCliente2Controller.scene = scene;
        BuscarCliente2Controller.controller = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(Main.class.getResource("cotizacion.fxml"));
        scene = new Scene(fxmlLoader.load());
        CotizacionController.scene = scene;
        CotizacionController.controller = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(Main.class.getResource("factura.fxml"));
        scene = new Scene(fxmlLoader.load());
        FacturaController.scene = scene;
        FacturaController.controller = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(Main.class.getResource("tarjetaproducto2.fxml"));
        scene = new Scene(fxmlLoader.load());
        TarjetaProducto2Controller.scene = scene;
    }
}
