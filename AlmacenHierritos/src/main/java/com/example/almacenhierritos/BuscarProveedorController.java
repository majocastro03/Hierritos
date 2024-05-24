package com.example.almacenhierritos;

import clases.Producto;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Builder;
import javafx.util.BuilderFactory;

import java.io.IOException;
import java.util.Locale;

public class BuscarProveedorController {

    static Scene scene;
    static VBox tarjeta;
    @FXML
    GridPane gridPane;
    @FXML
    ScrollPane scrollPane;
    @FXML
    TextField textfieldBuscar;
    @FXML
    protected void clickBotonBuscar() {
        insertarTarjeta(new Producto());
    }
    @FXML
    protected void clickBotonCrear() {
        Main.mainStage.setScene(MenuController.scene);
    }
    @FXML
    protected void clickRegresar() {
        Main.mainStage.setScene(MenuController.scene);
    }

    private int col=0;
    private int fil=1;

    public void insertarTarjeta(Producto producto){
        //SI HAY MENOS DE 9 Productos debe empezar en la fila 0
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("tarjetaProducto.fxml"));
        try {
            tarjeta = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        TarjetaController tarjetaController = fxmlLoader.getController();
        tarjetaController.setLabelNombreProducto(producto.getNombre());
        tarjetaController.setLabelDescProducto(producto.getDescripcion());
        gridPane.add(tarjeta, col++, fil);
        GridPane.setMargin(tarjeta,new Insets(10));
        if (col == 3) {
            col = 0;
            fil++;
        }
    }

/*    public void insertarTarjeta(){
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("tarjetaProducto.fxml"));
        try {
            tarjeta = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        TarjetaController tarjetaController = fxmlLoader.getController();
        tarjetaController.setLabelNombreProducto("NOMBREEE");
        tarjetaController.setLabelDescProducto(fil+", "+col);
        if( fil>3 && col==0 ){
            gridPane.addRow(3);
            gridPane.add(tarjeta, col++, fil);
            GridPane.setMargin(tarjeta, new Insets(5));
        }else {
            gridPane.add(tarjeta, col++, fil);
            GridPane.setMargin(tarjeta, new Insets(5));
        }
        gridPane.setTranslateY(40);
        if (i == 3) {
            gridPane.setVgap(200);
            gridPane.setTranslateY(100);
        } else {
            i++;
        }
        if (col == 3) {
            col = 0;
            fil++;
        }
    }*/

/*    public void insertarTarjeta(){
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("tarjetaProducto.fxml"));
        TarjetaController tarjetaController = fxmlLoader.getController();
        tarjetaController.setLabelNombreProducto("Nombreee");
        tarjetaController.setLabelDescProducto("Descripcioooooon");
        tarjetaController.setTextFieldCantidad("15");
        tarjeta = tarjetaController.getTarjeta();
        gridPane.getChildren().add(tarjeta);
    }*/

}