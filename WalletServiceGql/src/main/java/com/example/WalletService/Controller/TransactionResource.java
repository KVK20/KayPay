package com.example.WalletService.Controller;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.WalletService.Model.*;
import com.example.WalletService.Repository.TransactionRepository;
import com.example.WalletService.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class TransactionResource implements GraphQLQueryResolver {

    Logger loggers = LoggerFactory.getLogger(TransactionResource.class);

    @Autowired
    private TransactionRepository transactionRepository;


    public Optional<Transaction> getBalById(int id) {
        return transactionRepository.findById(id);

    }

}