module com.example.practice_activities_10 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ProblemA to javafx.fxml;
    exports com.example.ProblemA;
}