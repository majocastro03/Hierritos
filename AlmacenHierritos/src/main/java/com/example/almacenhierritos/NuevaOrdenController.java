package com.example.almacenhierritos;

import clases.EmpresaProveedora;
import clases.Producto;
import client.Client;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.rmi.RemoteException;
import java.util.LinkedList;

public class NuevaOrdenController {
    static NuevaOrdenController controller;
    static Scene scene;
    @FXML
    TextField textfieldBuscar;
    @FXML
    ComboBox comboboxFormaPago;

    @FXML
    ComboBox comboboxNombreProducto;

    @FXML
    protected void clickBotonBuscar() {
        EmpresaProveedora empresa=null;
        try {
            empresa = Client.client.buscarProveedor(textfieldBuscar.getText());
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

        NuevaOrdenController.controller.desplegableProductos(empresa.getNit());
    }
    @FXML
    protected void clickBotonAceptar() {

    }
    @FXML
    protected void clickBotonCancelar() {
        Main.mainStage.setScene(MenuController.scene);
    }

    protected void formasDePago(){
        try {
            ObservableList<String> items = FXCollections.observableArrayList();
            for (EmpresaProveedora.FormaDePago forma :
                    EmpresaProveedora.FormaDePago.values()) {
                items.add(forma.toString());
            }
            comboboxFormaPago.setItems(items);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void desplegableProductos(String nit){
        try {
            ObservableList<String> items = FXCollections.observableArrayList();
            //TODO Acá se debe bajar la lista de productos de esta empresa
            LinkedList<String> listaProductosDeLaEmpresa = new LinkedList();
            listaProductosDeLaEmpresa.add("tuerca");
            listaProductosDeLaEmpresa.add("tornillo");
            listaProductosDeLaEmpresa.add("clavo");
            //TODO Acá se agregan los nombres de los productos que ofrece la empresa a la lista desplegable
            for(String string : listaProductosDeLaEmpresa){
                items.add(string);
            }
            //Productos temporales
/*          items.add("Producto 1");
            items.add("Producto 2");
            items.add("Producto 3");
            items.add("Producto 4");*/

            comboboxNombreProducto.setItems(items);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}