package pl.backend.nfzBackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.backend.nfzBackend.entity.Contact;
import pl.backend.nfzBackend.repositories.ContactRepositories;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ContactController {

    private final ContactRepositories contactRepositories;
    @PostMapping("/contact")
    public Contact newContact(@RequestBody Contact newContact) {
        return contactRepositories.save(newContact);
    }

    @GetMapping("/contact")
    public List<Contact> listContact() {
        return contactRepositories.findAll();
    }

    @DeleteMapping("/contact")
    public ResponseEntity deleteContact(@RequestBody Long idContact) {
        contactRepositories.deleteById(idContact);
        return ResponseEntity.ok().build();
    }
}
