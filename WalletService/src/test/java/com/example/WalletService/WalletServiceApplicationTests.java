package com.example.WalletService;

import com.example.WalletService.Model.AddBalanceDetails;
import com.example.WalletService.Model.Transaction;
import com.example.WalletService.Model.Wallet;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class WalletServiceApplicationTests {

	@Test
	void createWalletTest1() {
		Wallet info = new Wallet(1,1,1000,true,"open");
		String test= info.toString();
		assertTrue(test.matches(1+"\n"+1+"\n"+1000+"\n"+true+"\n"+"open"));
	}

//	@Test
//	void createWalletTest2() {
//		Wallet info = new Wallet(1,1,1000,true,"open");
//		String test= info.toString();
//		assertTrue(test.matches(1+"\n"+2+"\n"+1000+"\n"+true+"\n"+"open"));
//	}

	@Test
	void addBalanceTest1() {
		AddBalanceDetails info = new AddBalanceDetails(1,1000);
		String test= info.toString();
		assertTrue(test.matches(1+"\n"+1000));
	}

//	@Test
//	void addBalanceTest2() {
//		AddBalanceDetails info = new AddBalanceDetails(1,1000);
//		String test= info.toString();
//		assertTrue(test.matches(2+"\n"+1000));
//	}
//
//	@Test
//	void sendMoneyTest1() {
//		Transaction info = new Transaction(1,1000,1,2,null,"susccess");
//		String test= info.toString();
//		assertTrue(test.matches(1+"\n"+1000+"\n"+1+"\n"+2+"\n"+null+"\n"+"success"));
//	}

//	@Test
//	void sendMoneyTest2() {
//		Transaction info = new Transaction(1,1000,1,2,null,"susccess");
//		String test= info.toString();
//		assertTrue(test.matches(1+"\n"+1000+"\n"+2+"\n"+1+"\n"+null+"\n"+"success"));
//	}

}
