package sample.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import sample.dto.PatientsDto;

import java.util.Arrays;
import java.util.List;

public class PatientRestClient {

    private static final String GET_PATIENTS_URL = "http://localhost:8080/patients";

    private final RestTemplate restTemplate;

    public PatientRestClient() {
        restTemplate = new RestTemplate();
    }

    public List<PatientsDto> getPatients() {
        ResponseEntity<PatientsDto[]> patientsResponseEntity = restTemplate.getForEntity(GET_PATIENTS_URL, PatientsDto[].class);
        return Arrays.asList(patientsResponseEntity.getBody());
    }
}
