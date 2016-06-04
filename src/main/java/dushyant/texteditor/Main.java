package dushyant.texteditor;
/**
 * Created by Dushyant Singh Shekhawat
 * on 04-06-2016.
 */

import dushyant.texteditor.controllers.EditorController;
import dushyant.texteditor.controllers.RootController;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.fxmisc.flowless.VirtualizedScrollPane;

import java.io.*;
import java.util.prefs.Preferences;

public class
Main extends Application {
    private final static String FILE_PATH_KEY = "filePath";

    private Stage primaryStage;
    private BorderPane root;
    private RootController rootController;

    public static void main(String[] args) {
        launch(args);
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Text Editor");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/icons/AppIcon.png")));
        initStage();
        addEditor();
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

    /***
     * Method to set the Editor.
     * Cannot use a fxml file as it cannot instantiate a StyledTextArea
     */
    private void addEditor() {
        EditorController editor = new EditorController();
        editor.setMain(this);

        root.setCenter(new VirtualizedScrollPane<>(editor.getArea()));

        rootController.setEditor(editor);

        //now that the work with views is done lets load the filData from the
        //file in filePath if present
        File file = getFilePath();
        if (file != null) {
            Task<String> task = getFileDataTask(file);
            task.setOnSucceeded(event -> {
                editor.setText(task.getValue());
                setFilePath(file);
            });
            new Thread(task).start();
        }
    }

    //File related helper methods
    //They are in Main because they also change the title
    //**********************************************************************//

    /***
     * @return if there is a filePath saved in the preferences then that
     * else null
     */
    public File getFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(getClass());
        String filePath = prefs.get(FILE_PATH_KEY, null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }

    /***
     * @param file The file to set in Preferences(Registry in Windows)
     */
    public void setFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(getClass());
        if (file != null) {
            prefs.put(FILE_PATH_KEY, file.getPath());

            primaryStage.setTitle("Text Editor - " + file.getName());
        } else {
            prefs.remove(FILE_PATH_KEY);

            primaryStage.setTitle("Text Editor");
        }
    }

    /***
     * @param data The String to be written to the file
     * @param file The file where the data will be written
     */
    public void setFileData(String data, File file) {
        if (file == null) {
            return;
        }

        try (FileOutputStream os = new FileOutputStream(file)) {
            os.write(data.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /***
     * @param file The file to get data from
     * @return the data from the file
     */
    public String getFileData(File file) {
        if (file == null) {
            return null;
        }
        String fileData = null;

        try (FileReader reader = new FileReader(file)) {
            StringBuilder builder = new StringBuilder();
            int len = 0;
            char[] buffer = new char[65536];
            while ((len = reader.read(buffer)) > 0) {
                builder.append(buffer, 0, len);
            }
            fileData = builder.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileData;
    }

    /***
     * @param data
     * @param file
     * @return a Task to set the fileData
     */
    public Task<Void> setFileDataTask(String data, File file) {
        return new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                setFileData(data, file);
                return null;
            }
        };
    }

    /***
     * @param file
     * @return returns a task to get the fileData
     */
    public Task<String> getFileDataTask(File file) {
        return new Task<String>() {
            @Override
            protected String call() throws Exception {
                return getFileData(file);
            }
        };
    }
}
