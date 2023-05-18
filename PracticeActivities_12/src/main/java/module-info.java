module com.example.practiceactivities_12 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practiceactivities_12 to javafx.fxml;
    exports com.example.practiceactivities_12;
}