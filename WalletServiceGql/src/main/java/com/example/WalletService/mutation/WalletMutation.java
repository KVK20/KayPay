package com.example.WalletService.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.WalletService.Model.AddBalanceDetails;
import com.example.WalletService.Model.Wallet;
import com.example.WalletService.Repository.WalletRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WalletMutation implements GraphQLMutationResolver {

    @Autowired
    private WalletRepository walletRepository;


    //creates wallet
    public Wallet createWallet(final int user_id,final int balance,final Boolean is_active){
        log.info("Add Wallet: {}, {}, {}",user_id,balance,is_active);
        return walletRepository
                .save(Wallet.builder()
                        .user_id(user_id)
                        .balance(balance)
                        .is_active(is_active)
                        .build());
    }

    //updates the wallet
    public Wallet updateWallet(final int id,final int user_id,final int balance,final Boolean is_active) {
        log.info("Update Wallet: {}, {}, {}, {}",id,user_id,balance,is_active);
        Wallet wallet = new Wallet();
        wallet.setId(id);
        wallet.setUser_id(user_id);
        wallet.setBalance(balance);
        wallet.setIs_active(is_active);
        return walletRepository.saveAndFlush(wallet);
    }


    public AddBalanceDetails addBalance(final int uid, final int amount){
        AddBalanceDetails add = new AddBalanceDetails();
        add.setUid(uid);
        add.setAmount(amount);
      return add;
    }

}
