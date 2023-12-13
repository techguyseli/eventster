package com.techguyseli.Eventster.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.techguyseli.Eventster.entities.Client;
import com.techguyseli.Eventster.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        Client user = new Client(
            request.getUsername(),
            passwordEncoder.encode(request.getPassword())
        );
        repository.save(user);
        String jwt  = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
            .token(jwt)
            .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        var user = repository.findByUsername(request.getUsername())
            .orElseThrow();
        String jwt  = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
            .token(jwt)
            .build();
    }
    
}
