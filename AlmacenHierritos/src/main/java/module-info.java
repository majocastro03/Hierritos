module com.example.almacenhierritos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.rmi;


    opens com.example.almacenhierritos to javafx.fxml;
    exports com.example.almacenhierritos;
}