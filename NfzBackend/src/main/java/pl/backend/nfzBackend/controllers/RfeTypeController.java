package pl.backend.nfzBackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pl.backend.nfzBackend.entity.RfeType;
import pl.backend.nfzBackend.repositories.RfeTypeRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RfeTypeController {
    private final RfeTypeRepository rfeTypeRepository;


    @PostMapping("/rfe-type")
    public RfeType newRfeType(@RequestBody RfeType newRfeType) {
        return rfeTypeRepository.save(newRfeType);
    }

    @GetMapping("/rfe-type")
    public List<RfeType> listRfeType() {
        return rfeTypeRepository.findAll();
    }

    @DeleteMapping("/rfe-type")
    public ResponseEntity deleteRfeType(@RequestBody Long idRfeType) {
        rfeTypeRepository.deleteById(idRfeType);
        return ResponseEntity.ok().build();
    }
}
