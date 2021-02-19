package sample.rest;

import sample.dto.UserAuthenticationResultDto;

@FunctionalInterface
public interface AuthenticationResultHandler {

    void handle(UserAuthenticationResultDto userAuthenticationResultDto);
}
