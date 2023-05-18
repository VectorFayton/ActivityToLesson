package com.example.test;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.stage.*;
import java.io.*;
import java.util.*;

public class Main extends Application {

    private Label label_keyword_count;
    private Label label_asking_keyword;
    private Label result_of_label;
    private TextField key_word_text_field;
    private Button file_choose_button;
    private Label label_file_name;

    private VBox vBox;

    String[] keywords_list = {"abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "enum",
            "extends", "for", "final", "finally", "float", "goto",
            "if", "implements", "import", "instanceof", "int",
            "interface", "long", "native", "new", "package", "private",
            "protected", "public", "return", "short", "static",
            "strictfp", "super", "switch", "synchronized", "this",
            "throw", "throws", "transient", "try", "void", "volatile",
            "while", "true", "false", "null"};

    Set<String> keyword_set = new HashSet<>(Arrays.asList(keywords_list));

    @Override
    public void init() {
        label_keyword_count = new Label("Keyword Count");
        label_asking_keyword = new Label("Enter a Java keyword:");
        result_of_label = new Label("Result:");

        key_word_text_field = new TextField();

        file_choose_button = new Button("Search a keyword from file:");

        label_file_name = new Label();

        vBox = new VBox(11);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(label_keyword_count, label_asking_keyword, key_word_text_field, file_choose_button, result_of_label, label_file_name);
    }

    public void countKeywords(File javaFile) {
        Scanner fin = null;
        try {
            fin = new Scanner(javaFile);
        } catch (FileNotFoundException exc) {
            result_of_label.setText("The file is not found.");
        }

        String find_keyword = key_word_text_field.getText();
        int total_count = 0;
        int find_count = 0;
        while (fin.hasNext()) {
            String nextToken = fin.next();
            if (keyword_set.contains(nextToken)) {
                total_count++;
            }
            if (nextToken.equals(find_keyword)) {
                find_count++;
            }
        }

        result_of_label.setText(String.format("Number of keywords in file: %d\nNumber of keyword \"%s\": %d", total_count, find_keyword, find_count));
    }

    @Override
    public void start(Stage primaryStage) {

        file_choose_button.setOnAction(e -> {
            if (key_word_text_field.getText().equals("")) {
                result_of_label.setText("Text field is empty");
            }
            else {
                FileChooser file_chooser = new FileChooser();
                file_chooser.setTitle("Open Java File");
                file_chooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("Java Files", "*.java")
                );
                File selected_file = file_chooser.showOpenDialog(primaryStage);
                label_file_name.setText(selected_file.getName() + " chosen");
                if (selected_file == null) {
                    result_of_label.setText("Something is wrong with the file.");
                    return;
                }
                countKeywords(selected_file);
            }
        });

        Scene scene = new Scene(vBox, 500, 500);
        primaryStage.setTitle("Title");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}