package com.example.UserService.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.UserService.model.User;
import com.example.UserService.repository.UserRepository;
import graphql.GraphQL;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class UserMutation implements GraphQLMutationResolver {

    @Autowired
    private UserRepository userRepository;


    //creating a customer
    public User createCustomer(final String username,final String roles,final String password,final String email,final String mobile,final Boolean is_kyc_done){
        log.info("Add Customer: {}, {}, {},{},{},{}", username, roles, password,email,mobile,is_kyc_done);
        return userRepository
                .save(User.builder()
                        .username(username)
                        .roles(roles)
                        .password(password)
                        .email(email)
                        .mobile(mobile)
                        .is_kyc_done(is_kyc_done)
                        .build());
    }
}
