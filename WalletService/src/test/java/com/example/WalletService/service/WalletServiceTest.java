package com.example.WalletService.service;

import com.example.WalletService.Model.Wallet;
import com.example.WalletService.Repository.WalletRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


//import id.test.springboottesting.exception.UserRegistrationException;
//import id.test.springboottesting.model.User;
//import id.test.springboottesting.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@SpringBootTest


class WalletServiceTest {
    @Mock
    private WalletRepository walletRepository;

    @InjectMocks
    private WalletService walletService;

    @Test
    void createWalletTest() {

            final Wallet user = new Wallet(5, 5, 1000,true,"open");

            // given(userRepository.findByEmail(user.getEmail())).willReturn(Optional.empty());
            given(walletRepository.save(user)).willAnswer(invocation -> invocation.getArgument(0));

            Wallet savedUser = walletService.createWallet(user);

            assertThat(savedUser).isNotNull();

            verify(walletRepository).save(any(Wallet.class));

    }

//    @Test
//    void updateWalletTest() {
//        final Wallet user = new Wallet(1, 1,1000,true,"open");
//
//        given(walletRepository.save(user)).willReturn(user);
//
//        final Wallet expected = walletService.updateWallet(user);
//
//        assertThat(expected).isNotNull();
//
//        verify(walletRepository).save(any(Wallet.class));
//    }
}