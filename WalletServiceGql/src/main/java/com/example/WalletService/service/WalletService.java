package com.example.WalletService.service;

import com.example.WalletService.Model.Wallet;
import com.example.WalletService.Repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    public Wallet createWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    public Wallet updateWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    public Optional<Wallet> findWalletById(int id) {
        return walletRepository.findById(id);
    }


}
