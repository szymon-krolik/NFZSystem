package pl.backend.nfzBackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pl.backend.nfzBackend.entity.Surgery;
import pl.backend.nfzBackend.repositories.SurgeryRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SurgeryController {
    private final SurgeryRepository surgeryRepository;

    @PostMapping("/surgery")
    public Surgery newSurgery(@RequestBody Surgery newSurgery) {
        return surgeryRepository.save(newSurgery);
    }

    @GetMapping("/surgery")
    public  List<Surgery> listSurgery() {
        return surgeryRepository.findAll();
    }

    @DeleteMapping("/surgery")
    public ResponseEntity deleteSurgery(@RequestBody Long idSurgery) {
        surgeryRepository.deleteById(idSurgery);
        return ResponseEntity.ok().build();
    }
}
