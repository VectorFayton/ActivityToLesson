module com.example.practice_activities_11 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practice_activities_11 to javafx.fxml;
    exports com.example.practice_activities_11;
}