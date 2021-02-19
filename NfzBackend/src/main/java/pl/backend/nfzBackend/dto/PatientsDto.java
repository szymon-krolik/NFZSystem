package pl.backend.nfzBackend.dto;

import lombok.Data;
import pl.backend.nfzBackend.entity.Patient;

@Data
public class PatientsDto {
    private Long patientId;
    private String firstName;
    private String lastName;
    private String personalIdentityNumber;

    public static PatientsDto of(Patient patient) {
        PatientsDto dto = new PatientsDto();
        dto.setPatientId(patient.getPatient_id());
        dto.setFirstName(patient.getFirstName());
        dto.setLastName(patient.getLastName());
        dto.setPersonalIdentityNumber(patient.getPersonalIdentityNumber());
        return dto;
    }
}
