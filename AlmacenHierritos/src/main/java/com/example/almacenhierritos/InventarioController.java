package com.example.almacenhierritos;

import clases.Producto;
import client.Client;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InventarioController {

    static Scene scene;

    static InventarioController controller;
    @FXML
    TextField textfieldBuscar;

    @FXML
    ScrollPane scrollPane;

    @FXML
    GridPane gridPane;

    public void clickBotonBuscar() throws RemoteException {

    }
    public void clickRegresar() {
        Main.mainStage.setScene(MenuController.scene);
    }

    protected void ListaProductos () throws RemoteException{
        List<Producto> listPrueba;
        listPrueba = Client.client.ListaProductosInventario();
        for (Producto producto : listPrueba){
            insertarTarjeta(producto);
        }
    }

    static List<VBox> tarjetas = new LinkedList();
    private int col=0;
    private int fil=1;
    public void insertarTarjeta(Producto producto){
        VBox tarjeta;
        //SI HAY MENOS DE 9 Productos debe empezar en la fila 0
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("tarjetaProducto.fxml"));
        try {
            tarjeta = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        TarjetaController tarjetaController = fxmlLoader.getController();
        tarjetaController.setProducto(producto);
        tarjetaController.setLabelNombreProducto(producto.getNombre());
        tarjetaController.setLabelDescProducto(producto.getDescripcion());
        tarjetaController.setTextFieldCantidad(""+producto.getExistencias());
        tarjetaController.setLabelPrecio("$"+producto.getPrecioVenta());
        try {
            if(producto.getExistencias()<producto.getCantidadMinima()){
                tarjetaController.imageWarning.setImage(new Image(Main.class.getResource("Images/advertencia.png").openStream()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        gridPane.add(tarjeta, col++, fil);
        GridPane.setMargin(tarjeta,new Insets(10));
        if (col == 3) {
            col = 0;
            fil++;
        }
        tarjetas.add(tarjeta);
    }
}
