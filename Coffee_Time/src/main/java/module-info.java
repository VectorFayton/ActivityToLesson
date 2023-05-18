module com.example.coffee_time {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.coffee_time to javafx.fxml;
    exports com.example.coffee_time;
}