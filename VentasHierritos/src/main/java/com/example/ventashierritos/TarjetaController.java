package com.example.ventashierritos;

import clases.Producto;
import client.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class TarjetaController {
    TarjetaController controller;

    @FXML
    private Label labelDto;
    @FXML
    ImageView imageWarning;
    @FXML
    private VBox vBoxTarjeta;
    @FXML
    private Label labelPrecio;
    @FXML
    private Label labelNombreProducto;

    @FXML
    private Label labelDescProducto;

    @FXML
    private TextField textFieldCantidad;

    private Producto producto;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public TarjetaController() {
    }

    @FXML
    protected void clickBotonChulito() {
        try{
            //TODO verificar cantidad vendida menor que existencias
            double cantidadPedida = Double.valueOf(textFieldCantidad.getText());
            TarjetaProducto2Controller tarjeta = tarjetaEnLista(producto.getIdProducto());
            if(tarjeta==null){
                if(Client.client.cantidadSuficiente(cantidadPedida,producto.getIdProducto())) {
                    producto.setExistencias(cantidadPedida);
                    BuscarCliente2Controller.controller.insertarTarjetaPequena(producto);
                    double total = BuscarCliente2Controller.controller.total;
                    double totalPorCantidad = producto.getPrecioVenta() * producto.getExistencias();
                    double descuento = totalPorCantidad * producto.getpDescuento();
                    double granTotal = totalPorCantidad - descuento;
                    BuscarCliente2Controller.controller.total += granTotal;
                    BuscarCliente2Controller.controller.setLabelTotal("Total: " + (total + granTotal));
                }else{
                    cuadroCantidadNoSuficiente();
                }
            }else{
                double granCantidadPedida = tarjeta.getProducto().getExistencias()+cantidadPedida;
                if(Client.client.cantidadSuficiente(granCantidadPedida,producto.getIdProducto())){
                    tarjeta.getProducto().setExistencias(granCantidadPedida);
                    tarjeta.setLabelCantidad("Cantidad: "+granCantidadPedida);
                    double total = BuscarCliente2Controller.controller.total;
                    double totalPorCantidad = producto.getPrecioVenta() * cantidadPedida;
                    double descuento = totalPorCantidad * producto.getpDescuento();
                    double granTotal = totalPorCantidad - descuento;
                    BuscarCliente2Controller.controller.total += granTotal;
                    BuscarCliente2Controller.controller.setLabelTotal("Total: " + (total + granTotal));
                }else{
                    cuadroCantidadNoSuficiente();
                }
            }

        }catch (Exception e){
            cuadroValorNoNumerico();
        }
    }

    private TarjetaProducto2Controller tarjetaEnLista(int idProducto) {
        Producto producto;
        for (TarjetaProducto2Controller tarjeta: BuscarCliente2Controller.tarjetasProductosSeleccionados) {
            producto = tarjeta.getProducto();
            if(producto.getIdProducto()==idProducto){
                return tarjeta;
            }
        }
        return null;
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
        this.labelPrecio.setText("$"+precio);
    }
    public void setLabelDto(double dto) {
        if(dto!=0){
            labelDto.setText("Dto: "+(dto*100)+"%");
        }else {
            labelDto.setText("SinDto");
        }

    }

    public String getTextFieldCantidad() {
        return this.textFieldCantidad.getText();
    }

    private void cuadroValorNoNumerico() {
        // Crear un cuadro de diálogo de tipo INFORMATION
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Valor No Numérico");
        alert.setHeaderText(null); // Opcional, puedes configurar un encabezado si lo deseas
        alert.setContentText("Por favor asegúrese de que colocó un valor numérico en el campo de cantidad.");

        // Agregar un botón "Ok"
        ButtonType okButton = new ButtonType("Ok");
        alert.getButtonTypes().setAll(okButton);

        // Mostrar el cuadro de diálogo y esperar a que el usuario lo cierre
        alert.showAndWait();
    }
    private void cuadroCantidadNoSuficiente() {
        // Crear un cuadro de diálogo de tipo INFORMATION
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cantidad No Suficiente");
        alert.setHeaderText(null); // Opcional, puedes configurar un encabezado si lo deseas
        alert.setContentText("La cantidad de producto solicitada excede las existencias en el inventario.");

        // Agregar un botón "Ok"
        ButtonType okButton = new ButtonType("Ok");
        alert.getButtonTypes().setAll(okButton);

        // Mostrar el cuadro de diálogo y esperar a que el usuario lo cierre
        alert.showAndWait();
    }
}
