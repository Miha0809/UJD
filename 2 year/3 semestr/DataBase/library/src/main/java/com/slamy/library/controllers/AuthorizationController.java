package com.slamy.library.controllers;

import com.slamy.library.models.Email;
import com.slamy.library.models.Login;
import com.slamy.library.models.Role;
import com.slamy.library.models.User;
import com.slamy.library.repositories.EmailRepository;
import com.slamy.library.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api/authorization")
public class AuthorizationController {
    private final UserRepository userRepository;
    private final EmailRepository emailRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public AuthorizationController(AuthenticationManager authenticationManager, UserRepository userRepository, EmailRepository emailRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.emailRepository = emailRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public String login(@RequestBody Login login) {
        try {
            Email email = emailRepository.findByName(login.getEmail());
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email.getName(), login.getPassword())
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            return "Login successful!";
        } catch (Exception e) {
            return e.toString();
        }
    }

    @PostMapping("/register_as_admin")
    public String registerAsAdmin(@RequestBody User user) {
        if (!this.userRepository.findAllBy().isEmpty()) {
            return "User already exists with admin role";
        }

        try {
            Email email = user.getEmail();

            if (email != null) {
                user.setRole(Role.ROLE_ADMIN);
                emailRepository.save(email);
            }

            user.setPassword(passwordEncoder.encode(user.getPassword()));
            this.userRepository.save(user);

            return "Register is successful!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
