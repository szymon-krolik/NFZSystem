package sample.table;

import javafx.beans.property.SimpleStringProperty;
import sample.dto.UsersDto;

public class UserTableModel {

    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty userType;

    public UserTableModel(String firstName, String lastName, String userType) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.userType = new SimpleStringProperty(userType);
    }

    public static UserTableModel of(UsersDto dto) {
        return new UserTableModel(dto.getFirstName(), dto.getLastName(), dto.getUserType());
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

    public String getUserType() {
        return userType.get();
    }

    public SimpleStringProperty userTypeProperty() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType.set(userType);
    }
}
