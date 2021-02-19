package sample.dto;


import lombok.Data;

/*odbieranie od backednfu */
@Data
public class UserAuthenticationResultDto {

    private Long iduser;
    private String firstName;
    private String lastName;
    private boolean authenticated;
}
