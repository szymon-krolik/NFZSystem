package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {
    private static final String USERS_FXML = "/fxml/users.fxml";
    private static final String PATIENTS_FXML = "/fxml/patients.fxml";
    private static final String ADMIN_FXML = "/fxml/admin/adminMainView.fxml";
    private static final String APP_TITLE = "NFZSystem";
    @FXML
    private BorderPane appBorderPane;

    @FXML
    private Button userMenuButton;

    @FXML
    private Button patientMenuButton;

    @FXML
    private Button adminMenuButton;

    @FXML
    private Button exitButton;



    public void initialize(URL location, ResourceBundle resources) {
        initializeExitButton();
        initializeUsersMenuButton();
        initializeAdminMenuButton();
        initializePatientsMenuButton();
    }

    private void initializeAdminMenuButton() {
        adminMenuButton.setOnAction((x) -> {
            Stage adminStage = new Stage();
            adminStage.initStyle(StageStyle.UNDECORATED);
            try {
                Parent adminStageParent = FXMLLoader.load(getClass().getResource(ADMIN_FXML));
                Scene scene = new Scene(adminStageParent, 1024,768);
                adminStage.setScene(scene);
                adminStage.show();
                getStage().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void initializeUsersMenuButton() {
        userMenuButton.setOnAction((x) -> {
            Stage usersStage = new Stage();
            usersStage.initStyle(StageStyle.UNDECORATED);
            try {
                Parent userStageParent = FXMLLoader.load(getClass().getResource(USERS_FXML));
                Scene scene = new Scene(userStageParent, 1024, 768);
                usersStage.setScene(scene);
                usersStage.show();
                getStage().close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }

    private void initializePatientsMenuButton() {
        patientMenuButton.setOnAction((x) -> {
            Stage patientsStage = new Stage();
            patientsStage.initStyle(StageStyle.UNDECORATED);
            try {
                Parent patientsStageParent = FXMLLoader.load(getClass().getResource(PATIENTS_FXML));
                Scene scene = new Scene(patientsStageParent, 1024,768);
                patientsStage.setScene(scene);
                patientsStage.show();
                getStage().close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        });
    }
    private void initializeExitButton() {
        exitButton.setOnAction((x) -> {
            getStage().close();
        });
    }


    private Stage getStage() {
        return (Stage) appBorderPane.getScene().getWindow();
    }
}
