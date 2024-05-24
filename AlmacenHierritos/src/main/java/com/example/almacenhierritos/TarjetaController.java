package com.example.almacenhierritos;

import clases.Producto;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class TarjetaController {
    @FXML
    ImageView imageWarning;
    @FXML
    private VBox vBoxTarjeta;

    @FXML
    private Label labelNombreProducto;

    @FXML
    private Label labelDescProducto;

    @FXML
    private TextField textFieldCantidad;
    @FXML
    private Label labelPrecio;

    public TarjetaController() {
    }

    private Producto producto;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public VBox getTarjeta(){
        return vBoxTarjeta;
    }

    public void setLabelNombreProducto(String nombreProducto) {
        this.labelNombreProducto.setText(nombreProducto);
    }

    public void setLabelDescProducto(String descProducto) {
        this.labelDescProducto.setText(descProducto);
    }

    public void setTextFieldCantidad(String cantidad) {
        this.textFieldCantidad.setText(cantidad);
    }

    public void setLabelPrecio(String precio) {
        this.labelPrecio.setText(precio);
    }

    public String getTextFieldCantidad() {
        return this.textFieldCantidad.getText();
    }
}
