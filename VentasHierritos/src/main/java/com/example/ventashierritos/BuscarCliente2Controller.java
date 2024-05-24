package com.example.ventashierritos;

import clases.EmpresaProveedora;
import clases.FacturaVenta;
import clases.Producto;
import client.Client;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

public class BuscarCliente2Controller {
    static Scene scene;
    static BuscarCliente2Controller controller;
    @FXML
    TextField textfieldBuscar;
    @FXML
    Label labelTotal;
    @FXML
    GridPane gridPane1;
    @FXML
    GridPane gridPane2;
    public void clickBotonBuscar() {
    }
    public void clickRegresar() {
        Main.mainStage.setScene(BuscarClienteController.scene);
    }
    public void clickBotonAceptar() {
        FacturaVenta facturaVenta = armarFactura();
        int id;
        try {
            id = Client.client.enviarFactura(facturaVenta);
        } catch (RemoteException e) {
            id = -4;
            throw new RuntimeException(e);
        }
        FacturaController.controller.setLabelIdFactura(""+id);
        FacturaController.controller.setTextArea(
                "\n    Id Factura: "+id+
                "\n    Id Cliente: "+facturaVenta.getCliente().getId()+
                "\n    Id Vendedor: "+facturaVenta.getVendedor().getId()+
                "\n    Productos: "+facturaVenta.getProductos().size()
        );
        Main.mainStage.setScene(FacturaController.scene);
    }

    private FacturaVenta armarFactura() {
        FacturaVenta facturaVenta = new FacturaVenta();
        facturaVenta.setCliente(BuscarClienteController.clienteActual);
        facturaVenta.setFechaYHora("now()");
        facturaVenta.setTotal(BuscarCliente2Controller.controller.total);
        facturaVenta.setFormaDePago(cuadroFormaDePago());
        facturaVenta.setVendedor(InicioDeSesionController.vendedorActual);
        facturaVenta.setConsecutivoDian(1);
        LinkedList<Producto> productosFactura = new LinkedList();
        for (TarjetaProducto2Controller tarjeta: BuscarCliente2Controller.tarjetasProductosSeleccionados) {
            productosFactura.add(tarjeta.getProducto());
        }
        facturaVenta.setProductos(productosFactura);
        return facturaVenta;
    }

    private EmpresaProveedora.FormaDePago cuadroFormaDePago() {
        // Crear un cuadro de diálogo emergente (Alert) de tipo Confirmación
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Método de Pago");
        alert.setHeaderText("Selecciona un método de pago:");

        // Crear un ChoiceBox para seleccionar el método de pago
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Efectivo", "Tarjeta", "Transferencia");
        choiceBox.setValue("Efectivo"); // Opción predeterminada

        // Agregar el ChoiceBox al contenido del cuadro de diálogo
        VBox vbox = new VBox(choiceBox);
        alert.getDialogPane().setContent(vbox);

        // Mostrar el cuadro de diálogo y esperar a que el usuario seleccione una opción
        alert.showAndWait();

        // Obtener la opción seleccionada y retornarla como un String
        String metodoSeleccionado = choiceBox.getValue();

        // Llamar al método que procesa la opción seleccionada (puedes hacer lo que necesites aquí)
        return  Enum.valueOf(EmpresaProveedora.FormaDePago.class,metodoSeleccionado.toUpperCase());
    }

    public void clickBotonCancelar() {
        BuscarClienteController.controller.limpiarCampos();
        Main.mainStage.setScene(BuscarClienteController.scene);
        BuscarCliente2Controller.controller.reiniciarListasYGrids();
    }
    public void clickBotonHacerCot() {
        FacturaVenta facturaVenta = armarFactura();
        facturaVenta.setConsecutivoDian(0);
        int id;
        try {
            id = Client.client.enviarFactura(facturaVenta);
        } catch (RemoteException e) {
            id = -4;
            throw new RuntimeException(e);
        }
        CotizacionController.controller.setTextFieldId(""+id);
        CotizacionController.controller.setTextArea(
                "\n    Id Factura: "+id+
                "\n    Id Cliente: "+facturaVenta.getCliente().getId()+
                "\n    Id Vendedor: "+facturaVenta.getVendedor().getId()+
                "\n    Productos: "+facturaVenta.getProductos().size()
        );
        Main.mainStage.setScene(CotizacionController.scene);
    }

    public static List<TarjetaController> tarjetasInventario = new LinkedList();
    private static int col=0;
    private static int fil=4;
    public void insertarTarjeta(Producto producto){
        VBox tarjeta;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("tarjetaProducto.fxml"));
        try {
            tarjeta = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        TarjetaController tarjetaController = fxmlLoader.getController();
        tarjetaController.setProducto(producto);
        tarjetaController.controller=tarjetaController;
        tarjetaController.setLabelNombreProducto(producto.getNombre());
        tarjetaController.setLabelDescProducto(producto.getDescripcion());
        tarjetaController.setLabelPrecio(""+producto.getPrecioVenta());
        tarjetaController.setTextFieldCantidad("1");
        tarjetaController.setLabelDto(producto.getpDescuento());

        gridPane1.add(tarjeta, col++, fil);
        if (col == 2) {
            col = 0;
            fil++;
        }
        tarjetasInventario.add(tarjetaController);
    }

    public static List<TarjetaProducto2Controller> tarjetasProductosSeleccionados = new LinkedList();
    private static int fil2=1;
    public void insertarTarjetaPequena(Producto producto){
        HBox tarjeta;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("tarjetaProducto2.fxml"));
        try {
            tarjeta = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        TarjetaProducto2Controller tarjetaController2 = fxmlLoader.getController();
        tarjetaController2.setProducto(producto);
        tarjetaController2.controller = tarjetaController2;
        tarjetaController2.setLabelNomProducto(producto.getNombre());
        tarjetaController2.setLabelIDProducto("ID: "+producto.getIdProducto());
        tarjetaController2.setLabelCantidad("Cantidad: "+producto.getExistencias());

        gridPane2.add(tarjeta, 0, fil2++);
        tarjetasProductosSeleccionados.add(tarjetaController2);
    }

    public void dibujarTarjetasProductos(){
        try {
            List<Producto> listaProductos = Client.client.listaProductosInventario();
            for (Producto producto: listaProductos) {
                insertarTarjeta(producto);
            }
        } catch (RemoteException e) {
            cuadroFallaDeConexion();
            e.printStackTrace();
        }
    }
    double total=0;

    public void setLabelTotal(String total) {
        labelTotal.setText(total);
    }
    public void reiniciarListasYGrids(){
        for (TarjetaController tarjeta: tarjetasInventario) {
            gridPane1.getChildren().remove(tarjeta.getTarjeta());
        }
        for (TarjetaProducto2Controller tarjeta2: tarjetasProductosSeleccionados) {
            gridPane2.getChildren().remove(tarjeta2.getTarjeta());
        }
        BuscarCliente2Controller.controller.total=0;
        BuscarCliente2Controller.tarjetasInventario.clear();
        BuscarCliente2Controller.tarjetasProductosSeleccionados.clear();
        dibujarTarjetasProductos();
    }
    private void cuadroFallaDeConexion() {
        // Crear un cuadro de diálogo de tipo INFORMATION
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Falla de Conexión");
        alert.setHeaderText(null); // Opcional, puedes configurar un encabezado si lo deseas
        alert.setContentText("Hubo un error al comunicarse con el servidor. \nPor favor verifique que esté encendido.");

        // Agregar un botón "Ok"
        ButtonType okButton = new ButtonType("Ok");
        alert.getButtonTypes().setAll(okButton);

        // Mostrar el cuadro de diálogo y esperar a que el usuario lo cierre
        alert.showAndWait();
    }
}
