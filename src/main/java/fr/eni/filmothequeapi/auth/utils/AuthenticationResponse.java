package fr.eni.filmothequeapi.auth.utils;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {

    private int statusCode;
    private String token;

}
