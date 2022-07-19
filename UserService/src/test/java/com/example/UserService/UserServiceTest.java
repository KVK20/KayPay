package com.example.UserService;


import com.example.UserService.Controller.UserResource;
import com.example.UserService.Model.AuthenticationRequest;
import com.example.UserService.Model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceTest {

    @MockBean
    private UserResource userResource;

//    @Mock
//    private MyUserDetailsService mockUserDetailsService;
//
//    @Mock
//    private AuthenticationManager mockAuthenticationManager;

    @Autowired
    private MockMvc mvc;



    @Test
    public void testAddUser() throws Exception {
        User employee = getUser();
        doNothing().when(userResource).createCustomer(employee);
        mvc.perform(post("/users").content(asJson(employee)).contentType(APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
    }

//    @Test
//    public void testAuthenticateUser() throws Exception {
//        User localUser = User.create(user, null, null, null);
//        AuthenticationRequest loginRequest = new AuthenticationRequest(user.getEmail(), user.getPassword());
//        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(localUser, null);
//        Mockito.when(authenticationManager.authenticate(Mockito.any(UsernamePasswordAuthenticationToken.class))).thenReturn(authentication);
//        String json = mapper.writeValueAsString(loginRequest);
//        mockMvc.perform(post("/login").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk()).andExpect(jsonPath("$.authenticated").value("true")).andExpect(jsonPath("$.accessToken").isNotEmpty());
//
//        // Test when user 2fa is enabled
//        user.setUsing2FA(true);
//        mockMvc.perform(post("/login").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk()).andExpect(jsonPath("$.authenticated").value("false")).andExpect(jsonPath("$.user").doesNotExist());
//    }

    private User getUser() {
        User employee = new User();
        employee.setId(1);
        employee.setUsername("Mahesh");
        employee.setRoles("User");
        employee.setPassword("mah@123");
        employee.setEmail("mahesh@test.com");
        employee.setMobile("12345678");
     //   employee.setIs_kyc_done(true);
        return employee;
    }

    private static String asJson(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


//    @BeforeEach
//    public void setup(){
//    mvc = MockMvcBuilders.standaloneSetup(userResource)
//            .build();
//}
//
//    @Test
//    public void loginTest() throws Exception {
//        AuthenticationRequest request = new AuthenticationRequest("kk@gmail.com","kvk@123");
//        User customer = new User();
//        customer.setEmail("kk@gmail.com");
//        customer.setPassword("kvk@123");
//        customer.setRoles("USER");
//        customer.setId(1);
//
//        UserDetails userDetails = new MyUserDetails(customer);
//
//        Mockito.when(mockUserDetailsService.loadUserByUsername(Mockito.any(String.class))).thenReturn(userDetails);
//
//        Mockito.when(mockUserDetailsService.loadUserByUsername(Mockito.any(String.class))).thenReturn(userDetails);
//        MockHttpServletResponse response = mvc.perform(
//               post("/login").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(request))
//                        .accept(MediaType.APPLICATION_JSON))
//                        .andReturn().getResponse();
//
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//    }