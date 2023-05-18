import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MusicPlayer extends Application {

    private MediaPlayer mediaPlayer;
    private FileChooser fileChooser;
    private Slider volumeSlider;
    private ToggleButton playButton;
    private Button pauseButton;
    private Button stopButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) {

        fileChooser = new FileChooser();
        volumeSlider = new Slider(0, 1, 0.5);
        playButton = new ToggleButton("Play");
        pauseButton = new Button("Pause");
        stopButton = new Button("Stop");

        playButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
                    mediaPlayer.pause();
                } else {
                    mediaPlayer.play();
                }
            }
        });

        pauseButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                mediaPlayer.pause();
            }
        });

        stopButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                mediaPlayer.stop();
                mediaPlayer = null;
            }
        });

        // Create menu bar
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem openMenuItem = new MenuItem("Open");
        openMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                File file = fileChooser.showOpenDialog(stage);
                if (file != null) {
                    playFile(file);
                }
            }
        });
        fileMenu.getItems().add(openMenuItem);
        menuBar.getMenus().add(fileMenu);

        // Create layout
        HBox buttonBox = new HBox();
        buttonBox.getChildren().addAll(playButton, pauseButton, stopButton);
        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setCenter(buttonBox);
        root.setBottom(volumeSlider);

        Scene scene = new Scene(root, 400, 100);

        stage.setScene(scene);
        stage.show();
    }

    private void playFile(File file) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        Media media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setVolume(volumeSlider.getValue());
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            public void run() {
                mediaPlayer.stop();
                mediaPlayer = null;
            }
        });
    }
}
