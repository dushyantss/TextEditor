package dushyant.texteditor;
/**
 * Created by Dushyant Singh Shekhawat
 * on 04-06-2016.
 */

import dushyant.texteditor.controllers.RootController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class
Main extends Application {
    private Stage primaryStage;
    private BorderPane root;
    private RootController rootController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Text Editor");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/icons/AppIcon.png")));
        initStage();
    }

    /***
     * Method that will set the root layout and show the primaryStage
     */
    private void initStage() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("views/RootLayout.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        rootController = loader.getController();
        rootController.setMain(this);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
