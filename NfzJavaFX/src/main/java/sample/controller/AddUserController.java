package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddUserController implements Initializable {

    @FXML
    private BorderPane addUserBorderPane;
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
        initializeCancelButton();
    }

    private void initializeCancelButton() {
        cancelButton.setOnAction((x) -> {
            getStage().close();
        });
    }

    private Stage getStage() {
        return (Stage) addUserBorderPane.getScene().getWindow();
    }
}
