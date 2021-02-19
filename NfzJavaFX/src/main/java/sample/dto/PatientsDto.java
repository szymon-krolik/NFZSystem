package sample.dto;

import lombok.Data;

@Data
public class PatientsDto {
    private Long patientId;
    private String firstName;
    private String lastName;
    private String personalIdentityNumber;


}
