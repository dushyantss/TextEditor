package dushyant.texteditor;
/**
 * Created by Dushyant Singh Shekhawat
 * on 04-06-2016.
 */

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class
Main extends Application {
    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Text Editor");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/icons/AppIcon.png")));
        primaryStage.show();
    }
}
