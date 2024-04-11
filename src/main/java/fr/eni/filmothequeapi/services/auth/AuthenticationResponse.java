package fr.eni.filmothequeapi.services.auth;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {

    private String token;

}
