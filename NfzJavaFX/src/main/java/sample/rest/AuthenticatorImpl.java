package sample.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import sample.dto.UserAuthenticationResultDto;
import sample.dto.UserCredentialsDto;

public class AuthenticatorImpl implements Authenticator {

    private static final String AUTHENTICATION_URL = "http://localhost:8080/verify_user_credientials";
    private final RestTemplate restTemplate;

    public AuthenticatorImpl() {
        restTemplate = new RestTemplate();
    }

    @Override
    public void authenticate(UserCredentialsDto userCredentialsDto, AuthenticationResultHandler authenticationResultHandler) {
        Runnable authenticationTask = () -> { processAuthentication(userCredentialsDto, authenticationResultHandler); };
        Thread authenticationThread = new Thread(authenticationTask);
        authenticationThread.setDaemon(true);
        authenticationThread.start();
    }

    private void processAuthentication(UserCredentialsDto userCredentialsDto, AuthenticationResultHandler authenticationResultHandler) {
        UserAuthenticationResultDto dto = new UserAuthenticationResultDto();
        dto.setAuthenticated(true);
        dto.setFirstName("Szymon");
        dto.setLastName("Królik");
        dto.setIduser(0L);
        //        ResponseEntity<UserAuthenticationResultDto> responseEntity = restTemplate.postForEntity(AUTHENTICATION_URL, userCredentialsDto, UserAuthenticationResultDto.class);
        authenticationResultHandler.handle(dto);
    }
}
