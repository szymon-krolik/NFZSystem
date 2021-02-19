package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    //TODO add user list(button), add patients list(button)
    private static final String ADD_USER_FXML = "/fxml/users/add-user.fxml";
    private static final String ADD_PATIENT_FXML = "/fxml/patients/add-patient.fxml";
    @FXML
    private Pane adminPane;
    @FXML
    private Button exitButton;

    @FXML
    private Button addUserButton;

    @FXML
    private Button addPatientButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeAddUserButton();
        initializeAddPatientButton();
    }

    private void initializeAddPatientButton() {
        addPatientButton.setOnAction((x) -> {
            Stage addPatientStage = new Stage();
            addPatientStage.initStyle(StageStyle.UNDECORATED);
            addPatientStage.initModality(Modality.APPLICATION_MODAL);
            try {
                Parent addPatientParent = FXMLLoader.load(getClass().getResource(ADD_PATIENT_FXML));
                Scene scene = new Scene(addPatientParent,500,400);
                addPatientStage.setScene(scene);
                addPatientStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void initializeAddUserButton() {
        addUserButton.setOnAction((x) -> {
            Stage addUserStage = new Stage();
            addUserStage.initStyle(StageStyle.UNDECORATED);
            addUserStage.initModality(Modality.APPLICATION_MODAL);
            try {
                Parent addUserParent = FXMLLoader.load(getClass().getResource(ADD_USER_FXML));
                Scene scene = new Scene(addUserParent,500,400);
                addUserStage.setScene(scene);
                addUserStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private Stage getStagge() {
        return (Stage) adminPane.getScene().getWindow();
    }
}
