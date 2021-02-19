package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.dto.UsersDto;
import sample.rest.UserRestClient;
import sample.table.UserTableModel;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class UserController implements Initializable {

    private final UserRestClient userRestClient;
    private static final String ADD_USER_FXML = "/fxml/users/add-user.fxml";

    @FXML
    private TableView<UserTableModel> usersTableView;

    @FXML
    private Button addButton;

    @FXML
    private Button viewButton;

    @FXML
    private Button editButton;

    @FXML
    private Button deleteButton;

    public UserController() {
        userRestClient =  new UserRestClient();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeAddUserButton();
        initializeTableView();
    }

    //TODO zmienic w innych kontrolelrach sposob ladowania nowych widoków
    private void initializeAddUserButton() {
        addButton.setOnAction((x) -> {
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

    private void initializeTableView() {
        usersTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); //równe kolumny

        TableColumn firstNameColumn = new TableColumn("First Name");
        firstNameColumn.setMinWidth(100);
        //<Nadrzedny model, typ pola>(nazwa pola z userTableModel)
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<UserTableModel, String>("firstName"));

        TableColumn lastNameColumn = new TableColumn("Last Name");
        lastNameColumn.setMinWidth(100);
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<UserTableModel, String>("lastName"));

        TableColumn userTypeColumn = new TableColumn("User Type");
        userTypeColumn.setMinWidth(100);
        userTypeColumn.setCellValueFactory(new PropertyValueFactory<UserTableModel, String>("userType"));

        usersTableView.getColumns().addAll(firstNameColumn, lastNameColumn, userTypeColumn);

        ObservableList<UserTableModel> data = FXCollections.observableArrayList();

        loadUsersData(data);

        usersTableView.setItems(data);
    }

    private void loadUsersData(ObservableList<UserTableModel> data) {
        //nowy watek zeby nie muliło
        Thread thread = new Thread(() -> {
            List<UsersDto> users = userRestClient.getUsers();//pobranie z bazy danych

            //z listy na table model
            data.addAll(users.stream().map(UserTableModel::of).collect(Collectors.toList()));
        });
        thread.start();

    }
}
