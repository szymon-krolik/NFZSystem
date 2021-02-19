package pl.backend.nfzBackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pl.backend.nfzBackend.entity.Rfe;
import pl.backend.nfzBackend.repositories.RfeRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RfeController {
    private final RfeRepository rfeRepository;


    @PostMapping("/rfe")
    public  Rfe newRfe(@RequestBody Rfe newRfe) {
        return rfeRepository.save(newRfe);
    }

    @GetMapping("/rfe")
    public List<Rfe> listRfe() {
        return rfeRepository.findAll();
    }

    @DeleteMapping("/rfe")
    public ResponseEntity deleteRfe(@RequestBody Long idRfe) {
        rfeRepository.deleteById(idRfe);
        return ResponseEntity.ok().build();
    }
}
