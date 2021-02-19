package sample.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import sample.dto.UsersDto;

import java.util.Arrays;
import java.util.List;

public class UserRestClient {

    private static final String GET_USERS_URL = "http://localhost:8080/users";

    //zadania http
    private final RestTemplate restTemplate;

    public UserRestClient() {
        restTemplate = new RestTemplate();
    }

    public List<UsersDto> getUsers() {
        ResponseEntity<UsersDto[]> usersResponseEntity = restTemplate.getForEntity(GET_USERS_URL, UsersDto[].class);
        return Arrays.asList(usersResponseEntity.getBody());
    }
}
