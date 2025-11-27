package com.example.forms_collect.service;
import com.example.forms_collect.dto.LoginUserDto;
import com.example.forms_collect.dto.RegisterUserDto;
import com.example.forms_collect.entity.User;
import com.example.forms_collect.enumeration.UserRole;
import com.example.forms_collect.repository.IUserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    private final IJwtService jwtService;

    public AuthenticationService(
            IUserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder,
            IJwtService jwtService
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    /**
     * REGISTER
     */
    public User signup(RegisterUserDto input) {
        User user = new User()
                .setFullName(input.getFullName())
                .setEmail(input.getEmail())
                .setPassword(passwordEncoder.encode(input.getPassword()))
                .setRole(UserRole.USER)
                .setEnabled(true)
                .setExpired(false);

        return userRepository.save(user);
    }

    /**
     * LOGIN + JWT TOKEN
     */
    public Map<String, Object> authenticate(LoginUserDto input) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = (User) authentication.getPrincipal();

        String token = jwtService.generateToken(user);

        Map<String, Object> result = new HashMap<>();
        result.put("token", token);
        result.put("user", user);

        return result;
    }}


