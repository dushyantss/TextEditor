package dushyant.texteditor.controllers;

import dushyant.texteditor.Main;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;

import java.io.File;

/**
 * Created by Dushyant Singh Shekhawat
 * on 04-06-2016.
 */

public class RootController {
    private Main main;

    private EditorController editor;

    private String initialData = "";

    public void setEditor(EditorController editor) {
        this.editor = editor;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    //FileMenu handlers
    //**********************************************************************//

    @FXML
    private void handleNew() {
        //if data has changed then save the changed file
        if (!initialData.equals(editor.getText())) {
            handleSave();
        }

        // delete all data, set initial data = "" and remove the filePath from the preferences
        initialData = "";
        editor.setText(initialData);
        main.setFilePath(null);
    }

    @FXML
    private void handleOpen() {
        //if data has changed then save the changed file
        if (!initialData.equals(editor.getText())) {
            handleSave();
        }

        //now open a file chooser  and get the selected file
        FileChooser chooser = new FileChooser();
        FileChooser.ExtensionFilter ext = new FileChooser.ExtensionFilter("TXT files", "*.txt");
        chooser.getExtensionFilters().add(ext);

        File file = chooser.showOpenDialog(main.getPrimaryStage());

        //now if the file is not null then we will
        //-get filedata and save it in initialData
        //-set the area text to initialData
        //-set filePath to that file

        if (file != null) {
            Task<String> task = main.getFileDataTask(file);
            task.setOnSucceeded(event -> {
                initialData = task.getValue();
                editor.setText(initialData);
            });
            new Thread(task).start();
            main.setFilePath(file);
        }
    }

    @FXML
    private void handleSave() {
    }

    @FXML
    private void handleSaveAs() {
    }

    @FXML
    private void handleExit() {
    }

    //EditMenu handlers
    //**********************************************************************//

    @FXML
    private void handleCut() {
    }

    @FXML
    private void handleCopy() {
    }

    @FXML
    private void handlePaste() {
    }

    @FXML
    private void handleDelete() {
    }

    //HelpMenu handlers
    //**********************************************************************//

    @FXML
    private void handleAbout() {
    }
}
