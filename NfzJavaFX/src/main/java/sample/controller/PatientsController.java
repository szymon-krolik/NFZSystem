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
import sample.dto.PatientsDto;
import sample.rest.PatientRestClient;
import sample.table.PatientTableModel;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class PatientsController implements Initializable {
    private final PatientRestClient patientRestClient;
    private static final String ADD_PATIENT_FXML = "/fxml/patients/add-patient.fxml";

    @FXML
    private TableView<PatientTableModel> patientsTableView;

    @FXML
    private Button addButton;

    @FXML
    private Button viewButton;

    @FXML
    private Button editButton;

    @FXML
    private Button deleteButton;

  public PatientsController() {
      patientRestClient = new PatientRestClient();
  }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeTableView();
        initializeAddPatientButton();
    }

    private void initializeAddPatientButton() {
      addButton.setOnAction((x) -> {
          Stage addPatientStage = new Stage();
          addPatientStage.initStyle(StageStyle.UNDECORATED);
          addPatientStage.initModality(Modality.APPLICATION_MODAL);

          try {
              Parent addPatientParent = FXMLLoader.load(getClass().getResource(ADD_PATIENT_FXML));
              Scene scene = new Scene(addPatientParent, 500,400);
              addPatientStage.setScene(scene);
              addPatientStage.show();
          } catch (IOException e) {
              e.printStackTrace();
          }

      });
    }

    private void initializeTableView() {
        patientsTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn firstNameColumn = new TableColumn("First Name");
        firstNameColumn.setMinWidth(100);
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<PatientTableModel, String>("firstName"));

        TableColumn lastNameColumn = new TableColumn("Last Name");
        lastNameColumn.setMinWidth(100);
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<PatientTableModel, String>("lastName"));

        TableColumn personalIdentityNumberColumn = new TableColumn("PIN");
        personalIdentityNumberColumn.setMinWidth(100);
        personalIdentityNumberColumn.setCellValueFactory(new PropertyValueFactory<PatientTableModel, String>("personalIdentityNumber"));

        patientsTableView.getColumns().addAll(firstNameColumn, lastNameColumn, personalIdentityNumberColumn);
        ObservableList<PatientTableModel> data = FXCollections.observableArrayList();
        loadPatientsData(data);

        patientsTableView.setItems(data);
    }

    private void loadPatientsData(ObservableList<PatientTableModel> data) {
        Thread thread = new Thread(() -> {
            List<PatientsDto> patients = patientRestClient.getPatients();
            data.addAll(patients.stream().map(PatientTableModel::of).collect(Collectors.toList()));
        });

        thread.start();
    }
}
