package com.project.accounts.service;

import com.project.account.AccountDto;
import com.project.accounts.AccountUseCaseImpl;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class AccountService {

    private final AccountUseCaseImpl accountUseCase;

    public AccountService(AccountUseCaseImpl accountUseCase) {
        this.accountUseCase = accountUseCase;
    }

    public Mono<AccountDto> createAccount(AccountDto accountDto) {
        return accountUseCase.createAccount(accountDto);
    }

    public Mono<AccountDto> updateAccount(String id, AccountDto accountDto) {
        return accountUseCase.updateAccount(id, accountDto);
    }

    public Flux<AccountDto> getAllAccounts(String bankId, String type) {
        return accountUseCase.getAllAccounts(bankId, type);
    }

    public Mono<Boolean> deleteAccount(String id) {
        return accountUseCase.deleteAccount(id);
    }
}
