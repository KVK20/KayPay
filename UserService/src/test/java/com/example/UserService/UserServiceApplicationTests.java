package com.example.UserService;

import com.example.UserService.Model.AuthenticationRequest;
import com.example.UserService.Model.User;
import com.example.UserService.Repository.UserRepository;
import com.example.UserService.config.MyUserDetailsService;
import com.example.UserService.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest

class UserServiceApplicationTests {

    @Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserService userService;

	@InjectMocks
	private MyUserDetailsService myUserDetailsService;




	@Test
	void createCustomerTest() {

		final User user = new User(5, "Anusha", "User","Ak@123","ak@gmail.com","12345678",true);
		given(userRepository.save(user)).willAnswer(invocation -> invocation.getArgument(0));
		User savedUser = userService.createCustomer(user);
		assertThat(savedUser).isNotNull();
		verify(userRepository).save(any(User.class));

	}

	@Test
	void findUserById(){
		final int id = 1;
		final User user = new User(5, "Anusha", "User","Ak@123","ak@gmail.com","12345678",true);

		given(userRepository.findById(id)).willReturn(Optional.of(user));

		final Optional<User> expected  =userService.findUserById(id);

		assertThat(expected).isNotNull();

	}

	@Test
	void loginUserTest(){


//		final AuthenticationRequest authenticationRequest = new AuthenticationRequest("ak@gmail.com","Ak@123");
//
//		given(userRepository.save(authenticationRequest)).willAnswer(invocation -> invocation.getArgument(0));
//		AuthenticationRequest savedUser = myUserDetailsService.loadUserByUsername(authenticationRequest);
//		assertThat(savedUser).isNotNull();
//		verify(userRepository).save(any(AuthenticationRequest.class));

	}


}







