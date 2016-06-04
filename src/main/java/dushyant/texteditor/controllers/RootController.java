package dushyant.texteditor.controllers;

import dushyant.texteditor.Main;
import javafx.fxml.FXML;

/**
 * Created by Dushyant Singh Shekhawat
 * on 04-06-2016.
 */

public class RootController {
    private Main main;

    private EditorController editor;

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
    }

    @FXML
    private void handleOpen() {
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
