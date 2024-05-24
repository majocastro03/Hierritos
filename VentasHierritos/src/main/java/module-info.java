module com.example.ventashierritos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.rmi;


    opens com.example.ventashierritos to javafx.fxml;
    exports com.example.ventashierritos;
}