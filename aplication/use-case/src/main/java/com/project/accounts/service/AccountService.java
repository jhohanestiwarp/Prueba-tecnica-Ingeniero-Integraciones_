package com.project.accounts.service;

import com.project.account.Account;
import com.project.accounts.AccountUseCaseImpl;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountService {

    private final AccountUseCaseImpl accountUseCase;

    public AccountService(AccountUseCaseImpl accountUseCase) {
        this.accountUseCase = accountUseCase;
    }

    public Mono<Account> createAccount(Account account, String username, String channel) {
        return accountUseCase.createAccount(account, username, channel);
    }

    public Mono<Account> updateAccount(Long id, Account account) {
        return accountUseCase.updateAccount(id, account);
    }

    public Flux<Account> getAllAccounts(Long bankId, String type) {
        return accountUseCase.getAllAccounts(bankId, type);
    }

    public Mono<Boolean> deleteAccount(Long id) {
        return accountUseCase.deleteAccount(id);
    }
}
