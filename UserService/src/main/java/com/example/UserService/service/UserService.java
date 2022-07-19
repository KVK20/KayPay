package com.example.UserService.service;

import com.example.UserService.Model.User;
import com.example.UserService.Repository.UserRepository;
import com.example.UserService.util.JwtUtil;
import org.hibernate.PropertyValueException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;


    public User createCustomer(User customer) {
        return userRepository.save(customer);
    }


    public Optional<User> findUserById(int id) {
        return userRepository.findById(id);
    }


}
