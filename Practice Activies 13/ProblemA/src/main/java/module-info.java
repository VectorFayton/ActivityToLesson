module com.example.problema {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.problema to javafx.fxml;
    exports com.example.problema;
}