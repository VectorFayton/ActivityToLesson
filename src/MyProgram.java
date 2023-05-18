import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.RotateTransition;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MyProgram extends Application {

    private TextArea textArea;

    @Override
    public void start(Stage primaryStage) {


        Circle circle = new Circle(150, 150, 50, Color.CORAL);
        circle.setOnMouseClicked(e -> {
            textArea.appendText("Mouse event handler has been called\n");
            System.out.println("Clicked at: " + e.getX() + ", " + e.getY());
        });

        Rectangle rectangle = new Rectangle(100, 100, Color.TAN);
        rectangle.setRotate(0);

        TextField textField = new TextField();
        textField.setLayoutX(50);
        textField.setLayoutY(100);
        textField.setOnKeyTyped(e -> {
            RotateTransition rt = new RotateTransition(Duration.millis(1000), rectangle);
            rt.setAxis(Rotate.Y_AXIS);
            rt.setByAngle(360);
            rt.setCycleCount(50);
            rt.setAutoReverse(false);
            rt.play();
            textArea.appendText("Key event handler has been called\n");
        });

        HBox hBox = new HBox(20);
        hBox.setPadding(new Insets(20));
        hBox.getChildren().addAll(circle, rectangle, textField);

        textArea = new TextArea();
        textArea.setEditable(false);

        VBox vBox = new VBox(20);
        vBox.setPadding(new Insets(20));
        vBox.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        vBox.getChildren().addAll(hBox, textArea);

        Scene scene = new Scene(vBox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("My Program");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
