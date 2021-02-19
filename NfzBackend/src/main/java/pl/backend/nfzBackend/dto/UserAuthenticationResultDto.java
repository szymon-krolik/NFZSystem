package pl.backend.nfzBackend.dto;

import lombok.Data;
import pl.backend.nfzBackend.entity.User;

@Data
public class UserAuthenticationResultDto {

    private Long iduser;
    private String firstName;
    private String lastName;
    private boolean authenticated;

    /* wrong passwrod or login */
    public static UserAuthenticationResultDto createUnauthenticated() {
       UserAuthenticationResultDto dto = new UserAuthenticationResultDto();
       dto.setAuthenticated(false);

       return dto;
    }

    /*correct password and login */
    public static UserAuthenticationResultDto of(User user) {
        UserAuthenticationResultDto dto = new UserAuthenticationResultDto();
        dto.setAuthenticated(true);
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setIduser(user.getUser_id());

        return dto;
    }
}
