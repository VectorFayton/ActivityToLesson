module com.example.practice_activities_5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practice_activities_5 to javafx.fxml;
    exports com.example.practice_activities_5;
}