package com.example.WalletService.Controller;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.WalletService.Model.*;
import com.example.WalletService.Repository.*;
import com.example.WalletService.Util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class WalletResource  implements GraphQLQueryResolver{

    Logger loggers = LoggerFactory.getLogger(WalletResource.class);

    @Autowired
    private WalletRepository walletRepository;


    WalletValidator walletValidator = new WalletValidator();
    private static final Logger logger = LoggerFactory.getLogger(WalletResource.class);

    //finds list of all wallet
    public List<Wallet> getAllWallet() {
        return (List<Wallet>) walletRepository.findAll();
    }

    //finds wallet based on id's
    public Optional<Wallet> getWalletById(int id) {
        return walletRepository.findById(id);

    }


}