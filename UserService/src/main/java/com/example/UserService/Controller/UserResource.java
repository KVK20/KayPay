package com.example.UserService.Controller;

import com.example.UserService.Model.AuthenticationRequest;
import com.example.UserService.Model.AuthenticationResponse;
import com.example.UserService.Model.User;
import com.example.UserService.Repository.UserRepository;
import com.example.UserService.config.MyUserDetailsService;
import com.example.UserService.service.UserService;
import com.example.UserService.util.JwtUtil;
import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.List;
//import java.util.logging.Logger;

@RestController
public class UserResource {

    @Value("classpath: schema.graphqls")
    private Resource schemaResource;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailService;

    @Autowired
    private JwtUtil jwtTokenUtil;

   // private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static final Logger logger = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    private UserRepository repository;


    @GetMapping("/hello")
    public String hello()
    {
        logger.trace("method accessed");
        return "Hello Daily Code Buffer!!";
    }

    @GetMapping("/getusers")

    List<User> findAll() {
        return repository.findAll();
    }



   // @ApiOperation(value = "Register New User")
   @PostMapping("/users")
   public void createCustomer(@RequestBody User user) {
       user.setPassword(passwordEncoder.encode(user.getPassword()));
       userService.createCustomer(user);
   }

   // @ApiOperation(value = "user login")
    /*

     */
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

    // Find a given user
   // @ApiOperation(value = "Find User by Id ")
    @GetMapping("/users/{id}")
  
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return userService.findUserById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}