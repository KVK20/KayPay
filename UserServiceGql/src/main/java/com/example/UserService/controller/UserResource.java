package com.example.UserService.controller;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.UserService.model.AuthenticationRequest;
import com.example.UserService.model.AuthenticationResponse;
import com.example.UserService.model.User;
import com.example.UserService.repository.UserRepository;
import com.example.UserService.service.MyUserDetailsService;
import com.example.UserService.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Slf4j
@Component
public class UserResource implements GraphQLQueryResolver {


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Autowired
    private UserRepository repository;

    // Lists all the Users
    public List<User> getAllUser() {
        return (List<User>) repository.findAll();
    }

    //Lists users as per their id's
    public Optional<User> userById(int id) {
        log.info("Get User by ID: {}", id);
        return repository.findById(id);

    }


    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws  Exception {
        System.out.println(authenticationRequest.getEmail() + " " + authenticationRequest.getPassword());
        try{authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
        );}
        catch (BadCredentialsException e){
            e.printStackTrace();
            throw new Exception("Incorrect username or password", e);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        final UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getEmail());
        System.out.println(userDetails);
        String jwt = null;
        try{
            jwt=jwtTokenUtil.generateToken(userDetails);
            System.out.println(jwt);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt,userDetails.getUsername(), userDetails.getAuthorities()));
    }

//    @PostMapping("/login")
//    public Optional<AuthenticationRequest> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws  Exception {
//        System.out.println(authenticationRequest.getEmail() + " " + authenticationRequest.getPassword());
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
//            );
//        } catch (BadCredentialsException e) {
//            e.printStackTrace();
//            throw new Exception("Incorrect username or password", e);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        final UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getEmail());
//        System.out.println(userDetails);
//        String jwt = null;
//        try {
//            jwt = jwtTokenUtil.generateToken(userDetails);
//            System.out.println(jwt);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        jwt = jwtTokenUtil.generateToken(userDetails);
//
//
//        return new AuthenticationRequest(new AuthenticationResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
//
//    }


}