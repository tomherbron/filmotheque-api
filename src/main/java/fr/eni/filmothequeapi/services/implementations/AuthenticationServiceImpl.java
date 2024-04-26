package fr.eni.filmothequeapi.services.implementations;

import fr.eni.filmothequeapi.auth.JwtService;
import fr.eni.filmothequeapi.model.classes.User;
import fr.eni.filmothequeapi.repositories.UserRepository;
import fr.eni.filmothequeapi.auth.utils.AuthenticationRequest;
import fr.eni.filmothequeapi.auth.utils.AuthenticationResponse;
import fr.eni.filmothequeapi.auth.utils.RegisterRequest;
import fr.eni.filmothequeapi.services.interfaces.AuthenticationService;
import fr.eni.filmothequeapi.utils.exceptions.DataIntregityViolation;
import fr.eni.filmothequeapi.utils.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public AuthenticationResponse register(RegisterRequest request){

        try {

            User user = new User();
            user.setFirstName(request.getFirstName());
            user.setLastName(request.getLastName());
            user.setUsername(request.getUsername());
            user.setEmail(request.getEmail());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setRoles(user.getRoles());

            user = userRepository.save(user);
            String token = jwtService.generateToken(user);

            return new AuthenticationResponse(HttpStatus.OK.value(), token);

        } catch (DataIntregityViolation e){
            return new AuthenticationResponse(HttpStatus.BAD_REQUEST.value(),
                    "Username or email already exists.");
        }
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        User user = userRepository.findUserByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Authentication failed. Please check credentials."));
        String token = jwtService.generateToken(user);

        return new AuthenticationResponse(HttpStatus.OK.value(), token);
    }


}
