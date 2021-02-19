package sample.controller;

import javafx.application.Platform;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.dto.UserCredentialsDto;
import sample.factory.PopupFactory;
import sample.rest.Authenticator;
import sample.rest.AuthenticatorImpl;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private static final String APP_FXML = "/fxml/app.fxml";
    private static final String APP_TITLE = "NFZSystem";

    private PopupFactory popupFactory;
    private Authenticator authenticator;

    @FXML
    private Button exitButton;
    @FXML
    private Button loginButton;
    @FXML
    private AnchorPane loginAnchorPane;
    @FXML
    private TextField loginTextField;
    @FXML
    private TextField passwordTextField;

    public LoginController(){
        popupFactory = new PopupFactory();
        authenticator = new AuthenticatorImpl();
    }


    public void initialize(URL location, ResourceBundle resources) {
        initializeExitButton();
        initializeLoginButton();
    }

    private void initializeLoginButton() {
        loginButton.setOnAction((x) -> {
           performAuthentication();
        });
    }

    private void performAuthentication() {
        Stage waitingPopup = popupFactory.createWaitingPopup("Connecting to the server...");
        waitingPopup.show();
        String login = loginTextField.getText();
        String password = passwordTextField.getText();
        UserCredentialsDto dto = new UserCredentialsDto();
        dto.setLogin(login);
        dto.setPassword(password);
        authenticator.authenticate(dto, (authenticationResult) -> {
            Platform.runLater(() ->{
                waitingPopup.close();
                if (authenticationResult.isAuthenticated()) {
                    openAppAndCloseLoginStag();
                } else {
                    showIncorrentCredentialsMessage();
                }
            });
        });
    }

    private void showIncorrentCredentialsMessage() {
        //TODO
        System.out.println("zle");
    }

//    otwiera nowa scene po akcji i zamyka poprzednia
    private void openAppAndCloseLoginStag() {
        Stage appStage = new Stage();
        Parent appRoot = null;

        try {
//            ładowanie adresu nowej sceny
          appRoot = FXMLLoader.load(getClass().getResource(APP_FXML));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(appRoot,1024,768);
        appStage.initStyle(StageStyle.UNDECORATED);
        appStage.setTitle(APP_TITLE);
        appStage.setScene(scene);
        appStage.show();
        getStage().close();

    }

    private void initializeExitButton() {
        exitButton.setOnAction((x) -> {
           getStage().close();
        });
    }

//    Pobiera aktualna scene jaka jest wyswietlana
    private Stage getStage(){
        return (Stage) loginAnchorPane.getScene().getWindow();
    }

}
