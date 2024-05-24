package com.example.ventashierritos;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FacturaController {
    static Scene scene;
    static FacturaController controller;
    @FXML
    Label labelIdFactura;
    @FXML
    TextArea textArea;
    public void clickBotonSalir(){
        BuscarClienteController.controller.limpiarCampos();
        labelIdFactura.setText("");
        BuscarCliente2Controller.controller.reiniciarListasYGrids();
        Main.mainStage.setScene(BuscarClienteController.scene);
    }
    public void setLabelIdFactura(String id){
        labelIdFactura.setText("ID: "+id);
    }
    public void setTextArea(String string){
        textArea.setText(string);
    }
}
