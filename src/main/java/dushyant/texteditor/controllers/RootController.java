package dushyant.texteditor.controllers;

import dushyant.texteditor.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * Created by Dushyant Singh Shekhawat
 * on 04-06-2016.
 */

public class RootController {
    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    //FileMenu handlers
    //**********************************************************************//

    @FXML
    private void handleNew(ActionEvent actionEvent) {
    }

    @FXML
    private void handleOpen(ActionEvent actionEvent) {
    }

    @FXML
    private void handleSave(ActionEvent actionEvent) {
    }

    @FXML
    private void handleSaveAs(ActionEvent actionEvent) {
    }

    @FXML
    private void handleExit(ActionEvent actionEvent) {
    }

    //EditMenu handlers
    //**********************************************************************//

    @FXML
    private void handleCut(ActionEvent actionEvent) {
    }

    @FXML
    private void handleCopy(ActionEvent actionEvent) {
    }

    @FXML
    private void handlePaste(ActionEvent actionEvent) {
    }

    @FXML
    private void handleDelete(ActionEvent actionEvent) {
    }

    //HelpMenu handlers
    //**********************************************************************//

    @FXML
    private void handleAbout(ActionEvent actionEvent) {
    }
}
