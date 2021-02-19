package pl.backend.nfzBackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pl.backend.nfzBackend.entity.Prescription;
import pl.backend.nfzBackend.repositories.PrescriptionRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PrescriptionController {
    private final PrescriptionRepository prescriptionRepository;

    @PostMapping("/prescription")
    public Prescription newPrescription(@RequestBody Prescription newPrescription) {
        return prescriptionRepository.save(newPrescription);
    }

    @GetMapping("/prescription")
    public List<Prescription> listPrescription() {
        return prescriptionRepository.findAll();
    }

    @DeleteMapping("/prescription")
    public ResponseEntity deletePrescription(@RequestBody Long idPrescription) {
        prescriptionRepository.deleteById(idPrescription);
        return ResponseEntity.ok().build();
    }
}
