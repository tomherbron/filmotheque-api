package fr.eni.filmothequeapi.auth.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private String firstName;
    private String lastName;
    private String gender;
    private Date birthDate;
    private String username;
    private String email;
    private String password;

}
