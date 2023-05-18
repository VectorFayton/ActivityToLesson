package ProblemA;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.stage.*;
import java.util.*;
import java.io.*;

public class Main extends Application {

    private Label label1;
    private Label label2;
    private TextField textField;
    private Button chooseFileButton;
    private Label chosenFileLabel;
    private Button calculateButton;
    private Label statusLabel;
    private VBox vBox;
    private HBox hBox;
    private File selectedFile;

    String[] keywordString = {"abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "enum",
            "extends", "for", "final", "finally", "float", "goto",
            "if", "implements", "import", "instanceof", "int",
            "interface", "long", "native", "new", "package", "private",
            "protected", "public", "return", "short", "static",
            "strictfp", "super", "switch", "synchronized", "this",
            "throw", "throws", "transient", "try", "void", "volatile",
            "while", "true", "false", "null"};
    ArrayList<String> kws = new ArrayList<>(Arrays.asList(keywordString));

    @Override
    public void init() {
        selectedFile = null;

        label1 = new Label("KEYWORD COUNTER");
        label2 = new Label("Enter a keyword:");
        textField = new TextField();

        chooseFileButton = new Button("Choose a Java file ...");
        chosenFileLabel = new Label();
        calculateButton = new Button("Count keyword");

        statusLabel = new Label();

        hBox = new HBox(10);
        hBox.getChildren().addAll(chooseFileButton, chosenFileLabel);
        hBox.setAlignment(Pos.CENTER);

        vBox = new VBox(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(label1, label2, textField, hBox, calculateButton, statusLabel);
    }

    public boolean isJavaToken(String token) {
        for (String s: keywordString) {
            if (s.equals(token)) {
                return true;
            }
        }
        return false;
    }

    public void countKeywords(File javaFile) {
        try {
            Scanner fin = new Scanner(javaFile);

            int allKeywordsCounter = 0;
            int searchKeywordCounter = 0;
            String searchKeyword = textField.getText();

            while (fin.hasNext()) {
                String token = fin.next();
                if (kws.contains(token)) {
                    allKeywordsCounter++;
                    if (searchKeyword.equals(token)) {
                        searchKeywordCounter++;
                    }
                }
            }

            statusLabel.setText(String.format(
                    "Number of keywords in file %s is %d\nNumber of search keyword \"%s\" is %d",
                    selectedFile.getName(),
                    allKeywordsCounter,
                    searchKeyword,
                    searchKeywordCounter));

        } catch (FileNotFoundException exc) {
            statusLabel.setText("File was not found.");
        }
    }

    @Override
    public void start(Stage primaryStage) {

        chooseFileButton.setOnAction(e -> {
            statusLabel.setText("");

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Java File");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Java Files", "*.java"));

            selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile == null) {
                statusLabel.setText("The file was not selected");
            } else {
                chosenFileLabel.setText(selectedFile.toString());
            }
        });

        calculateButton.setOnAction(e -> {
            countKeywords(selectedFile);
        });

        Scene scene = new Scene(vBox, 500, 500);
        primaryStage.setTitle("Title");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}