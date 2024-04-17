package com.slamy.library.services;

import com.slamy.library.models.Email;
import com.slamy.library.models.User;
import com.slamy.library.repositories.EmailRepository;
import com.slamy.library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final EmailRepository emailRepository;

    @Autowired
    public UserService(UserRepository userRepository, EmailRepository emailRepository) {
        this.userRepository = userRepository;
        this.emailRepository = emailRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        if (this.emailRepository.existsByName(email)) {
            Email email2 = this.emailRepository.findByName(email);
            User user = this.userRepository.findByEmail(email2);

            if (user == null) {
                throw new UsernameNotFoundException("User not found with email: " + email);
            }

            return user;
        }

        return null;
    }
}
