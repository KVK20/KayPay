package com.example.UserService;

import com.example.UserService.model.User;
import com.example.UserService.repository.UserRepository;
//import com.example.UserService.config.MyUserDetailsService;
import com.example.UserService.service.MyUserDetailsService;
import com.example.UserService.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


@ExtendWith(MockitoExtension.class)
@SpringBootTest

class UserService1ApplicationTests {

    @Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserService userService;

	@InjectMocks
	private MyUserDetailsService myUserDetailsService;


//
//
//	@Test
//	void createCustomerTest() {
//
//		final User user = new User(5, "Anusha", "User","Ak@123","ak@gmail.com","12345678",true);
//		given(userRepository.save(user)).willAnswer(invocation -> invocation.getArgument(0));
//		User savedUser = userService.createCustomer(user);
//		assertThat(savedUser).isNotNull();
//		verify(userRepository).save(any(User.class));
//
//	}
//
//	@Test
//	void findUserById(){
//		final int id = 1;
//		final User user = new User(5, "Anusha", "User","Ak@123","ak@gmail.com","12345678",true);
//
//		given(userRepository.findById(id)).willReturn(Optional.of(user));
//
//		final Optional<User> expected  =userService.findUserById(id);
//
//		assertThat(expected).isNotNull();
//
//	}
//
//	@Test
//	void loginUserTest(){


//		final AuthenticationRequest authenticationRequest = new AuthenticationRequest("ak@gmail.com","Ak@123");
//
//		given(userRepository.save(authenticationRequest)).willAnswer(invocation -> invocation.getArgument(0));
//		AuthenticationRequest savedUser = myUserDetailsService.loadUserByUsername(authenticationRequest);
//		assertThat(savedUser).isNotNull();
//		verify(userRepository).save(any(AuthenticationRequest.class));




}







