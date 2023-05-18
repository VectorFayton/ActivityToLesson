module com.example.practice_activity_14 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ProblemC to javafx.fxml;
    exports com.example.ProblemC;
}