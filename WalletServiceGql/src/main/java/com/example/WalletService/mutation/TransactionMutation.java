package com.example.WalletService.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.WalletService.Model.AddBalanceDetails;
import com.example.WalletService.Model.Transaction;
import com.example.WalletService.Repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Slf4j
@Component
public class TransactionMutation implements GraphQLMutationResolver {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction sendMoney(final int amount, final int sid, final int rid, final String date, final String status){
        log.info("Send Money: {}, {}, {}, {}, {}",amount,sid,rid,date,status);
        return transactionRepository
                .save(Transaction.builder()
                        .amount(amount)
                        .sid(sid)
                        .rid(rid)
                        .date(date)
                        .status(status)
                        .build());
    }


}
