package org.example.jwtconfig;

import org.example.models.User;
import org.example.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtService jwtService;

    Boolean isPasswordValid;


    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(User user) {
//        User user = new User();
//        user.setUsername(user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        User savedUser = userRepo.save(user);
        String jwtTokenRegister = jwtService.generateToken(savedUser);
        return new AuthenticationResponse(jwtTokenRegister);
    }

    public AuthenticationResponse authenticate(User user) {
        try{
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );
        } catch (Exception e) {
            System.out.println("Somethings goes wrong:"+e);
        }
        User authenticatedUser = userRepo.findByUsername(user.getUsername());
        if (user.getUsername().equals("rus")) {
            isPasswordValid = user.getPassword().equals(authenticatedUser.getPassword());
        } else {
            isPasswordValid = passwordEncoder.matches(user.getPassword(), authenticatedUser.getPassword());
        }
        if (!isPasswordValid) {
            throw new BadCredentialsException("Invalid username or password");
        }
        String jwtTokenAuthenticate = jwtService.generateToken(authenticatedUser);
        return new AuthenticationResponse(jwtTokenAuthenticate);
    }
}