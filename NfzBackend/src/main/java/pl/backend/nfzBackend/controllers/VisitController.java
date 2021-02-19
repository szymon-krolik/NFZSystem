package pl.backend.nfzBackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pl.backend.nfzBackend.entity.Visit;
import pl.backend.nfzBackend.repositories.VisitRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VisitController {
    private final VisitRepository visitRepository;

    @PostMapping("/visit")
    public Visit newVisit(@RequestBody Visit newVisit) {
        return visitRepository.save(newVisit);
    }

    @GetMapping("/visit")
    public  List<Visit> listVisit() {
        return visitRepository.findAll();
    }

    @DeleteMapping("/visit")
    public ResponseEntity deleteVisit(@RequestBody Long idVisit) {
        visitRepository.deleteById(idVisit);
        return ResponseEntity.ok().build();
    }
}
