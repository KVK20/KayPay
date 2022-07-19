package com.example.UserService.repository;

import com.example.UserService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {
//    @Query("SELECT u FROM User u WHERE u.username = :username")
//    public User getUserByUsername(@Param("username") String username);
//
    @Query("SELECT u FROM User u WHERE u.email=:email")
    Optional<User> findCustomerByEmail(@Param("email") String email) ;


}