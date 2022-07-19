package com.example.WalletService;


//import com.example.WalletService.Model.Wallet;
import com.example.WalletService.Model.Wallet;
import com.example.WalletService.Repository.WalletRepository;
import com.example.WalletService.service.WalletService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class WalletServiceApplicationTests {


	@Mock
	private WalletRepository walletRepository;

	@InjectMocks
	private WalletService walletService;




	@Test
	void createWalletTest() {

		final Wallet wallet = new Wallet(5, 1, 50000,true,"savings");
		// given(userRepository.findByEmail(user.getEmail())).willReturn(Optional.empty());
		given(walletRepository.save(wallet)).willAnswer(invocation -> invocation.getArgument(0));
		Wallet savedUser = walletService.createWallet(wallet);
		assertThat(savedUser).isNotNull();
		verify(walletRepository).save(any(Wallet.class));

	}

	@Test
	void updateWallet() {
		final Wallet wallet = new Wallet(1, 1,20000,true,"savings");

		given(walletRepository.save(wallet)).willReturn(wallet);

		final Wallet expected = walletService.updateWallet(wallet);

		assertThat(expected).isNotNull();

		verify(walletRepository).save(any(Wallet.class));
	}


	@Test
	void findWalletById(){
		final int id = 1;
		final Wallet wallet = new Wallet(5, 1, 15781,true,"current");

		given(walletRepository.findById(id)).willReturn(Optional.of(wallet));

		final Optional<Wallet> expected  =walletService.findWalletById(id);

		assertThat(expected).isNotNull();

	}

}
