package org.presentation;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToAdministration() throws IOException {
        App.setRoot("administration");
    }

    @FXML
    private void switchToProducer() throws IOException {
        App.setRoot("producer");
    }

    @FXML
    private void switchToViewer() throws IOException {
        App.setRoot("viewer");
    }
}
