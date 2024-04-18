package fr.eni.filmothequeapi.services.auth;

import fr.eni.filmothequeapi.auth.utils.AuthenticationRequest;
import fr.eni.filmothequeapi.auth.utils.AuthenticationResponse;
import fr.eni.filmothequeapi.auth.utils.RegisterRequest;

public interface AuthenticationService {
    public AuthenticationResponse register(RegisterRequest request);
    public AuthenticationResponse authenticate(AuthenticationRequest request);

}
