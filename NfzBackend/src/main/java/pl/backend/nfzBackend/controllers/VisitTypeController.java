package pl.backend.nfzBackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pl.backend.nfzBackend.entity.VisitType;
import pl.backend.nfzBackend.repositories.VisitTypeRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VisitTypeController {
    private final VisitTypeRepository visitTypeRepository;

    @PostMapping("/visit-type")
    public VisitType newVisitType(@RequestBody VisitType newVisitType) {
        return visitTypeRepository.save(newVisitType);
    }

    @GetMapping("/visit-type")
    public List<VisitType> listVisitType() {
        return visitTypeRepository.findAll();
    }

    @DeleteMapping("/visit-type")
    public ResponseEntity deleteVisitType(@RequestBody Long idVisitType) {
        visitTypeRepository.deleteById(idVisitType);
        return ResponseEntity.ok().build();
    }
}
