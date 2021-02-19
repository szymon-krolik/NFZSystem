package pl.backend.nfzBackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pl.backend.nfzBackend.dto.PatientsDto;
import pl.backend.nfzBackend.entity.Patient;

import pl.backend.nfzBackend.repositories.PatientRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PatientController {
    private final PatientRepository patientRepository;

    @PostMapping("/patients")
    public Patient newPatient(@RequestBody Patient newPatient) {
        return patientRepository.save(newPatient);
    }

    @GetMapping("/patients")
    public List<PatientsDto> listPatient() {
        return patientRepository.findAll()
                .stream()
                .map(PatientsDto::of)
                .collect(Collectors.toList());

    }

    @DeleteMapping("/patients")
    public ResponseEntity deletePatient(@RequestBody Long idPatient) {
        patientRepository.deleteById(idPatient);
        return ResponseEntity.ok().build();
    }
}
