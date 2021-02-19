package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddPatientController implements Initializable {

    @FXML
    private BorderPane addPatientBorderPane;
    @FXML
    private Button saveButton;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField loginTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initizalizeCancelButton();
    }

    private void initizalizeCancelButton() {
        cancelButton.setOnAction((x) -> {
            getStagge().close();
        });
    }

    private Stage getStagge() {
        return (Stage) addPatientBorderPane.getScene().getWindow();
    }
}
