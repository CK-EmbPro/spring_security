package com.springboot.springsec.service;

import com.springboot.springsec.model.Users;
import com.springboot.springsec.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UsersRepo repo;

    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authManager;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public String register(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return jwtService.generateToken(user.getUsername());
    }

    public String verify(Users user){
        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (auth.isAuthenticated())
            return jwtService.generateToken(user.getUsername());
        return "FAIL";
    }

    public List<Users> getAll(Users user){

        return repo.findAll();
    }
}
