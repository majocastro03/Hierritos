module com.example.adminhierritos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.rmi;


    opens com.example.adminhierritos to javafx.fxml;
    exports com.example.adminhierritos;
}