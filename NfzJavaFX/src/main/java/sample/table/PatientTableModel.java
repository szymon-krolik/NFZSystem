package sample.table;

import javafx.beans.property.SimpleStringProperty;
import sample.dto.PatientsDto;

public class PatientTableModel {

    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty personalIdentityNumber;

    public PatientTableModel(String firstName, String lastName, String personalIdentityNumber) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.personalIdentityNumber = new SimpleStringProperty(personalIdentityNumber);
    }

    public static PatientTableModel of(PatientsDto dto) {
        return new PatientTableModel(dto.getFirstName(), dto.getLastName(), dto.getPersonalIdentityNumber());
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getPersonalIdentityNumber() {
        return personalIdentityNumber.get();
    }

    public SimpleStringProperty personalIdentityNumberProperty() {
        return personalIdentityNumber;
    }

    public void setPersonalIdentityNumber(String personalIdentityNumber) {
        this.personalIdentityNumber.set(personalIdentityNumber);
    }
}
