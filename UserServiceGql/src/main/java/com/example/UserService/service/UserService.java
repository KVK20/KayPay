package com.example.UserService.service;

import com.example.UserService.model.User;
import com.example.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    public Optional<User> getUser(final int id) {
        return this.userRepository.findById(id);
    }

//    @Transactional
//    public User createCustomer(String username, String roles, String password, String email, String mobile, Boolean is_kyc_done) {
//        final User user = new User();
//        user.setUsername("kk");
//        user.setRoles("User");
//        user.setPassword("kk@123");
//        user.setEmail("kk@gmail.com");
//        user.setMobile("2563867");
//        user.setIs_kyc_done(true);
//        return this.userRepository.save(user);
//    }
}
