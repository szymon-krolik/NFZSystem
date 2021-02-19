package pl.backend.nfzBackend.dto;

import lombok.Data;
import pl.backend.nfzBackend.entity.User;

@Data
public class UsersDto {

    private Long userId;
    private String firstName;
    private String lastName;
    private String userType;

    public static UsersDto of(User user) {
        UsersDto dto = new UsersDto();
        dto.setUserId(user.getUser_id());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setUserType(user.getUserType().getName());

        return dto;
    }
}
