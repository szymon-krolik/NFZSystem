package pl.backend.nfzBackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pl.backend.nfzBackend.dto.UserAuthenticationResultDto;
import pl.backend.nfzBackend.dto.UserCredientialsDto;
import pl.backend.nfzBackend.dto.UsersDto;
import pl.backend.nfzBackend.entity.User;
import pl.backend.nfzBackend.repositories.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @PostMapping("/users")
    public User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    public List<UsersDto> listUser() {
        return userRepository.findAll()
                .stream()//zamiana listy na strumien
                .map(UsersDto::of)//wywolanie metody of na kazdym obiekcie listy
                .collect(Collectors.toList());//zbieranie przy pomocy collect
    }

    @DeleteMapping("/users")
    public ResponseEntity deleteUser(@RequestBody Long idUser) {
        userRepository.deleteById(idUser);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/verify_user_credientials")
    public UserAuthenticationResultDto verifyUserCredientials(@RequestBody UserCredientialsDto userCredientialsDto) {
        Optional<User> operatorOptional = userRepository.findByLogin(userCredientialsDto.getLogin());
        if (!operatorOptional.isPresent()) {
            return UserAuthenticationResultDto.createUnauthenticated();
        }
        User user = operatorOptional.get();

        if (!user.getPassword().equals(userCredientialsDto.getPassword())) {
            return UserAuthenticationResultDto.createUnauthenticated();
        } else {
            return UserAuthenticationResultDto.of(user);
        }

    }
}
