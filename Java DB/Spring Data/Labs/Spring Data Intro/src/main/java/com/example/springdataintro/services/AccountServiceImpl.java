package com.example.springdataintro.services;

import com.example.springdataintro.models.Account;
import com.example.springdataintro.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Override
    public void withdrawMoney(BigDecimal money, Long id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);

        if (optionalAccount.isEmpty()) {
            throw new IllegalArgumentException("Account is missing");
        }

        Account account = optionalAccount.get();
        BigDecimal newAmount = account.getBalance().subtract(money);

        if (newAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Not enough money");
        }

        account.setBalance(newAmount);

        accountRepository.save(account);
    }

    @Override
    public void transferMoney(BigDecimal money, Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account is missing"));

        if (money.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Cannot transfer negative money");
        }

        BigDecimal newBalance = account.getBalance().add(money);
        account.setBalance(newBalance);

        accountRepository.save(account);
    }
}
