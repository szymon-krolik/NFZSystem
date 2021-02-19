package sample.dto;

import lombok.Data;

@Data
public class UsersDto {
    private Long userId;
    private String firstName;
    private String lastName;
    private String userType;
}
