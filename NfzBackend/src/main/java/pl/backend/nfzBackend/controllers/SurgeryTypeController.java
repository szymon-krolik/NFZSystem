package pl.backend.nfzBackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pl.backend.nfzBackend.entity.SurgeryType;
import pl.backend.nfzBackend.repositories.SurgeryTypeRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SurgeryTypeController {
    private final SurgeryTypeRepository surgeryTypeRepository;

    @PostMapping("/surgery-type")
    public SurgeryType newSurgeryType(@RequestBody SurgeryType newSurgeryType) {
        return surgeryTypeRepository.save(newSurgeryType);
    }

    @GetMapping("/surgery-type")
    public List<SurgeryType> listSurgeryType() {
        return surgeryTypeRepository.findAll();
    }

    @DeleteMapping("/surgery-type")
    public ResponseEntity deleteSurgeryType(@RequestBody Long idSurgeryType) {
        surgeryTypeRepository.deleteById(idSurgeryType);
        return ResponseEntity.ok().build();
    }
}
