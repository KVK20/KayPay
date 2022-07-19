package com.example.WalletService.service;


import com.example.WalletService.Model.Transaction;
import com.example.WalletService.Model.Wallet;
import com.example.WalletService.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

   // public Wallet createWallet(Wallet wallet) {
//        return walletRepository.save(wallet);
//    }

    public Transaction addBalance(Transaction transaction){
        return transactionRepository.save(transaction);
    }
}
